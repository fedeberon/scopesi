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
    $('.content').css('opacity', '0.3');

    $.ajax( {
        url: '/api/ubicacion/' + id,
        dataType: 'json',
        success: function(data) {
            $('.data-ubicacion').empty();

            var tableUbicacionInfo = createTableUbicacionInformation(data);

            var idEmpresa = $('<input>', {
                type : 'hidden',
                value : data.mapEmpresa.id,
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
                        'data-caption': data.mapEmpresa.descripcion,
                        'data-fancybox':'gallery',
                        'data-buttons' : '["slideShow","fullScreen","thumbs","fb","close"]'
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
            $('.content').css('opacity', '1');
            $('#modal-info-marker').modal('show');

        }
    });
}

function showImages() {

    $.fancybox.defaults.btnTpl.fb = '<button style="font-size: small" data-fancybox-fb class="fancybox-button fancybox-button--fb" title="Delete">' +
        '<svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="trash" class="svg-inline--fa fa-trash fa-w-14" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 750 512">' +
        '<path fill="currentColor" d="M432 32H312l-9.4-18.7A24 24 0 0 0 281.1 0H166.8a23.72 23.72 0 0 0-21.4 13.3L136 32H16A16 16 0 0 0 0 48v32a16 16 0 0 0 16 16h416a16 16 0 0 0 16-16V48a16 16 0 0 0-16-16zM53.2 467a48 48 0 0 0 47.9 45h245.8a48 48 0 0 0 47.9-45L416 128H32z"></path>' +
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
    td.append(data.mapEmpresa.descripcion);
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
            $("#" + id + "-lat").html(data.location.lat);
            $("#" + id + "-lon").html(data.location.lng);

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




function guardarCoordenadas(id) {
    var lat = $("#" + id + "-lat").html();
    var lng  = $("#" + id + "-lon").html();
    var dataToSend = { "id": id, "latitud": lat, "longitud": lng };

    let dataJson = JSON.stringify(dataToSend);
    $.ajax( {
        url: '/api/updateCoordenadas',
        type: "post",
        dataType: 'json',
        data: dataJson,
        beforeSend: function () {
            $("#icon-" + id).removeClass("fa-bars").addClass("fa-cog fa-spin");
            $("#" + id + "-save").html('Guardando');
        },
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success:  function (data) {
            $("#icon-" + id).removeClass("fa-cog fa-spin").addClass("fa-bars");
            $("#" + id + "-save").hide();
            $("#" + id + "-update").show();
            $("#" + id + "-save").html('Guardar');

            $.notify({
                title: '<strong>Geolocalizacion Guardada !</strong>',
                message: 'La nueva posicion del punto seleccionado es lat:' + data.latitud + '. , lng: .' + data.longitud
            }, {
                timer: 8000
            });


        },
        error: function (jqXHR, exception) {
            console.log(jqXHR);
            // Your error handling logic here..
        }
    });

}