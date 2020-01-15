<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html lang="en">

<tiles:insertAttribute name="header" />


<body>

<style>

    th, td { white-space: nowrap; }
    div.dataTables_wrapper {
        width: 98%;
        margin: 0 auto;
    }

    div.ColVis {
        float: left;
    }

    .modal-content {
        margin-top: -20%;
    }


</style>

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



<!--   Core JS Files   -->
<script src="<c:url value='/resources/assets/js/core/jquery.3.2.1.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/assets/js/core/popper.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/assets/js/core/bootstrap.min.js'/>" type="text/javascript"></script>
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="<c:url value='/resources/assets/js/plugins/bootstrap-switch.js'/>"></script>
<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyANGywbfxItEbdle738SiU-AVJGIjadVYM&libraries=places"></script>
<!--  Chartist Plugin  -->
<script src="<c:url value='/resources/assets/js/plugins/chartist.min.js'/>"></script>
<!--  Notifications Plugin    -->
<script src="<c:url value='/resources/assets/js/plugins/bootstrap-notify.js'/>"></script>
<!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
<script src="<c:url value='/resources/assets/js/light-bootstrap-dashboard.js?v=2.0.0'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/assets/js/demo.js'/>"></script>
<script src="<c:url value='/resources/assets/js/paginador.js'/>"></script>
<script src="<c:url value='/resources/assets/js/scripts.js'/>"></script>
<script src="<c:url value='/resources/DataTables/DataTables-1.10.20/js/jquery.dataTables.min.js'/>"></script>
<script src="<c:url value='/resources/DataTables/JSZip-2.5.0/jszip.min.js'/>"></script>
<script src="<c:url value='/resources/DataTables/pdfmake-0.1.36/pdfmake.min.js'/>"></script>
<script src="<c:url value='/resources/DataTables/pdfmake-0.1.36/vfs_fonts.js'/>"></script>
<script src="<c:url value='/resources/DataTables/Buttons-1.6.1/js/dataTables.buttons.min.js'/>"></script>
<script src="<c:url value='/resources/DataTables/Buttons-1.6.1/js/buttons.html5.min.js'/>"></script>
<script src="<c:url value='/resources/DataTables/Buttons-1.6.1/js/buttons.colVis.min.js'/>"></script>
<script src="<c:url value='/resources/DataTables/Buttons-1.6.1/js/buttons.print.min.js'/>"></script>
<script src="<c:url value='/resources/DataTables/FixedColumns-3.3.0/js/dataTables.fixedColumns.min.js'/>"></script>
<script src="<c:url value='/resources/assets/js/filemanager.js'/>"></script>
<script src="https://kit.fontawesome.com/d2e2e9031b.js" crossorigin="anonymous"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/bootstrap-select.min.js"></script>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script>
    $(function () {
        $(".datepicker").datepicker({
            dateFormat: 'dd-mm-yy'
        });
    });
</script>

<script type="text/javascript">
    $(document).ready(function() {
        // Javascript method's body can be found in assets/js/demos.js
        demo.initGoogleMaps();

    });
</script>
<script>
    $(document).ready(function() {
        var table = $('#dataTable').DataTable( {
            "scrollX": "400px",
            dom: "Bfrtip",
            searching: false,
            paging: false,
            bInfo: false,
            buttons: [
                {
                    extend: 'pdfHtml5',
                    text: 'PDF',
                    exportOptions: {
                        columns: ':visible'
                    },
                    className: 'btn btn-primary'
                },
                {
                    extend: 'excelHtml5',
                    text: 'Excel',
                    exportOptions: {
                        columns: ':visible',
                        modifier: {
                            page: 'current'
                        }
                    },
                    className: 'btn btn-primary'
                },
                {
                    extend: 'colvis',
                    text: 'Filtro de Columnas',
                    columnText: function (dt, idx, title) {
                        return (idx + 1) + ': ' + title;
                    },
                    className: 'btn btn-primary'
                },
                {
                    extend: 'copyHtml5',
                    text: 'Copiar en Portapapeles',
                    copySuccess: {
                        1: "Copied one row to clipboard",
                        _: "Copied %d rows to clipboard"
                    },
                    exportOptions: {
                        columns: ':visible'
                    },
                    copyTitle: 'Copiar en portapapeles',
                    copyKeys: 'Press <i>ctrl</i> or <i>\u2318</i> + <i>C</i> to copy the table data<br>to your system clipboard.<br><br>To cancel, click this message or press escape.',
                    className: 'btn btn-primary'
                },
                {
                    extend: 'print',
                    text: 'Imprimir resultados',
                    exportOptions: {
                        columns: ':visible',
                        modifier: {
                            page: 'current'
                        }
                    },
                    className: 'btn btn-primary'
                }
            ],
        } );

        var tableToEdit = $('#dataTableToEdit').DataTable( {
            "scrollX": "400px",
            dom: "Bfrtip",
            buttons: [
                {
                    extend: 'pdfHtml5',
                    text: 'PDF',
                    exportOptions: {
                        columns: ':visible'
                    },
                    className: 'btn btn-primary'
                },
                {
                    extend: 'excelHtml5',
                    text: 'Excel',
                    exportOptions: {
                        columns: ':visible',
                        modifier: {
                            page: 'current'
                        }
                    },
                    className: 'btn btn-primary'
                },
                {
                    extend: 'colvis',
                    text: 'Filtro de Columnas',
                    columnText: function (dt, idx, title) {
                        return (idx + 1) + ': ' + title;
                    },
                    className: 'btn btn-primary'
                },
                {
                    extend: 'copyHtml5',
                    text: 'Copiar en Portapapeles',
                    copySuccess: {
                        1: "Copied one row to clipboard",
                        _: "Copied %d rows to clipboard"
                    },
                    exportOptions: {
                        columns: ':visible'
                    },
                    copyTitle: 'Copiar en portapapeles',
                    copyKeys: 'Press <i>ctrl</i> or <i>\u2318</i> + <i>C</i> to copy the table data<br>to your system clipboard.<br><br>To cancel, click this message or press escape.',
                    className: 'btn btn-primary'
                },
                {
                    extend: 'print',
                    text: 'Imprimir resultados',
                    exportOptions: {
                        columns: ':visible',
                        modifier: {
                            page: 'current'
                        }
                    },
                    className: 'btn btn-primary'
                }
            ],
        } );

        $('a.toggle-vis').on( 'click', function (e) {
            e.preventDefault();

            // Get the column API object
            var column = table.column( $(this).attr('data-column') );

            // Toggle the visibility
            column.visible( ! column.visible() );
        } );
    } );
</script>

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
        moreToolsOptions.appendTo('#tools-button')

        $('#select-empresas').selectpicker('val', ${ubicacionRequest.empresasSelected});
        $('#select-elementos').selectpicker('val', ${ubicacionRequest.elementosSelected});
        $('#select-formatos').selectpicker('val', ${ubicacionRequest.formatosSelected});
        $('#select-medios').selectpicker('val', ${ubicacionRequest.mediosSelected});
        $('#select-localidades').selectpicker('val', ${ubicacionRequest.localidadesSelected});
        $('#select-provincias').selectpicker('val', ${ubicacionRequest.provinciasSelected});

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
            marginTop: "-400px",
            opacity: 1
        }, 500 );

        $( "#arrowUp" ).hide();
        $( "#arrowDown" ).show();
    });


    $( "#arrowDown" ).click(function() {
        $( ".table-ubicaciones" ).animate({
            marginTop: "-150px",
            opacity: 0.9
        }, 1000 );

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

<!-- Add fancyBox -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.5.7/jquery.fancybox.js"></script>
</body>
</html>
