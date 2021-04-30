/**
 * Created by federicoberon on 19/11/2019.
 */

var emptyImages = false;

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
            $('.load').hide();
            $('.modal-body').css('opacity', '1');

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

function createCarousel(idUbicacion , idEmpresa , empresa){
    $('.data-ubicacion').html("");
    $('.load').show();
    $('.map-container').css('opacity', '0.3');
    $('.content').css('opacity', '0.3');

    var url = 'http://geoplanningmas.com/ar/v2/apifiles/file';
    var pathsArray = getAllFilesPathOfParam(url , idEmpresa);

    pathsArray = filterFilesPath(pathsArray, idUbicacion);

    var fileNameArray = getFileNames(pathsArray);

    var urlsArray = pathsArray.map(function (path) {
        path.includes("(") || path.includes(")") ? path = path.replace(/\(/g, '%28').replace(/\)/g, '%29') : path;
        return url + path;
    });

    if(urlsArray.length === 0){
        emptyImages = true;
    }else{
        emptyImages = false
    }

    var idEmpresaVar = $('<input>', {
        type : 'hidden',
        value : idEmpresa,
        id : 'idEmpresa'
    });
    idEmpresaVar.appendTo('.data-ubicacion');

    var idUbicacionVar = $('<input>', {
        type : 'hidden',
        value : idUbicacion,
        id : 'idUbicacion'
    });
    idUbicacionVar.appendTo('.data-ubicacion');

    var empresaVar = $('<input>', {
        type : 'hidden',
        value : empresa,
        id : 'empresa'
    });
    empresaVar.appendTo('.data-ubicacion');



    for (var i = 0; i < urlsArray.length; i++) {
        var a = $('<a>',{
            class : 'fancybox hidden',
            rel : 'group',
            href: urlsArray[i],
            'data-caption': fileNameArray[i] + " - " + empresa,
            'data-fancybox':'gallery',
            'data-buttons' : '["slideShow","fullScreen","thumbs","fb","close"]'
        });
        var img = $('<img>',{
            src: urlsArray[i]
        });
        a.append(img);
        a.appendTo('.data-ubicacion');
    }

    $('.load').hide();
    $('.map-container').css('opacity', '1');
    $('.content').css('opacity', '1');
    $('#modal-info-marker').modal('show');

}

function createCarouselUser(idUsuario){
    $('.data-auditapp').html("");
    $('.load').show();
    $('.map-container').css('opacity', '0.3');
    $('.content').css('opacity', '0.3');

    var urlBase ='http://geoplanningmas.com/ar/v2/apifiles/';
    var urlGetAll = urlBase + 'fotos_app';
    var pathsArray = getAllFilesPathOfParam(urlGetAll , idUsuario);

    var fileNameArray = getFileNames(pathsArray);

    var urlsArray = pathsArray.map(function (path) {
        return urlBase + path;
    });

    if(urlsArray.length === 0){
        emptyImages = true;
    }else{
        emptyImages = false
    }

    for (var i = 0; i < urlsArray.length; i++) {
        var a = $('<a>',{
            class : 'fancybox hidden',
            rel : 'group',
            href: urlsArray[i],
            'data-caption': fileNameArray[i],
            'data-fancybox':'gallery',
            'data-buttons' : '["slideShow","fullScreen","thumbs","fb","close"]'
        });
        var img = $('<img>',{
            src: urlsArray[i]
        });
        a.append(img);
        a.appendTo('.data-auditapp');
    }
}

function getAllFilesPathOfParam(url , param) {

    var pathsArray = [];

    $.ajax({
        url: url + '/' + param,
        dataType: 'json',
        async: false,
        success: function (data) {
            pathsArray = getFilesPath(data);
        },
        error: function () {
            $('.load').hide();
            $('.map-container').css('opacity', '1');
            $('.content').css('opacity', '1');

            $.notify({
                title: '<strong>Hubo un problema!</strong>',
                message: 'Se produjo un error al buscar las imagenes de la ubicacion.'
            }, {
                type: 'danger'
            });
        }
    });

    return pathsArray;
}

function getFilesPath(absolutePathsArray) {
    /* The first group on this regex matches the path needed of an absolute paths string */
    var regexPath = /fotos_map([/].*([.]jpg|[.]png|[.]mp4))/;

    /* Returns paths that matched and deletes from array the ones that don't */
    return absolutePathsArray.map(function (path) {
        if (regexPath.test(path)) {
            return path.match(regexPath)[1];
        }
    }).filter(function (i) {
        return i;
    });
}

function filterFilesPath(pathsArray , idUbicacion) {
    /* The group on this regex matches the numbers found in the path of the file, this numbers is referring to idUbicacion */
    var regexIdUbicacion = /[/].+[/]([0-9]*)[\s]{0,1}/;

    return pathsArray.filter(function (path) {
        return path.match(regexIdUbicacion)[1] === idUbicacion;
    });
}

function getFileNames(pathsArray){
    /* The group on this regex matches the full file name on the path */
    var regexNameUbicacion = /[/].+[/](.*)/;

    return pathsArray.map(function (path) {
        return path.match(regexNameUbicacion)[1];
    });
}

function showImages() {
    if(emptyImages === true){

        $.notify({
            title: '<strong>Ups!</strong>',
            message: 'No hay imagenes cargadas para esta ubicacion!'
        }, {
            timer: 8000,
            z_index: 2031
        });
    }
    $.fancybox.defaults.btnTpl.fb = '<button style="font-size: small" data-fancybox-fb onclick="initDeleteFile()" class="fancybox-button fancybox-button--fb" title="Delete">' +
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


function initDeleteFile() {
    var idUbicacion = document.querySelector("#idUbicacion").value;
    var idEmpresa = document.querySelector("#idEmpresa").value;
    var empresa = document.querySelector("#empresa").value;

    var src = $.fancybox.getInstance().current.src;
    var url = src.split('/');
    var fileName = url[url.length - 1];

    $("#modal-confirmacion").modal('show');

    var functionSuccess =   function (){
        $('#myModal2').modal('hide');
        createCarousel(idUbicacion , idEmpresa , empresa);
    };

    modalConfirm2(function(confirm){
        if(confirm){
            //Acciones si el usuario confirma
            deleteFile(idEmpresa,fileName, functionSuccess);
            $("#modal-confirmacion").modal('hide');
            $.fancybox.close();

        } else {
            //Acciones si el usuario no confirma
            $("#modal-confirmacion").modal('hide');
        }
    });
}


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


function deleteFile(idEmpresa, fileName, functionSuccess) {

    var url = 'http://geoplanningmas.com/ar/v2/apifiles/file/' + idEmpresa + '/' + fileName;

    $.ajax( {
        url: url,
        type: "DELETE",
        success:  function (response) { //una vez que el archivo recibe el request lo procesa y lo devuelve
            $("#resultado").html(response);
            functionSuccess;

            $.notify({
                title: '<strong>Archivo borrado correctamente</strong>',
                message: 'Por favor actualice la pagina para visualizar los cambios.'
            }, {
                z_index:2000
            });
        },
        error:function (e){
            $('#myModal2').modal('hide');

            $.notify({
                title: '<strong>Hubo un problema!</strong>',
                message: 'Se produjo un error al intentar borrar la imagen.'
            }, {
                timer: 'none',
                z_index:2000,
                type: 'danger'
            });
        }
    });
}

function modificarCoordenadas(id) {

    deleteMarker(id);   var lat = map.getCenter().lat();
    var lng = map.getCenter().lng();
    console.log(lat);
    console.log(lng);

    var latLong = new google.maps.LatLng(lat, lng);

    var marker = new google.maps.Marker({
        id: id,
        position: latLong,
        map: map,
        draggable: true,
        animation: google.maps.Animation.DROP
    });

    marker.addListener('dragend', function(event){

        $("#mi-modal").modal('show');

        modalConfirm(function(confirm){
            if(confirm){
                //Acciones si el usuario confirma
                handleEventToUpdate(event, marker);

            } else {
                //Acciones si el usuario no confirma
                $("#mi-modal").modal('hide');
            }
        });
    });
}


function actualizarCoordenadas(id, address, localidad, provincia ){
    var addressToReverseGeocoding;
    /*this if/else statement is building the 'addressToReverseGeocoding' variable
      depending on 'localidad' or 'provincia' are emptys.*/
    if(localidad !== undefined && provincia !== undefined){
        addressToReverseGeocoding = address + ',' + localidad + ',' + provincia;
    }else if(provincia !== undefined){
        addressToReverseGeocoding = address + ',' + provincia;
    }else if (localidad !== undefined){
        addressToReverseGeocoding = address + ',' + localidad;
    }else{
        addressToReverseGeocoding = address;
    }

    var dataToSend = {
        "address": addressToReverseGeocoding
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
                class: "marker",
                position: latLong,
                map: map,
                draggable: true,
                animation: google.maps.Animation.DROP

            });

            marker.addListener('dragend', function(event){

                $('#'+id+'-lat').html(event.latLng.lat());
                $('#'+id+'-lng').html(event.latLng.lng());

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
    var isMapObject = /map/;
    var ajaxUrl = '';
    var lat = $("#" + id + "-lat").html();
    var lng  = $("#" + id + "-lon").html();
    var dataToSend = { "id": id, "latitud": lat, "longitud": lng };

    var dataJson = JSON.stringify(dataToSend);

    for (var i = 0; i < markers.length; i++) { //this for statement is for check if object is MapUbicacion or AppUbicacionRelevamiento and set the correct url.
        if (markers[i].id == id) {
            if(isMapObject.test(markers[i].title)){
                ajaxUrl = '/api/updateCoordenadas';
            }else{
                ajaxUrl = '/api/updateCoordenadasApp'
            }
        }
    }

    $.ajax( {
        url: ajaxUrl,
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
            $.notify({
                title: '<strong>Hubo un problema!</strong>',
                message: 'Se produjo un error al intentar guardar la nueva posicion.'
            }, {
                type: 'danger'
            });
        }
    });

}

function guardarPoligono(id , polygon) {

    var polygonCoords = [];

    if (polygon.id === id) {
        for (var i = 0; i < polygon.getPath().getLength(); i++) {
            var onePolygon = { //vertices
                'lat': polygon.getPath().getAt(i).lat(),
                'lng': polygon.getPath().getAt(i).lng()
            };
            polygonCoords.push(onePolygon);
        }

        var dataToSend = {"id": id, 'polygonLatLong': JSON.stringify(polygonCoords)};

        var dataJson = JSON.stringify(dataToSend);

        $.ajax({
            url: '/api/savePolygon',
            type: "POST",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: dataJson,

            success: function (data) {

                $.notify({
                    title: '<strong>Poligono guardado exitosamente!</strong>',
                    message: 'Se ha persistido correctamente el poligono para el registro: ' + data.id
                }, {
                    type: 'success',
                    timer: 8000
                });

            },
            error: function (data) {
                $.notify({
                    title: '<strong>Hubo un problema!</strong>',
                    message: 'Se produjo un error al intentar guardar el poligono.'
                }, {
                    type: 'danger'
                });
            }
        });

    }

}

var stopDrawing = true;

var polygonsArray = [];

function initDrawingControl(element , id){

    stopDrawing = !stopDrawing;

    var drawingManager = new google.maps.drawing.DrawingManager({
        drawingMode: google.maps.drawing.OverlayType.POLYGON,
        drawingControl: true,
        drawingControlOptions: {
            position: google.maps.ControlPosition.TOP_RIGHT,
            drawingModes: ['polygon']
        },
        polygonOptions: {
            id: id,
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
        polygonsArray.push(polygon);

        $("#modal-confirm-polyg").modal('show');

        modalConfirm3(function(confirm){
            if(confirm){
                guardarPoligono(id , polygon);
                document.getElementById('info').innerHTML = "";
                drawingManager.setMap(null);

            } else {
                polygon.setMap(null)
                drawingManager.setMap(null);
                document.getElementById('info').innerHTML = "";
                polygon.id = null;
            }
        });
    });
}

var polygons = [];

function initPolygon(element ,id ){

    var coordinates = $('#pol-' + id).val();
    var jsonCoordinates = JSON.parse(coordinates);

    // Construct the polygon.
    var poligono = new google.maps.Polygon({
        id: id,
        paths: jsonCoordinates,
        strokeColor: '#FF0000',
        strokeOpacity: 0.8,
        strokeWeight: 3,
        fillColor: '#FF0000',
        fillOpacity: 0.35,
        visible: true
    });

    polygons.push(poligono);
    poligono.setMap(map);

    poligono.addListener('click', function (event) {

        var contentString = '<b>Poligono seleccionado: </b>'+ this.id + '<br>' + '<br>' + '<button onclick="disablePolygon(' + this.id + ')"><i class="fas fa-eye-slash"></i>Ocultar poligono</button>';

        infoWindow.setContent(contentString);
        infoWindow.setPosition(event.latLng);

        infoWindow.open(map);

    });

    infoWindow = new google.maps.InfoWindow;

}

function disablePolygon(id) {
    var i;
    for (i = 0; i < polygons.length; i++) {
        if (polygons[i].id == id) {
            var polygon = polygons[i];
            polygon.setVisible(false);
            infoWindow.close(map);
        }
    }

}


function showPassword() {
    var x = document.getElementById("inputPassword");

    if (x.type === "password") {
        x.type = "text";
        $('#showPassword').removeClass("fa-eye").addClass("fa-eye-slash");
    } else {
        x.type = "password";
        $('#showPassword').removeClass("fa-eye-slash").addClass("fa-eye");
    }
}

function submitEdit(id) {

    $("#wrapperId").val(id);

    $("#sudmit-" + id).click();
}

function deletePolygon(idUbicacion) {

    var dataToSend = {
        "idUbicacion": idUbicacion
    };

    $.ajax({
        url: '/map/deletePolygon',
        type: "POST",
        dataType: 'json',
        data: dataToSend,

        success: function () {
            $.notify({
                title: '<strong>Poligono borrado exitosamente!</strong>',
                message: 'Se ha borrado correctamente el poligono!'
            }, {
                type: 'success',
                timer: 8000
            });

        },
        error: function (data, textStatus, jqXHR) {
            $.notify({
                title: '<strong>Hubo un problema!</strong>',
                message: 'Se produjo un error al intentar borrar el poligono.'
            }, {
                type: 'danger'
            });
        }
    });
}

function openModal(id){
    $('#' + id ).modal('show')
}

function closeModal(id){
    $('#' + id ).modal('hide')
}

function actualizarEntidades(){

    $('.modal-body').css('opacity', '0.3');
    $('.load').show();

    var poiSectorSelected = $('#select-poiSectores').val().toString();

    if(poiSectorSelected === ""){
        $('.load').hide();
        $('.modal-body').css('opacity', '1');

        $.notify({
            title: '<strong>Error al filtrar Entidades!</strong>',
            message: 'Por favor seleccione al menos un [POIs Sector].'
        }, {
            type: 'warning',
            z_index: 2031
        });

        return;
    }

    var dataToSend = {
        "poiSectorDescripciones" : poiSectorSelected
    };

    $.ajax({
        url: '/poi/findEntidad',
        type: "POST",
        dataType: 'json',
        data: dataToSend,

        success: function( data ) {
            $('.load').hide();
            $('.modal-body').css('opacity', '1');

            var selectPoiEntidad = document.getElementById("select-poiEntidades");
            var selectPoiEntidadOptions = selectPoiEntidad.options;
            var newOptions = [];
            var lengthOptions = selectPoiEntidadOptions.length;

            for(var i = 0; i < lengthOptions; i++ ) {
                selectPoiEntidadOptions.remove(selectPoiEntidadOptions[0]);
            }

            data.map(function (option) {
                var oneOption  = {text: option.descripcion, value: option.descripcion};
                newOptions.push(oneOption);
            });

            newOptions.forEach(function(option){
                selectPoiEntidadOptions.add(new Option(option.text, option.value, option.selected))
            });

            $(selectPoiEntidad).selectpicker('refresh').trigger('change');
        },
        error: function () {
            $('.load').hide();
            $('.modal-body').css('opacity', '1');

            $.notify({
                title: '<strong>Hubo un problema!</strong>',
                message: 'Se produjo un error al intentar cargar el campo de Entidad.'
            }, {
                type: 'danger'
            });
        }

    });
}

function preventSpaceBar(event) {
    if(event.target.value === ""){
        if(event.which === 32)
        {
            event.preventDefault();
            return false;
        }
    }
}