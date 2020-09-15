<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html lang="en">

<tiles:insertAttribute name="header" />

<body>

    <div class="wrapper">

        <div class="sidebar" data-color="black">
            <tiles:insertAttribute name="menu" />
        </div>

        <div class="main-panel">

            <tiles:insertAttribute name="navbar" />

            <tiles:insertAttribute name="body" />

            <div class="col patern-loader mt-5" style="display: none">
                <div class="col-md-12">
                    <div class="loader">
                        <div class="loader-inner box1"></div>
                        <div class="loader-inner box2"></div>
                        <div class="loader-inner box3"></div>
                    </div>
                </div>
                <div class="col-md-12"><h5 id="info-loader" style="text-align: center"></h5></div>
            </div>

        </div>

    </div>

    <tiles:insertAttribute name="footer" />


<script>
    $( ".form-check-sign" ).on( "click", function() {
        var check = $( this ).attr('id');
        $('form-check-input-' + check).val(true);
    });

    var selectpickerIsClicked = false;

    $(function () {

        $('#select-formatos').selectpicker({
            container: 'body',
            dropupAuto: false
        });

        $('#select-empresas').selectpicker({
            container: 'body',
            dropupAuto: false
        });

        $('#select-localidades').selectpicker({
            container: 'body',
            dropupAuto: false
        });

        $('#select-medios').selectpicker({
            container: 'body',
            dropupAuto: false
        });


        $('#select-provincias').selectpicker({
            container: 'body',
            dropupAuto: false
        });


        $('#select-elementos').selectpicker({
            container: 'body',
            dropupAuto: false
        });

        $('#select-estados').selectpicker({
            container: 'body',
            dropupAuto: false,
            liveSearch: false
        });

        $('#select-geolocalizacion').selectpicker({
            container: 'body',
            dropupAuto: false,
            liveSearch: false
        });

        $('#select-maxResults').selectpicker({
            container: 'body',
            dropupAuto: false,
            liveSearch: false
        });

        $('.dropdown-menu').on('click', function (e) {
            if ($(e.target).closest('.bootstrap-select.open').is(':visible') || $(e.target).closest('.btn.dropdown-toggle').is(':visible')) {
                selectpickerIsClicked = true;
            }
        });

        // when the dialog is closed....
            $('.dropdown').on('hide.bs.dropdown', function (e) {
            if (selectpickerIsClicked) {
                e.preventDefault();
                selectpickerIsClicked = false;
            }
        });
    });


    $(document).ready(function(){
        $( ".load-data" ).on( "click", function() {
            $(".content").hide();
            $("#info-loader").text("Buscando datos...");
            $(".patern-loader").fadeIn('slow');
        });

        $( ".save-data" ).on( "click", function() {
            $(".content").hide();
            $("#info-loader").text("Guardando monitoreo...");
            $(".patern-loader").fadeIn('slow');
        });

        var moreToolsOptions = $('.more-options').clone();
        moreToolsOptions.css('display', 'inline');
        moreToolsOptions.appendTo('#tools-button');

        $('#select-empresas').selectpicker('val', ${ubicacionRequest.empresasSelected});
        $('#select-elementos').selectpicker('val', ${ubicacionRequest.elementosSelected});
        $('#select-formatos').selectpicker('val', ${ubicacionRequest.formatosSelected});
        $('#select-medios').selectpicker('val', ${ubicacionRequest.mediosSelected});
        $('#select-localidades').selectpicker('val', ${ubicacionRequest.localidadesSelected});
        $('#select-provincias').selectpicker('val', ${ubicacionRequest.provinciasSelected});
        $('#select-estados').selectpicker('val' , ${ubicacionRequest.estadoSelected});
        $('#select-geolocalizacion').selectpicker('val' , ${ubicacionRequest.geolocalizacionSelected});
        $('#select-maxResults').selectpicker('val' , ${ubicacionRequest.maxResultsSelected});
        $('#input-ids').val(${ubicacionRequest.idsSearching});

    });

    function showOptions() {
        $('.dt-buttons').slideToggle( 500, function(){

            var text = $('#span-more-options').html();

            if(text === '&nbsp;Mas Opciones'){
                $('#icon-options').removeClass('nc-simple-add').addClass('nc-simple-remove');
                $('#span-more-options').html('&nbsp;Cerrar Opciones');
            }

            else {
                $('#icon-options').removeClass('nc-simple-remove').addClass('nc-simple-add');
                $('#span-more-options').html('&nbsp;Mas Opciones');
            }

        } );
    }


        $( "#arrowUp" ).click(function() {
        $( ".table-ubicaciones" ).animate({
            marginTop: "-60vh",
            opacity: 1
        }, 500 );

        $( "#arrowUp" ).hide();
        $( "#arrowDown" ).show();
    });


    $( "#arrowDown" ).click(function() {
        $( ".table-ubicaciones" ).animate({
            marginTop: "-15vh",
            opacity: 0.9
        }, 500 );

        $( "#arrowDown" ).hide();
        $( "#arrowUp" ).show();
    });


    $('#collapseExample').on('hidden.bs.collapse', function () {
        // do something…
        $( ".main-panel" ).animate({
            width: "100%"
        }, 100 );

        $( ".sidebar" ).animate({
            width: "0px"
        }, 300 );

        buttonHideShowMenu();
    });


    $('#collapseExample').on('show.bs.collapse', function () {
        $( ".main-panel" ).animate({
            width: "80%"
        }, 100 );

        $( ".sidebar" ).animate({
            width: "260px"
        }, 300 );

        buttonHideShowMenu();

    });

    function buttonHideShowMenu() {
        var text = $('#span-close-option').html();

        if(text === '&nbsp;Ocultar Menu'){
            $('.container').css('max-width', '100%');
            $('#icon-close-menu').removeClass('nc-stre-left').addClass('nc-stre-right');
            $('#span-close-option').html('&nbsp;Mostrar Menu');
        }

        else {
            $('#icon-close-menu').removeClass('nc-stre-right').addClass('nc-stre-left');
            $('#span-close-option').html('&nbsp;Ocultar Menu');
        }
    }

</script>
<script>

    function selectAll() {
        var inputCheckAll = document.getElementById('checkbox-all');
        var inputs = document.getElementsByClassName("form-check-input");

        if(inputCheckAll.checked){
            iterateInputWithValue(inputs, true);
        }
        else {
            iterateInputWithValue(inputs, false);
        }
    }

    function iterateInputWithValue(inputs, checked) {
        for (var i = 0; i < inputs.length; i++) {
            var input = inputs[i];
            input.checked = checked;
        }
    }


</script>

</body>
</html>
