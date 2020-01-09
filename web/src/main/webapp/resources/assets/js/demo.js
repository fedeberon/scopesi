$().ready(function() {
    $sidebar = $('.sidebar');
    $sidebar_img_container = $sidebar.find('.sidebar-background');

    $full_page = $('.full-page');

    $sidebar_responsive = $('body > .navbar-collapse');

    window_width = $(window).width();

    fixed_plugin_open = $('.sidebar .sidebar-wrapper .nav li.active a p').html();

    if (window_width > 767 && fixed_plugin_open == 'Dashboard') {
        if ($('.fixed-plugin .dropdown').hasClass('show-dropdown')) {
            $('.fixed-plugin .dropdown').addClass('show');
        }

    }

    $('.fixed-plugin a').click(function(event) {
        // Alex if we click on switch, stop propagation of the event, so the dropdown will not be hide, otherwise we set the  section active
        if ($(this).hasClass('switch-trigger')) {
            if (event.stopPropagation) {
                event.stopPropagation();
            } else if (window.event) {
                window.event.cancelBubble = true;
            }
        }
    });

    $('.fixed-plugin .background-color span').click(function() {
        $(this).siblings().removeClass('active');
        $(this).addClass('active');

        var new_color = $(this).data('color');

        if ($sidebar.length != 0) {
            $sidebar.attr('data-color', new_color);
        }

        if ($full_page.length != 0) {
            $full_page.attr('filter-color', new_color);
        }

        if ($sidebar_responsive.length != 0) {
            $sidebar_responsive.attr('data-color', new_color);
        }
    });

    $('.fixed-plugin .img-holder').click(function() {
        $full_page_background = $('.full-page-background');

        $(this).parent('li').siblings().removeClass('active');
        $(this).parent('li').addClass('active');


        var new_image = $(this).find("img").attr('src');

        if ($sidebar_img_container.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
            $sidebar_img_container.fadeOut('fast', function() {
                $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
                $sidebar_img_container.fadeIn('fast');
            });
        }

        if ($full_page_background.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
            var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

            $full_page_background.fadeOut('fast', function() {
                $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
                $full_page_background.fadeIn('fast');
            });
        }

        if ($('.switch-sidebar-image input:checked').length == 0) {
            var new_image = $('.fixed-plugin li.active .img-holder').find("img").attr('src');
            var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

            $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
            $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
        }

        if ($sidebar_responsive.length != 0) {
            $sidebar_responsive.css('background-image', 'url("' + new_image + '")');
        }
    });

    $('.switch input').on("switchChange.bootstrapSwitch", function() {

        $full_page_background = $('.full-page-background');

        $input = $(this);

        if ($input.is(':checked')) {
            if ($sidebar_img_container.length != 0) {
                $sidebar_img_container.fadeIn('fast');
                $sidebar.attr('data-image', '#');
            }

            if ($full_page_background.length != 0) {
                $full_page_background.fadeIn('fast');
                $full_page.attr('data-image', '#');
            }

            background_image = true;
        } else {
            if ($sidebar_img_container.length != 0) {
                $sidebar.removeAttr('data-image');
                $sidebar_img_container.fadeOut('fast');
            }

            if ($full_page_background.length != 0) {
                $full_page.removeAttr('data-image', '#');
                $full_page_background.fadeOut('fast');
            }

            background_image = false;
        }
    });
});

type = ['primary', 'info', 'success', 'warning', 'danger'];

demo = {
    initPickColor: function() {
        $('.pick-class-label').click(function() {
            var new_class = $(this).attr('new-class');
            var old_class = $('#display-buttons').attr('data-class');
            var display_div = $('#display-buttons');
            if (display_div.length) {
                var display_buttons = display_div.find('.btn');
                display_buttons.removeClass(old_class);
                display_buttons.addClass(new_class);
                display_div.attr('data-class', new_class);
            }
        });
    },

    initDocumentationCharts: function() {
        /* ----------==========     Daily Sales Chart initialization For Documentation    ==========---------- */

        dataDailySalesChart = {
            labels: ['M', 'T', 'W', 'T', 'F', 'S', 'S'],
            series: [
                [12, 17, 7, 17, 23, 18, 38]
            ]
        };

        optionsDailySalesChart = {
            lineSmooth: Chartist.Interpolation.cardinal({
                tension: 0
            }),
            low: 0,
            high: 50, // creative tim: we recommend you to set the high sa the biggest value + something for a better look
            chartPadding: {
                top: 0,
                right: 0,
                bottom: 0,
                left: 0
            },
        }

        var dailySalesChart = new Chartist.Line('#dailySalesChart', dataDailySalesChart, optionsDailySalesChart);

        // lbd.startAnimationForLineChart(dailySalesChart);
    },

    initDashboardPageCharts: function() {

        var dataPreferences = {
            series: [
                [25, 30, 20, 25]
            ]
        };

        var optionsPreferences = {
            donut: true,
            donutWidth: 40,
            startAngle: 0,
            total: 100,
            showLabel: false,
            axisX: {
                showGrid: false
            }
        };

        Chartist.Pie('#chartPreferences', dataPreferences, optionsPreferences);

        Chartist.Pie('#chartPreferences', {
            labels: ['53%', '36%', '11%'],
            series: [53, 36, 11]
        });


        var dataSales = {
            labels: ['9:00AM', '12:00AM', '3:00PM', '6:00PM', '9:00PM', '12:00PM', '3:00AM', '6:00AM'],
            series: [
                [287, 385, 490, 492, 554, 586, 698, 695, 752, 788, 846, 944],
                [67, 152, 143, 240, 287, 335, 435, 437, 539, 542, 544, 647],
                [23, 113, 67, 108, 190, 239, 307, 308, 439, 410, 410, 509]
            ]
        };

        var optionsSales = {
            lineSmooth: false,
            low: 0,
            high: 800,
            showArea: true,
            height: "245px",
            axisX: {
                showGrid: false,
            },
            lineSmooth: Chartist.Interpolation.simple({
                divisor: 3
            }),
            showLine: false,
            showPoint: false,
            fullWidth: false
        };

        var responsiveSales = [
            ['screen and (max-width: 640px)', {
                axisX: {
                    labelInterpolationFnc: function(value) {
                        return value[0];
                    }
                }
            }]
        ];

        var chartHours = Chartist.Line('#chartHours', dataSales, optionsSales, responsiveSales);

        var data = {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'Mai', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
            series: [
                [542, 443, 320, 780, 553, 453, 326, 434, 568, 610, 756, 895],
                [412, 243, 280, 580, 453, 353, 300, 364, 368, 410, 636, 695]
            ]
        };

        var options = {
            seriesBarDistance: 10,
            axisX: {
                showGrid: false
            },
            height: "245px"
        };

        var responsiveOptions = [
            ['screen and (max-width: 640px)', {
                seriesBarDistance: 5,
                axisX: {
                    labelInterpolationFnc: function(value) {
                        return value[0];
                    }
                }
            }]
        ];

        var chartActivity = Chartist.Bar('#chartActivity', data, options, responsiveOptions);
    },

    initGoogleMaps: function() {
        var myLatlng = new google.maps.LatLng(-34.600966, -58.462361);
        var mapOptions = {
            zoom: 13,
            center: myLatlng,
            scrollwheel: false, //we disable de scroll over the map, it is a really annoing when you scroll through page
            zoomControlOptions: {
                position: google.maps.ControlPosition.LEFT_CENTER
            },
            streetViewControl: false,
        };


        map = new google.maps.Map(document.getElementById("map"), mapOptions);

        $('#table-markers tbody>tr').each(function () {
            var id = $(this).find("td").eq(0).html();
            var title = $(this).find("td").eq(1).html();
            var lat = $(this).find("td").eq(4).html();
            var lon = $(this).find("td").eq(5).html();
            var latLong = new google.maps.LatLng(lat, lon);

            var marker = new google.maps.Marker({
                id: id,
                class: "marker",
                position: latLong,
                map: map,
                draggable: true,
                animation: google.maps.Animation.DROP,
                title: id + ' - ' + title
            });

            var infowindow = new google.maps.InfoWindow({
                content: title + ' ' + id
            });


            marker.addListener('click',function(){
                infowindow.setContent('<h1> '+ title +'</h1>' + '<button id="' + id +'" onclick="createCarrusel(' + id + ')" class="mapaboton" >Ver Detalles</button>');


                infowindow.open(map,this);
            });

            marker.addListener('dragend', function(event){

                $("#mi-modal").modal('show');

                modalConfirm(function(confirm){
                    if(confirm){
                        //Acciones si el usuario confirma
                        handleEventToUpdate(event, marker);

                    } else {
                        //Acciones si el usuario no confirma
                    }
                });


            });

            markers.push(marker);
            bounds.extend(latLong);

        });

        map.fitBounds(bounds);

        var defaultBounds = new google.maps.LatLngBounds(
            new google.maps.LatLng(-33.8902, 151.1759),
            new google.maps.LatLng(-33.8474, 151.2631));

        var input = document.getElementById('pac-input');
        var searchBox = new google.maps.places.SearchBox(input);
        map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

    },

    showNotification: function(from, align) {
        color = Math.floor((Math.random() * 4) + 1);

        $.notify({
            icon: "nc-icon nc-app",
            message: "Welcome to <b>Light Bootstrap Dashboard</b> - a beautiful freebie for every web developer."

        }, {
            type: type[color],
            timer: 8000,
            placement: {
                from: from,
                align: align
            }
        });
    }
}

var markers = [];

function displayMarkers(id) {
    var i;
    for (i = 0; i < markers.length; i++) {
        if (markers[i].id == id) {
            var marker = markers[i];
            if (!marker.getVisible()) {
                marker.setVisible(true);
            } else {
                marker.setVisible(false);
            }
        }
    }
}

function toggleBounce(id) {
    var i;
    for (i = 0; i < markers.length; i++) {
        if (markers[i].id == id) {
            var marker = markers[i];
            if (marker.getAnimation() !== null) {
                marker.setAnimation(null);

                $('#marker-touch-' + id).removeClass('marker-touched');

            } else {
                marker.setAnimation(google.maps.Animation.BOUNCE);
                $('#marker-touch-' + id).addClass('marker-touched');
            }
        }
    }
}

var bounds = new google.maps.LatLngBounds();

function centerFromMarker(id) {
    var i;
    for (i = 0; i < markers.length; i++) {
        if (markers[i].id == id) {
            var marker = markers[i];
            var lat = marker.getPosition().lat();
            var lng = marker.getPosition().lng();
            var latLong = new google.maps.LatLng(lat, lng);
            bounds.extend(latLong);

            map.setZoom(13);
            map.setCenter(marker.getPosition());

        }
    }
}


function showMap(lat, lon){

    var latLong = new google.maps.LatLng(lat, lon);
    var mapaOptions = {
        zoom: 13,
        center: latLong,
        scrollwheel: false, //we disable de scroll over the map, it is a really annoing when you scroll through page
        zoomControlOptions: {
            position: google.maps.ControlPosition.LEFT_CENTER
        },
        streetViewControl: false,
    };
    var mapa = new google.maps.Map(document.getElementById("mapa"), mapaOptions);

    var marker = new google.maps.Marker({
        id: 'miId',
        position: latLong,
        map: mapa,
        draggable: true,
        animation: google.maps.Animation.DROP
    });

    marker.addListener('dragend', handleEvent);

    $('#mapModal').modal('show');
}

$('#mapModal').modal({
    show: 'false'

});


function handleEvent(event) {
    document.getElementById('latitud').value = event.latLng.lat();
    document.getElementById('longitud').value = event.latLng.lng();
}

function handleEventToUpdate(event, marker){
    var dataToSend = {
        "id" : marker.id,
        "latitud": event.latLng.lat(),
        "longitud" : event.latLng.lng()
    };

    $.ajax({
        url:"/api/ubicacion",
        type:"PUT",
        data: JSON.stringify(dataToSend),
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        success: function(data) {
            $.notify({
                title: '<strong>Geolocalizacion Guardada !</strong>',
                message: 'La nueva direccion del punto seleccionado es ' + data.direccion + '.'
            });

            $('#'+data.id+'-lat').html(data.latitud);
            $('#'+data.id+'-lng').html(data.longitud);
            $('#'+data.id+'-address').html(data.direccion);

        },
        error: function(data) {
            $.notify({
                title: '<strong>hubo un problema !</strong>',
                message: 'Se produjo un error al intentar guardar la nueva ubicacion.'
            });
        },
    });

}

var modalConfirm = function(callback){

    $("#modal-btn-si").on("click", function(){
        callback(true);
        $("#mi-modal").modal('hide');
    });

    $("#modal-btn-no").on("click", function(){
        callback(false);
        $("#mi-modal").modal('hide');
    });
};