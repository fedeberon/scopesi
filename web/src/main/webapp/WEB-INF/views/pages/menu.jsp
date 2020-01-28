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
        <li id="dashboard">
            <a class="nav-link" href="/dashboard/panel">
                <i class="fas fa-chart-line"></i>
                <p class="wordsMenu">Dashboard</p>
            </a>
        </li>
        <li id="users">
            <a  class="nav-link" href="/user/list">
                <i class="fas fa-users"></i>
                <p class="wordsMenu">Usuarios</p>
            </a>
        </li>
        <li id="auditorias">
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
                <a id="ubicacion-list" class="dropdown-item" href="/ubicacion/list">Ubicaciones</a>
                <div class="dropdown-divider"></div>
                <a id="maps-show" class="dropdown-item" href="/maps/show">Mapas</a>
                <div class="dropdown-divider"></div>
                <a id="tablas" class="dropdown-item" href="/tablas">Tablas</a>
            </div>
        </li>

    </ul>
</div>