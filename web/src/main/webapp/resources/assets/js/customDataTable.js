var table;
var dataTableToCompleteList;

$(document).ready(function() {
     table = $('#dataTable').DataTable( {
        'scrollX': '400px',
        dom: "Bfrtip",
        searching: true,
        paging: false,
        bInfo: false,
        language:{
            "info": "Mostrando _START_ a _END_ de _TOTAL_",
            "infoEmpty":    "Mostrando 0 de 0",
            "lengthMenu":   "Mostrar _MENU_",
            "infoFiltered": "(filtrado de _MAX_ entradas totales)",
            "search":   "Buscar:",
            "paginate": {
                "first":      "First",
                "last":       "Last",
                "next":       "Siguiente",
                "previous":   "Anterior"
            },
        },
        buttons: [
            {
                extend: 'pdfHtml5',
                text: 'PDF',
                orientation: 'landscape',
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
                text: 'Imprimir',
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
        'scrollX': '400px',
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

    dataTableToCompleteList = $('#dataTableToCompleteList').DataTable( {
        'scrollX': '400px',
        lengthChange: true,
        lengthMenu: [ [ 10, 50, 100, -1 ], [ '10', '50', '100', 'Todos' ]],
        dom: "Blfrtip",
        language:{
            "info": "Mostrando _START_ a _END_ de _TOTAL_",
            "infoEmpty":    "Mostrando 0 de 0",
            "lengthMenu":   "Mostrar _MENU_",
            "infoFiltered": "(filtrado de _MAX_ entradas totales)",
            "search":   "Buscar:",
            "paginate": {
                "first":      "First",
                "last":       "Last",
                "next":       "Siguiente",
                "previous":   "Anterior"
            },
        },
        buttons: [
            {
                extend: 'pdfHtml5',
                text: 'PDF',
                orientation: 'landscape',
                exportOptions: {
                    columns: ':visible'
                },
                className: 'dataTableButton',
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
                className: 'dataTableButton'
            },
            {
                extend: 'colvis',
                text: 'Filtro de Columnas',
                columnText: function (dt, idx, title) {
                    return (idx + 1) + ': ' + title;
                },
                className: 'dataTableButton'
            },
            {
                extend: 'copyHtml5',
                text: 'Copiar en portapapeles',
                copySuccess: {
                    1: "Copied one row to clipboard",
                    _: "Copied %d rows to clipboard"
                },
                exportOptions: {
                    columns: ':visible'
                },
                copyTitle: 'Copiar en portapapeles',
                copyKeys: 'Press <i>ctrl</i> or <i>\u2318</i> + <i>C</i> to copy the table data<br>to your system clipboard.<br><br>To cancel, click this message or press escape.',
                className: 'dataTableButton'
            },
            {
                extend: 'print',
                text: 'Imprimir',
                exportOptions: {
                    columns: ':visible',
                    modifier: {
                        page: 'current'
                    }
                },
                className: 'dataTableButton'
            }
        ],

    } );

    var dataTableOrderDesc = $('#dataTableOrderDesc').DataTable( {
        'scrollX': '400px',
        dom: "Bfrtip",
        order: [[ 0, "desc" ]],
        searching: true,
        paging: false,
        bInfo: false,
        language:{
            "info": "Mostrando _START_ a _END_ de _TOTAL_",
            "infoEmpty":    "Mostrando 0 de 0",
            "lengthMenu":   "Mostrar _MENU_",
            "infoFiltered": "(filtrado de _MAX_ entradas totales)",
            "search":   "Buscar:",
            "paginate": {
                "first":      "First",
                "last":       "Last",
                "next":       "Siguiente",
                "previous":   "Anterior"
            },
        },
        buttons: [
            {
                extend: 'pdfHtml5',
                text: 'PDF',
                orientation: 'landscape',
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
                text: 'Imprimir',
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

    dataTableToCompleteList.buttons().container()
        .appendTo( '#example_wrapper .col-md-6:eq(0)' );

    $('a.toggle-vis').on( 'click', function (e) {
        e.preventDefault();

        // Get the column API object
        var column = table.column( $(this).attr('data-column') );

        // Toggle the visibility
        column.visible( ! column.visible() );
    } );

    // var valueOfSearchingDataTable = sessionStorage['valueSearchDataTable'] || '';
    // $('.dataTables_filter input[type="search"]').val(valueOfSearchingDataTable).keyup();
    //
    //
    // $('.dataTables_filter input').unbind().keyup(function(e) {
    //
    //     var miTabla = $('#dataTable');
    //
    //     var valueSearchDataTable = $(this).val();
    //     if (valueSearchDataTable.length>=1) {
    //         miTabla.search(valueSearchDataTable).draw();
    //         dataTableToCompleteList.search(valueSearchDataTable).draw();
    //         sessionStorage['valueSearchDataTable'] = valueSearchDataTable;
    //
    //     } else {
    //         miTabla.search('').draw();
    //         dataTableToCompleteList.search('').draw();
    //         sessionStorage['valueSearchDataTable'] = "";
    //     }
    // });

} );
