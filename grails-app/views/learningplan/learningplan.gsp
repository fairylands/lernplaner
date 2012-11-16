<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>


<h1>Theoriewochenübersicht</h1>

<g:link controller="likes" action="likes" class="button">

    <img id="logo" src="${resource(dir: 'images', file: 'like.png')}" alt=""/>
    Aktivit&auml;ten

</g:link>

<div id="theoriewoche">
    <g:each in="${1..12}">
        <g:link controller="learningplan" action="theoriewoche" id="${it}" class="button">TW ${it}</g:link>
    </g:each>
</div>

</body>
</html>