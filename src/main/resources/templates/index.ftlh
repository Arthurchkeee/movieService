<!DOCTYPE html>
<html id="page" lang="ru">
<head>
    <title>Getting Started with Cirrus</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge;"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/cirrus-ui/dist/cirrus.min.css"/>
    <link href="https://unpkg.com/cirrus-ui" type="text/css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,600,700" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
          integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous"/>
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"
            integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
</head>
<body class="bg-yellow-100">
<div>
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
                    <a href="#">Watchlist</a>
                </div>
                <div class="nav-item">
                    <a href="#">About</a>
                </div>
                <div class="nav-item">
                    <a href="#">Contact</a>
                </div>
                <div class="nav-item">
                    <a class="btn btn-black btn--sm py-0" href="/signup">Sign Up</a>
                </div>
            </div>
        </div>
    </div>
    <section class="u-center-alt">
        <div class="content">
            <div class="frame__body">
                <div class="px-2 py-2 bg-dark u-round-sm u-shadow-lg">
                    <div class="u-text-center text-white">
                        <form method="post" action="/login" enctype="multipart/form-data">
                            <input type="hidden" value="${_csrf.token}" name="_csrf">
                            <div class="mb-1">
                                <label class="font-bold">Username</label>
                                <div class="section-body">
                                    <div class="form-group">
                                        <input
                                               type="text" name="username" placeholder="Enter your username"/>
                                    </div>
                                </div>
                            </div>
                            <div class="mb-1">
                                <label class="font-bold">Password</label>
                                <div class="section-body">
                                    <div class="form-group">
                                        <input type="password" class="form-group-input"
                                               placeholder="Enter your password" name="password"/>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <button type="submit">Sign in</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>


</div>

</body>
</html>
