<style>
    .wordsMenu{
        font-style: italic;
        font-size: 18px;
    }
    .dropdown-menu{
        display: none;
    }
    .cursorPointer{
        cursor: pointer;
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
                <i class="fab fa-buffer"></i>
                <p class="wordsMenu">Auditorias</p>
            </a>
        </li>

        <li>
            <a class="nav-link dropdown-toggle cursorPointer" id="dropdownMenuOffset" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-atlas"></i>
                <p class="wordsMenu">Geoplaning</p>
            </a>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                <a class="dropdown-item" href="/ubicacion/list">
                    <i class="fas fa-map-marker-alt"></i>
                    Ubicaciones</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/maps/show">
                    <i class="fas fa-globe-americas"></i>
                    Mapas</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/tablas">
                    <i class="fas fa-table"></i>
                    Tablas</a>
            </div>
        </li>

    </ul>
</div>