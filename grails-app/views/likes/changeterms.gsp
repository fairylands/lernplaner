<%@ page import="untitled3.Likes" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>
<g:form controller="likes" action="saveLike">

<table class="table">
<h1> Zeiten f&uuml;r "${params.name}" &auml;ndern: </h1>
<g:each in="${untitled3.Likes.findByLikename(params.name).term}">
    <tr>
        <td> <g:select name="dayOfWeek" from="${['Mo', 'Di', 'Mi', 'Do', 'Fr', 'Sa', 'So']}" value="${it.dayOfWeek}" required=""/> </td>
        <td> <g:select name="starttime" from="${starttimesList}" value="${it.starttime}" required=""/> </td>
        <td> <g:select name="duration" from="${durationsList}" value="${it.duration}" required=""/> </td>

        <td class="breitezeitentd">
            <g:link controller="likes" action="removeTerm" params="[likename: params.name, termId: it.id]">
                <img src="${resource(dir: 'images', file: 'loeschen.png')}" title="Zeit entfernen" alt="bild"/>
            </g:link>
        </td>
    </tr>
</g:each>
</table>

</g:form>

<h3> Zeit hinzuf&uuml;gen: </h3>

<g:form controller="likes" action="addTerm" params="[likename: params.name]">
    <table>
<tr>
    <td> Wochentag </td>
    <td> Beginn </td>
    <td> Dauer (in h) </td>
</tr>
<tr>
    <td> <g:select name="dayOfWeek" from="${['Mo', 'Di', 'Mi', 'Do', 'Fr', 'Sa', 'So']}" required=""/> </td>
    <td> <g:select name="starttime" from="${starttimesList}" required=""/> </td>
    <td> <g:select name="duration" from="${durationsList}" required=""/> </td>
    </tr>
    <tr>
        <td>  </td>
        <td>  </td>
        <td> <input type="submit" value="Hinzuf&uuml;gen"/> </td>

    </tr>
</g:form>

</body>
</html>