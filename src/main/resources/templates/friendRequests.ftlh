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
            <div class="btn-group btn-group-fill u-center">
                <a href="/friends/getUserFriendRequests">
                    <button class="bg-orange-200 text-orange-700">Input Friend Requests</button>
                </a>
                <a href="/friends/getOutputFriendRequests">
                    <button class="bg-orange-200 text-orange-700">Output Friend Requests</button>
                </a>
            </div>
            <#if friendRequests??>
                <#list friendRequests as friendRequest>
                    <div class="tile">
                        <div class="tile__icon">
                            <div class="avatar text-gray-000" data-text='Aa'></div>
                        </div>
                        <#if springMacroRequestContext.requestUri?contains("/getUserFriendRequests")>
                            <div class="tile__container">
                                <p class="tile__title m-0">${friendRequest.requester.username}</p>
                                <p class="tile__subtitle m-0">${friendRequest.requester.email}</p>
                            </div>
                            <div class="tile__buttons m-0">
                                <form method="post" action="/friends/acceptFriendRequest">
                                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                                    <input type="hidden" value="${friendRequest.id}" name="friendRequest">
                                    <button class="btn-primary btn--sm uppercase">Accept</button>
                                </form>
                            </div>
                        <#else>
                            <div class="tile__container">
                                <p class="tile__title m-0">${friendRequest.recipient.username}</p>
                                <p class="tile__subtitle m-0">${friendRequest.recipient.email}</p>
                            </div>
                        </#if>
                        <div class="tile__buttons m-0">
                            <form method="post" action="/friends/rejectFriendRequest">
                                <input type="hidden" value="${_csrf.token}" name="_csrf">
                                <input type="hidden" value="${friendRequest.id}" name="friendRequest">
                                <button class="btn-primary btn--sm uppercase">Reject</button>
                            </form>
                        </div>
                    </div>
                </#list>
            </#if>
        </div>
    </section>
</div>

</body>
</html>
