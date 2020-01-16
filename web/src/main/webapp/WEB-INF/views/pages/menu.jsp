<style>
    .wordsMenu{
        font-style: italic;
        font-size: 18px;
    }
    .dropdown-menu{
        display: none;
    }
</style>

<div class="sidebar-wrapper collapse show" id="collapseExample">

    <div class="logo">
        <a href="http://www.scopesi.com.ar">
            <img src="/resources/assets/img/ScopesiLogo.png">
        </a>
    </div>
    <ul class="nav">
        <li>
            <a class="nav-link" href="/dashboard/panel">
                <i class="nc-icon nc-chart-pie-35"></i>
                <p class="wordsMenu">Dashboard</p>
            </a>
        </li>
        <li>
            <a class="nav-link" href="/user/list">
                <i class="nc-icon nc-circle-09"></i>
                <p class="wordsMenu">Usuarios</p>
            </a>
        </li>
        <li>
            <a class="nav-link" href="./table.html">
                <i class="nc-icon nc-notes"></i>
                <p class="wordsMenu">Auditorias</p>
            </a>
        </li>

        <li class="dropdown">
            <a class="nav-link dropdown-toggle" id="dropdownMenuOffset" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="nc-icon nc-single-copy-04"></i>
                <p class="wordsMenu">Geoplaning</p>
            </a>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                <a class="dropdown-item" href="/ubicacion/list">Ubicaciones</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/maps/show">Mapas</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/tablas">Tablas</a>
            </div>
        </li>

    </ul>
</div>