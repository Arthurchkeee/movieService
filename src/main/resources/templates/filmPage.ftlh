<!DOCTYPE html>
<html id="page">
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
<body>
<div class="bg-yellow-100 min-h-100p">
    <div class="header header-clear u-unselectable header-animated px-0 px-2-md">
        <div class="header-brand">
            <div class="nav-item no-hover">
                <a href="/api/movies/findAllMovies">
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
                    <a class="btn btn-black btn--sm py-0" href="#">Sign In</a>
                </div>
            </div>
        </div>
    </div>
    <section>
        <div class="hero">
            <div class="hero-body">
                <div class="content px-12-lg px-24-xl">
                    <div class="u-flex u-items-center u-gap-4 u-flex-column u-gap-8-lg u-flex-row-md">
                        <div>
                            <img class="u-round-xs w-100p w-60p-sm w-auto-md u-shadow-lg"
                                 src="${movie.filePath}">
                        </div>
                        <div>
                            <h1 class="headline-3">${movie.title}</h1>
                            <p class="lead">${movie.description}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="mb-12">
        <div class="content px-2 px-12-lg px-24-xl">
            <h2>About</h2>
            <div class="u-flex u-flex-column u-flex-row-md u-gap-5 u-gap-8-lg">
                <div>
                    <div class="frame__body">
                        <div class="px-2 py-2 bg-dark u-round-sm u-shadow-lg">
                            <div class="u-text-center text-white">
                                <div class="u-flex u-justify-center u-gap-3">
                                    <div>
                                        <h6 class="mb-0">80</h6>
                                        <p class="uppercase font-bold text-sm">Metascore</p>
                                    </div>
                                    <div>
                                        <h6 class="mb-0">7.50</h6>
                                        <p class="uppercase font-bold text-sm">IMDb</p>
                                    </div>
                                </div>
                                <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
                                    fugiat
                                    nulla pariatur.</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div>
                    <div class="frame__body">
                        <div class="px-2 py-2 bg-white u-round-sm u-shadow-lg">
                            <table class="table">
                                <tbody>
                                <tr>
                                    <th>Год производства</th>
                                    <td>
                                        <div class="tag-container">
                                            <div class="tag px-2 py-1 bg-dark text-white text-md font-bold uppercase">
                                                ${movie.year}
                                            </div>
                                        </div>
                                    </td>
                                    <th>Страна</th>
                                    <td>
                                        <div class="tag-container">
                                            <#list movie.country as country>
                                                <div class="tag px-2 py-1 bg-dark text-white text-md font-bold uppercase">
                                                    ${country}
                                                </div>
                                           </#list>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Жанр</th>
                                    <td>
                                        <div class="tag-container">
                                            <#list movie.genre as genre>
                                                <div class="tag px-2 py-1 bg-dark text-white text-md font-bold uppercase">
                                                    ${genre}
                                                </div>
                                            </#list>
                                        </div>
                                    </td>
                                    <th>Режиссер</th>
                                    <td>
                                        <div class="tag-container">
                                            <#list movie.director as director>
                                                <div class="tag px-2 py-1 bg-dark text-white text-md font-bold uppercase">
                                                    ${director}
                                                </div>
                                            </#list>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Сценарий</th>
                                    <td>
                                        <div class="tag-container">
                                            <#list movie.writer as writer>
                                                <div class="tag px-2 py-1 bg-dark text-white text-md font-bold uppercase">
                                                    ${writer}
                                                </div>
                                            </#list>
                                        </div>

                                    <th>Продюссер</th>
                                    <td>
                                        <div class="tag-container">
                                            <#list movie.producer as producer>
                                                <div class="tag px-2 py-1 bg-dark text-white text-md font-bold uppercase">
                                                    ${producer}
                                                </div>
                                            </#list>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Оператор</th>
                                    <td>
                                        <div class="tag-container">
                                            <#list movie.operator as operator>
                                                <div class="tag px-2 py-1 bg-dark text-white text-md font-bold uppercase">
                                                    ${operator}
                                                </div>
                                            </#list>
                                        </div>
                                    </td>
                                    <th>Композитор</th>
                                    <td>
                                        <div class="tag-container">
                                            <#list movie.composer as composer>
                                                <div class="tag px-2 py-1 bg-dark text-white text-md font-bold uppercase">
                                                    ${composer}
                                                </div>
                                            </#list>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Художник</th>
                                    <td>
                                        <div class="tag-container">
                                            <#list movie.artist as artist>
                                                <div class="tag px-2 py-1 bg-dark text-white text-md font-bold uppercase">
                                                    ${artist}
                                                </div>
                                            </#list>
                                        </div>
                                    </td>
                                    <th>Монтаж</th>
                                    <td>
                                        <div class="tag-container">
                                            <#list movie.editor as editor>
                                                <div class="tag px-2 py-1 bg-dark text-white text-md font-bold uppercase">
                                                    ${editor}
                                                </div>
                                            </#list>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Бюджет</th>
                                    <td>
                                        <div class="tag-container">
                                            <div class="tag px-2 py-1 bg-dark text-white text-md font-bold uppercase">
                                                $${movie.budget}
                                            </div>
                                        </div>
                                    </td>
                                    <th>Сборы в США</th>
                                    <td>
                                        <div class="tag-container">
                                            <div class="tag px-2 py-1 bg-dark text-white text-md font-bold uppercase">
                                                $${movie.USAFees}
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Сборы в мире</th>
                                    <td>
                                        <div class="tag-container">
                                            <div class="tag px-2 py-1 bg-dark text-white text-md font-bold uppercase">
                                                $${movie.fees}
                                            </div>
                                        </div>
                                    </td>
                                    <th>Премьера в мире</th>
                                    <td>
                                        <div class="tag-container">
                                            <div class="tag px-2 py-1 bg-dark text-white text-md font-bold uppercase">
                                                ${movie.releasedDate?date}
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Рейтинг MPAA</th>
                                    <td>
                                        <div class="tag-container">
                                            <div class="tag px-2 py-1 bg-dark text-white text-md font-bold uppercase">
                                                PG-13
                                            </div>
                                        </div>
                                    </td>
                                    <th>Время</th>
                                    <td>
                                        <div class="tag-container">
                                            <div class="tag px-2 py-1 bg-dark text-white text-md font-bold uppercase">
                                                114 мин. / 01:54
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div class="space"></div>
</div>

</body>
</html>
