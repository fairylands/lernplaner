<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>
<g:form controller="likes" action="saveLike">

<table class="table">
<h1> Zeiten f&uuml;r "${params.name}" &auml;ndern: </h1>
<g:each in="${userlikesList}">
    <tr>
        <td> <g:select name="dayOfWeek" from="${['Mo', 'Di', 'Mi', 'Do', 'Fr', 'Sa', 'So']}" value="${it.term.dayOfWeek}" required=""/> </td>
        <td> <g:select name="starttime" from="${starttimesList}" value="10.45" required=""/> </td>
        <td> <g:select name="duration" from="${durationsList}" required=""/> </td>

        <td class="breitezeitentd"></td>
    </tr>
</g:each>
</table>

    <br>

    <a onclick="plusZeile()">
        <img src="${resource(dir: 'images', file: 'plus.png')}" alt="bild"/>
    </a>

</g:form>

</body>
</html>