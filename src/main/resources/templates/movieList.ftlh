<!DOCTYPE html>
<html id="page" lang="eng">
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
    <script src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
</head>
<body class="bg-yellow-100">
<div>
    <div class="header header-clear u-unselectable header-animated px-0 px-2-md">
        <div class="header-brand">
            <div class="nav-item no-hover">
                <a>
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
                <div class="nav-item">
                    <a href="#">About</a>
                </div>
                <div class="nav-item">
                    <a href="#">Contact</a>
                </div>
                <div class="nav-item">
                    <form action="/logout" method="post">
                        <input class="btn btn-black btn--sm py-0" type="submit" value="Sign out"/>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <section>
        <div class="row">
            <div class="col-2">
                <div class="p-2 grid u-text-center">
                    <div class="grid-c-12 grid-r-12">
                        <div class="bg-white u-shadow-lg u-round-xl">
                            <div class="p-3">
                                <form method="get" action="/movies/findMoviesByFilter">
                                    <p class="font-black">Filter</p>
                                    <details class="accordion">
                                        <summary class="accordion__summary">Genre</summary>
                                        <select onchange="this.form.submit()" class="u-round-md" id="genre" name="genreFilter">
                                            <option selected>select genre</option>
                                            <#list genres as genre>
                                                <option value="${genre.id}">${genre.name}
                                                </option>
                                            </#list>
                                        </select>
                                    </details>
                                    <details class="accordion">
                                        <summary class="accordion__summary">Country</summary>
                                        <select onchange="this.form.submit()" class="u-round-md" id="country" name="countryFilter">
                                            <option selected>select country</option>
                                            <#list countries as country>
                                                <option value="${country.id}">${country.name}
                                                </option>
                                            </#list>
                                        </select>
                                    </details>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-10">
                <div class="p-2 grid u-gap-4 u-text-center">
                    <#list movies as movie>
                        <div class="grid-c-3 grid-r-3">
                            <div class="card card--slide-up">
                                <div class="card__container">
                                    <div class="card__image"
                                         style="background-image: url(${movie.filePath});"></div>
                                </div>
                                <div class="card__mobile-title">
                                    <div class="content">
                                        <div class="tile">
                                            <div class="tile__container">
                                                <a href="/movies/movie/${movie.id}"
                                                   class="tile__title">${movie.title}</a>
                                                <p class="tile__subtitle">${movie.year}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card__body content">
                                    <p>${movie.description}</p>
                                </div>
                                <div class="card__footer content"><#list movie.director as director>${director}</#list>
                                    <form method="post" action="/movies/delete" enctype="multipart/form-data">
                                        <input type="hidden" name="id" value="${movie.id}">
                                        <button class="btn-primary">DELETE</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
        </div>
    </section>
</div>

</body>