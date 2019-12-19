/**
 * Created by federicoberon on 19/11/2019.
 */

function disabledOptionsNotFounds(){
    $('.modal-body').css('opacity', '0.3');
    $('.load').show();
    var dataToSend = {
        "empresas": document.getElementById('select-empresas').value,
        "elementos" : document.getElementById('select-elementos').value,
        "provincias": document.getElementById('select-provincias').value,
        "formatos": document.getElementById('select-formatos').value,
        "localidades" : document.getElementById('select-localidades').value,
        "medios": document.getElementById('select-medios').value
     };

    var dataJson = JSON.stringify(dataToSend);

    $.ajax({
        url:"/api/filter",
        type:"POST",
        data: dataJson,
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function( data ) {
            checkOptions('#select-empresas' , data.empresas);
            checkOptions('#select-elementos' , data.elementos);
            checkOptions('#select-provincias' , data.provincias);
            checkOptions('#select-formatos' , data.formatos);
            checkOptions('#select-localidades' , data.localidades);
            checkOptions('#select-medios' , data.medios);
            $('.load').hide();
            $('.modal-body').css('opacity', '1');
        }
    });
}

function checkOptions(selectToCheck, data){
    $( selectToCheck + ' > option').each(function() {
        $(this).removeAttr("data-subtext");
        if(!data) return;

        var exist = existValue($(this).val(), data);

        if(!exist) {
            $(this).attr("data-subtext" , "(sin datos)");
        }

    });

    $(selectToCheck).selectpicker('refresh').trigger('change');

}


/**
 *
 * @param data Array
 *  @param value
 */
function existValue(value, data){
    for(var i = 0; i < data.length; i++){
        if(data[i] === null) continue;
        if(data[i].descripcion.trim() === value.trim()){
            return true;
        }
    }
    return false;
}

function createCarrusel(id) {
    $('.load').show();
    $('.map-container').css('opacity', '0.3');
    $.ajax( {
        url: '/api/ubicacion/' + id,
        dataType: 'json',
        success: function(data) {
            $('.data-ubicacion').empty();

            var tableUbicacionInfo = createTableUbicacionInformation(data);

            var idEmpresa = $('<input>', {
                type : 'hidden',
                value : data.audEmpresa.id,
                id : 'idEmpresa'
            });
            idEmpresa.appendTo('.data-ubicacion');
            var idUbicacion = $('<input>', {
                type : 'hidden',
                value : data.id,
                id : 'idUbicacion'
            });
            idUbicacion.appendTo('.data-ubicacion');


            for (var i = 0; i < data.images.length; i++) {
                var a = $('<a>',{
                        class : 'fancybox hidden',
                        rel : 'group',
                        href: data.images[i].url,
                        'data-caption': data.audEmpresa.descripcion,
                        'data-fancybox':'gallery',
                        'data-buttons' : '["slideShow","fullScreen","thumbs","fb"]'
                    });
                var img = $('<img>',{
                   src: data.images[i].url
                });
                a.append(img);
                a.appendTo('.data-ubicacion');
            }

            tableUbicacionInfo.appendTo('.data-ubicacion');

            $('.load').hide();
            $('.map-container').css('opacity', '1');
            $('#modal-info-marker').modal('show');

        }
    });
}

function showImages() {

    $.fancybox.defaults.btnTpl.fb = '<button data-fancybox-fb class="fancybox-button fancybox-button--fb" title="Facebook">' +
        '<svg viewBox="0 0 24 24">' +
        '<path d="M22.676 0H1.324C.594 0 0 .593 0 1.324v21.352C0 23.408.593 24 1.324 24h11.494v-9.294h-3.13v-3.62h3.13V8.41c0-3.1 1.894-4.785 4.66-4.785 1.324 0 2.463.097 2.795.14v3.24h-1.92c-1.5 0-1.793.722-1.793 1.772v2.31h3.584l-.465 3.63h-3.12V24h6.115c.733 0 1.325-.592 1.325-1.324V1.324C24 .594 23.408 0 22.676 0"/>' +
        '</svg>' +
        '</button>';

    $( '[data-fancybox="gallery"]' ).fancybox({
        buttons : [
            'fb'
        ]
    });

    $.fancybox.open( $('.fancybox'), {
        touch: false
    });
}

// Make buttons clickable using event delegation
$('body').on('click', '[data-fancybox-fb]', function() {
    var idEmpresa = document.querySelector("#idEmpresa").value;
    var idUbicacion = document.querySelector("#idUbicacion").value;
    var src = $.fancybox.getInstance().current.src;
    var url = src.split('/');
    var file = url[url.length - 1];

    var functionSuccess =   function (){
        $('#myModal2').modal('close');
        createCarrusel(idUbicacion);
    };

    deleteFile(idEmpresa, file, functionSuccess);
    $.fancybox.close();
});


function createTableUbicacionInformation(data){
    var table = $('.table-data-ubicaciones').clone();

    var tr = $('<tr>');
    var td = $('<td>');
    td.append(data.audEmpresa.descripcion);
    td.appendTo(tr);

    var tdDireccion = $('<td>');
    tdDireccion.append(data.direccion);
    tdDireccion.appendTo(tr);
    tr.appendTo(table);

    var tdFormato = $('<td>');
    tdFormato.append(data.mapFormato.descripcion);
    tdFormato.appendTo(tr);
    tr.appendTo(table);

    var tdElemento = $('<td>');
    tdElemento.append(data.mapElemento.descripcion);
    tdElemento.appendTo(tr);
    tr.appendTo(table);

    return table;
}


function deleteFile(folder, file, functionSuccess) {
    var dataToSend = {
        "folder": folder,
        "file" : file
    };

    $.ajax( {
        url: '/deleteFile/',
        type: "POST",
        dataType: 'json',
        data: dataToSend,
        beforeSend: function () {
            $("#resultado").html("Procesando, espere por favor...");
        },
        success:  function (response) { //una vez que el archivo recibe el request lo procesa y lo devuelve
            $("#resultado").html(response);
            functionSuccess;
        }
    });
}



function actualizarCoordenadas(address, id){
    var dataToSend = { "address": address };

    $.ajax( {
        url: '/map/searchCoordinatesByAdress',
        type: "GET",
        dataType: 'json',
        data: dataToSend,
        beforeSend: function () {

        },
        success:  function (data) {
            $("#" + id + "-lat").append(data.location.lat);
            $("#" + id + "-lon").append(data.location.lng);

            var latLong = new google.maps.LatLng(data.location.lat, data.location.lng);
            var marker = new google.maps.Marker({
                id: id,
                position: latLong,
                map: map,
                draggable: true,
                animation: google.maps.Animation.DROP
            });

            var bounds = new google.maps.LatLngBounds();
            var myLatLng = new google.maps.LatLng(data.location.lat, data.location.lng);
            bounds.extend(myLatLng);
            map.fitBounds(bounds);
            $("#" + id + "-save").show();
            $("#" + id + "-update").hide();
        }
    });

}