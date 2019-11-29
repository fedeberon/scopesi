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

    /*$(selectToCheck).selectpicker('toggle');*/

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
            $('.modal-body').empty();

            var tableUbicacionInfo = createTableUbicacionInformation(data);

            for (var i = 0; i < data.images.length; i++) {
                var a = $('<a>',{
                        class : 'fancybox hidden',
                        rel : 'group',
                        href: data.images[i].url,
                        'data-caption': data.audEmpresa.descripcion,
                        'data-fancybox':'gallery',
                    });
                var img = $('<img>',{
                   src: data.images[i].url
                });
                a.append(img);
                a.appendTo('.modal-body');
            }

            tableUbicacionInfo.appendTo('.modal-body');

            $('.load').hide();
            $('.map-container').css('opacity', '1');
            $('#modal-info-marker').modal('show');

        }
    });
}

function showImages() {
    $.fancybox.open( $('.fancybox'), {
        touch: false
    });
}


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

