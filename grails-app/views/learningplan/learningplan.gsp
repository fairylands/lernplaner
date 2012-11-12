<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>


<div id="theoriewoche">
    <g:each in="${1..12}">
        <g:link controller="learningplan" action="theoriewoche" id="${it}" class="button">TW ${it}</g:link>
    </g:each>
</div>

</body>
</html>