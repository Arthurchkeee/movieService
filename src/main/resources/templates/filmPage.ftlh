<#import "parts/header.ftlh" as h>
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
<div class="bg-yellow-100">
    <@h.header></@h.header>

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
                    <div class="space"></div>
                    <form action="/movies/addToWatchlist" method="post">
                        <input class="btn btn-black btn--sm py-0" type="submit" value="Add to watchlist"/>
                        <input type="hidden" name="movie" value="${movie.id}">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    </form>
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
                                    <div>
                                        <h6 class="mb-0">${movie.rating}</h6>
                                        <p class="uppercase font-bold text-sm">Users Mark</p>
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
                                                    ${country.name}
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
                                                    ${genre.name}
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
    <section>
        <div class="content p-4 grid bg-white u-round-sm u-shadow-lg">
            <#if reviews?has_content>
                <#list reviews as review>
                    <div class="card grid-c-12 grid-r-12 bg-orange-300 u-round-sm u-shadow-lg">
                        <div class="card__header">
                            <div class="row">
                                <div class="col-11">
                                    <p class="font-bold px-3">${review.title}</p>
                                </div>
                                <div class="col-1">
                                    <p class="font-bold ps-4">${review.mark}</p>
                                </div>
                            </div>
                        </div>
                        <div class="content">
                            <p>${review.textOfReview}</p>
                        </div>
                        <div class="card__footer level content">
                            <a href="/user/${review.user.id}">
                                ${review.user.username}
                            </a>
                        </div>
                    </div>
                </#list>
            <#else>
                <div class="u-text-center">
                    <h5>Nobody sent their review. Will be first!</h5>
                </div>
            </#if>


        </div>
    </section>
    <section>
        <div class="content">
            <a href="#in-modal">
                <button class="px-3">Zoom In</button>
            </a>
            <div class="modal  modal-animated--zoom-in" id="in-modal"><a href="#searchModalDialog"
                                                                         class="modal-overlay close-btn"
                                                                         aria-label="Close"></a>
                <div class="modal-content" role="document">
                    <div class="modal-header u-flex u-justify-space-between">
                        <div class="modal-title">Modal Dialog</div>
                        <a href="#components" aria-label="Close"><span class="icon"><svg aria-hidden="true"
                                                                                         focusable="false"
                                                                                         data-prefix="fas"
                                                                                         data-icon="times"
                                                                                         class="svg-inline--fa fa-times fa-w-11 fa-wrapper"
                                                                                         role="img"
                                                                                         xmlns="http://www.w3.org/2000/svg"
                                                                                         viewBox="0 0 352 512"><path
                                            fill="currentColor"
                                            d="M242.72 256l100.07-100.07c12.28-12.28 12.28-32.19 0-44.48l-22.24-22.24c-12.28-12.28-32.19-12.28-44.48 0L176 189.28 75.93 89.21c-12.28-12.28-32.19-12.28-44.48 0L9.21 111.45c-12.28 12.28-12.28 32.19 0 44.48L109.28 256 9.21 356.07c-12.28 12.28-12.28 32.19 0 44.48l22.24 22.24c12.28 12.28 32.2 12.28 44.48 0L176 322.72l100.07 100.07c12.28 12.28 32.2 12.28 44.48 0l22.24-22.24c12.28-12.28 12.28-32.19 0-44.48L242.72 256z"></path></svg></span></a>
                    </div>
                    <div class="modal-body">
                        <form action="/movies/sendReview" method="post">
                            <input type="text" name="title">
                            <textarea name="textOfReview"></textarea>
                            <input type="hidden" name="movie" value="${movie.id}">
                            <input type="range" name="mark" min="0" max="10" step="1">
                            <input type="hidden" value="${_csrf.token}" name="_csrf">
                            <button type="submit" class="btn btn-primary">Send</button>
                        </form>
                    </div>
                    <div class="modal-footer u-text-right"><a href="#components" class="u-inline-block mr-1">
                            <button class="btn--sm">Cancel</button>
                        </a><a href="#components" class="u-inline-block">
                            <button class="btn-primary btn--sm">Share</button>
                        </a></div>
                </div>
            </div>
        </div>
    </section>
    <div class="space"></div>
</div>

</body>
</html>
