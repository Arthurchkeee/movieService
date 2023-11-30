<#macro header>
    <div class="header header-clear u-unselectable header-animated px-0 px-2-md">
        <div class="header-brand">
            <div class="nav-item no-hover">
                <a href="/movies/findAllMovies">
                    <h6 class="tracking-tight">WatchFlicks</h6>
                </a>
            </div>
            <div class="nav-item nav-btn" id="header-btn">
                <span></span>
                <span></span>
                <span></span>
            </div>
        </div>
        <div class="header-nav" id="header-menu">
            <div class="nav-right text-sm">
                <div class="nav-item">
                    <a href="/movies/watchlist">Watchlist</a>
                </div>
                <div class="nav-item has-sub toggle-hover" id="left-dropdown">
                    <a class="nav-dropdown-link">Friends</a>
                    <ul class="dropdown-menu dropdown-animated" role="menu">
                        <li role="menu-item"><a href="/friends/friendList">Friend List</a></li>
                        <li role="menu-item"><a href="/friends/getUserFriendRequests">Friend Requests</a></li>
                    </ul>
                </div>
                <div class="nav-item">
                    <a href="#">About</a>
                </div>
                <div class="nav-item">
                    <a href="#">Contact</a>
                </div>
                <div class="nav-item">
                    <a class="btn btn-black btn--sm py-0" href="/logout">Log Out</a>
                </div>
            </div>
        </div>
    </div>
</#macro>