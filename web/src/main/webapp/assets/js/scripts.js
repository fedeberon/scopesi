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
            console.log(data[i].descripcion + '->' + value);
            return true;
        }
    }
    return false;
}

function createCarrusel(id) {
    $.ajax( {
        url: '/api/mapUbicacion/' + id,
        dataType: 'json',
        success: function(data) {
            var response = '',
                indicator = '';
            for (var i = 0; i < data.d.results.length; i++) {
                response += '<div class="item"><img src="' + data.images[i].url + '"></div>';
                indicator += '<li data-target="#myCarousel" data-slide-to="'+i+'"></li>';
            }
            $('#homepageItems').append(response);
            $('#indicators').append(indicator);
            $('.item').first().addClass('active');
            $('.carousel-indicators > li').first().addClass('active');
            $("#myCarousel").carousel();
        }
    });
}
