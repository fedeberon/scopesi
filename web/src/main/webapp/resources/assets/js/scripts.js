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
        },
        error: function(data) {
            $.notify({
                title: '<strong>Hubo un problema!</strong>',
                message: 'Se produjo un error al intentar chequear resultados.'
            },
            {
                timer: 'none',
                z_index:2000,
                type: 'danger'
            });
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
    var idUbicacion = document.querySelector("#idUbicacion").value;
    var src = $.fancybox.getInstance().current.src;
    var url = src.split('/');
    var fileName = url[url.length - 1];

    $("#modal-confirmacion").modal('show');

    var functionSuccess =   function (){
        $('#myModal2').modal('close');
        createCarrusel(idUbicacion);
    };

    modalConfirm2(function(confirm){
        if(confirm){
            //Acciones si el usuario confirma
            deleteFile(fileName, functionSuccess);
            $("#modal-confirmacion").modal('hide');
            $.fancybox.close();

        } else {
            //Acciones si el usuario no confirma
            $("#modal-confirmacion").modal('hide');
        }
    });
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


function deleteFile(fileName, functionSuccess) {
    var dataToSend = {
        "fileName" : fileName
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



function actualizarCoordenadas(address,localidad, provincia, id){
    var newData = address + ',' + localidad + ',' + provincia ;
    var dataToSend = {
        "address": newData,
    };

    $.ajax( {
        url: '/map/searchCoordinatesByAdress',
        type: "GET",
        dataType: 'json',
        data: dataToSend,
        beforeSend: function () {

        },
        success:  function (data) {
            deleteMarker(id);

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

    var dataJson = JSON.stringify(dataToSend);
    $.ajax( {
        url: '/api/updateCoordenadas',
        type: "POST",
        dataType: 'json',
        data: dataJson,
        beforeSend: function () {
            $("#icon-" + id).removeClass("fa-bars").addClass("fa-spinner fa-spin");
            $("#" + id + "-save").html('Guardando');
        },
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success:  function (data) {
            $("#icon-" + id).removeClass("fa-spinner fa-spin").addClass("fa-bars");
            $("#" + id + "-save").hide();
            $("#" + id + "-update").show();
            $("#" + id + "-save").html('Guardar');

            $.notify({
                title: '<strong>Geolocalizacion guardada exitosamente!</strong>',
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

// function initiatePolygon() {
//     //Allowing to draw shapes in the Client Side
//     if(drawingManager.getMap()) {
//         drawingManager.setMap(null); // Used to disable the Polygon tool
//     }
//     drawingManager.setOptions({
//         drawingMode : google.maps.drawing.OverlayType.POLYGON,
//         drawingControl : true,
//         drawingControlOptions : {
//             position : google.maps.ControlPosition.TOP_CENTER,
//             drawingModes : [google.maps.drawing.OverlayType.POLYGON]
//         }
//     });
//     //Loading the drawn shape in the Map.
//     drawingManager.setMap(map);
//
//     google.maps.event.addListener(drawingManager,'polygoncomplete',function(polygon) {
//         drawPolygon(polygon);
//     });
// }
//
// function stopDrawing() {
//     drawingTool.setMap(null);
// }



function initDrawingControl(){

    var polygonArray = [];

    var drawingManager = new google.maps.drawing.DrawingManager({
        drawingMode: google.maps.drawing.OverlayType.NULL,
        drawingControl: true,
        drawingControlOptions: {
            position: google.maps.ControlPosition.TOP_RIGHT,
            drawingModes: ['polygon']
        },
        polygonOptions: {
            fillColor: '#b2b2b2',
            fillOpacity: 0.5,
            strokeWeight: 2,
            strokeColor: '#000000',
            clickable: false,
            editable: false,
            zIndex: 1
        }
    });

    drawingManager.setMap(map);


    google.maps.event.addListener(drawingManager, 'polygoncomplete', function (polygon) {
        document.getElementById('info').innerHTML += "Puntos del pol&iacute;gono:" + "<br>";
        for (var i = 0; i < polygon.getPath().getLength(); i++) {
            document.getElementById('info').innerHTML += polygon.getPath().getAt(i).toUrlValue(6) + "<br>";
        }
        polygonArray.push(polygon);

        $("#modal-confirm-polyg").modal('show');

        modalConfirm3(function(confirm){
            if(confirm){
                //Acciones si el usuario confirma
                $("#modal-confirm-polyg").modal('hide');

                //persistir en base de datos
                drawingManager.setMap(null);
                document.getElementById('info').innerHTML = null;
            } else {
                //Acciones si el usuario no confirma
                $("#modal-confirm-polyg").modal('hide');
                polygon.setMap(null);
                document.getElementById('info').innerHTML = null;


            }
        });
    });
}