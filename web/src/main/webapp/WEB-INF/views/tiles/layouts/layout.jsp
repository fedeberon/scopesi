<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html lang="en">

<tiles:insertAttribute name="header" />

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
<body>

    <div class="wrapper">

        <div class="sidebar" data-color="black">
            <tiles:insertAttribute name="menu" />
        </div>


        <div class="main-panel">

            <tiles:insertAttribute name="navbar" />

            <tiles:insertAttribute name="body" />

        </div>

    </div>

    <tiles:insertAttribute name="footer" />

</body>
<!--   Core JS Files   -->
<script src="../assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="../assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="../assets/js/core/bootstrap.min.js" type="text/javascript"></script>

<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="../assets/js/plugins/bootstrap-switch.js"></script>
<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyANGywbfxItEbdle738SiU-AVJGIjadVYM"></script>
<!--  Chartist Plugin  -->
<script src="../assets/js/plugins/chartist.min.js"></script>
<!--  Notifications Plugin    -->
<script src="../assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
<script src="../assets/js/light-bootstrap-dashboard.js?v=2.0.0 " type="text/javascript"></script>
<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project!
     Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
<script src="../assets/js/demo.js"></script>
<script src="../assets/js/paginador.js"></script>


<script src="../DataTables/DataTables-1.10.20/js/jquery.dataTables.min.js"></script>


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

        $('a.toggle-vis').on( 'click', function (e) {
            e.preventDefault();

            // Get the column API object
            var column = table.column( $(this).attr('data-column') );

            // Toggle the visibility
            column.visible( ! column.visible() );
        } );
    } );
</script>

<script src="../DataTables/JSZip-2.5.0/jszip.min.js"></script>
<script src="../DataTables/pdfmake-0.1.36/pdfmake.min.js"></script>
<script src="../DataTables/pdfmake-0.1.36/vfs_fonts.js"></script>
<script src="../DataTables/Buttons-1.6.1/js/dataTables.buttons.min.js"></script>
<script src="../DataTables/Buttons-1.6.1/js/buttons.html5.min.js"></script>
<script src="../DataTables/Buttons-1.6.1/js/buttons.colVis.min.js"></script>
<script src="../DataTables/Buttons-1.6.1/js/buttons.print.min.js"></script>
<script src="../DataTables/FixedColumns-3.3.0/js/dataTables.fixedColumns.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/bootstrap-select.min.js"></script>

<script>
    $( ".form-check-sign" ).on( "click", function() {
        var check = $( this ).attr('id');
        $('form-check-input-' + check).val(true);
    });


    var selectpickerIsClicked = false;

    $(function () {
        $('.selectpicker').selectpicker({
            container: 'body',
            dropupAuto: false
        });

        $('.dropdown-menu').on('click', function (e) {
            if ($(e.target).closest('.bootstrap-select.open').is(':visible') || $(e.target).closest('.btn.dropdown-toggle.btn-default').is(':visible')) {
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

</script>

</html>
