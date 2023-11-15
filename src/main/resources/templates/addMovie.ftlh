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
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"
            integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
</head>
<body>
<div class="bg-yellow-100 min-h-100p">
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

    <section class="mb ">
        <div class="content  px-2 px-12-lg px-24-xl">
            <h2>About</h2>
            <div class="u-flex u-justify-center u-flex-column u-flex-row-md u-gap-5 u-gap-8-lg">
                <div>
                    <div class="frame bg-white">
                        <div class="frame__header">
                            <div>
                                <h6 class="frame__title">Введите информацию о фильме</h6>
                            </div>
                        </div>
                        <div class="frame__body">
                            <div class="px-2 py-2 bg-dark u-round-sm u-shadow-lg">
                                <div class="u-text-center text-white">
                                    <div class="u-flex u-justify-center u-gap-3">
                                        <form method="post" action="/movies/addMovie" enctype="multipart/form-data">
                                            <input type="hidden" value="${_csrf.token}" name="_csrf">
                                            <div class="row level">
                                                <div class="col-xs-3 level-item">
                                                    <p class="m-0">Название</p>
                                                </div>
                                                <div class="col-xs-9 level-item"><input type="name" name="title"
                                                                                        value="John Doe"></div>
                                                <div class="space"></div>
                                                <div class="col-xs-3 level-item">
                                                    <p class="m-0">Описание</p>
                                                </div>
                                                <div class="col-xs-9 level-item"><input type="name" name="description"
                                                                                        value="John Doe"></div>
                                                <div class="space"></div>

                                                <div class="col-xs-3 level-item">
                                                    <p class="m-0">Год производства</p>
                                                </div>
                                                <div class="col-xs-9 level-item">
                                                    <input type="date" name="year" value="2017-3-21">
                                                </div>
                                                <div class="space"></div>

                                                <div class="col-xs-3 level-item">
                                                    <p class="m-0">Страна</p>
                                                </div>
                                                <div class="col-xs-9 level-item input-control">
                                                    <select name="country" class="select" multiple>
                                                        <option>Shibe</option>
                                                        <option>Doggo</option>
                                                        <option>Pupper</option>
                                                    </select>
                                                </div>
                                                <div class="space"></div>

                                                <div class="col-xs-3 level-item">
                                                    <p class="m-0">Жанр</p>
                                                </div>
                                                <div class="col-xs-9 level-item input-control">
                                                    <select class="select" name="genre" multiple>
                                                        <option>Shibe</option>
                                                        <option>Doggo</option>
                                                        <option>Pupper</option>
                                                    </select>
                                                </div>
                                                <div class="space"></div>

                                                <div class="col-xs-3 level-item">
                                                    <p class="m-0">Режиссёр</p>
                                                </div>
                                                <div class="col-xs-9 level-item input-control">
                                                    <select class="select" name="director" multiple>
                                                        <option>Shibe</option>
                                                        <option>Doggo</option>
                                                        <option>Pupper</option>
                                                    </select>
                                                </div>
                                                <div class="space"></div>

                                                <div class="col-xs-3 level-item">
                                                    <p class="m-0">Сценарий</p>
                                                </div>
                                                <div class="col-xs-9 level-item input-control">
                                                    <select class="select" name="writer" multiple>
                                                        <option>Shibe</option>
                                                        <option>Doggo</option>
                                                        <option>Pupper</option>
                                                    </select>
                                                </div>
                                                <div class="space"></div>

                                                <div class="col-xs-3 level-item">
                                                    <p class="m-0">Продюсер</p>
                                                </div>
                                                <div class="col-xs-9 level-item input-control">
                                                    <select class="select" name="producer" multiple>
                                                        <option>Shibe</option>
                                                        <option>Doggo</option>
                                                        <option>Pupper</option>
                                                    </select>
                                                </div>
                                                <div class="space"></div>

                                                <div class="col-xs-3 level-item">
                                                    <p class="m-0">Оператор</p>
                                                </div>
                                                <div class="col-xs-9 level-item input-control">
                                                    <select class="select" name="operator" multiple>
                                                        <option>Shibe</option>
                                                        <option>Doggo</option>
                                                        <option>Pupper</option>
                                                    </select>
                                                </div>
                                                <div class="space"></div>

                                                <div class="col-xs-3 level-item">
                                                    <p class="m-0">Композитор</p>
                                                </div>
                                                <div class="col-xs-9 level-item input-control">
                                                    <select class="select" name="composer" multiple>
                                                        <option>Shibe</option>
                                                        <option>Doggo</option>
                                                        <option>Pupper</option>
                                                    </select>
                                                </div>
                                                <div class="space"></div>

                                                <div class="col-xs-3 level-item">
                                                    <p class="m-0">Художник</p>
                                                </div>
                                                <div class="col-xs-9 level-item input-control">
                                                    <select class="select" name="artist" multiple>
                                                        <option>Shibe</option>
                                                        <option>Doggo</option>
                                                        <option>Pupper</option>
                                                    </select>
                                                </div>
                                                <div class="space"></div>

                                                <div class="col-xs-3 level-item">
                                                    <p class="m-0">Монтаж</p>
                                                </div>
                                                <div class="col-xs-9 level-item input-control">
                                                    <select class="select" name="editor" multiple>
                                                        <option>Shibe</option>
                                                        <option>Doggo</option>
                                                        <option>Pupper</option>
                                                    </select>
                                                </div>
                                                <div class="space"></div>

                                                <div class="col-xs-3 level-item">
                                                    <p class="m-0">Бюджет</p>
                                                </div>
                                                <div class="col-xs-9 level-item"><input type="number" name="budget"
                                                                                        value="420"></div>
                                                <div class="space"></div>

                                                <div class="col-xs-3 level-item">
                                                    <p class="m-0">Сборы в США</p>
                                                </div>
                                                <div class="col-xs-9 level-item"><input type="number" name="USAFees"
                                                                                        value="420"></div>
                                                <div class="space"></div>

                                                <div class="col-xs-3 level-item">
                                                    <p class="m-0">Сборы в мире</p>
                                                </div>
                                                <div class="col-xs-9 level-item"><input type="number" name="fees"
                                                                                        value="420"></div>
                                                <div class="space"></div>

                                                <div class="col-xs-3 level-item">
                                                    <p class="m-0">Премьера в мире</p>
                                                </div>
                                                <div class="col-xs-9 level-item">
                                                    <input type="date" name="releasedDate" value="2017-3-21">
                                                </div>

                                                <div class="col-xs-9 level-item">
                                                    <input name="poster" type="file">
                                                </div>

                                                <div class="space"></div>
                                            </div>
                                            <input type="submit">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="space"></div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
</body>