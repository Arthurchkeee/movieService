<#import "parts/header.ftlh" as h>
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
    <@h.header></@h.header>
    <section>
        <div class="content">
            <div class="row">
                <div class="col-4">
                    <div class=" p-4 bg-white u-round-sm u-shadow-lg">
                        <div class="avatar text-gray-400" data-text='${user.username?substring(0,2)}'></div>
                        <div><p class="font-alt">${user.username}</p></div>
                        <div><p class="gray-500">${user.email}</p></div>
                    </div>
                </div>
                <div class="col-8">
                    <div class=" p-4 bg-white u-round-sm u-shadow-lg">
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
                                        <a href="/movies/movie/${review.movie.id}">
                                            ${review.movie.title}
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
                </div>
            </div>
        </div>
    </section>
</div>

</body>
</html>
