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

    <tr>
        <td class="tablehead"> Tag </td>
        <td class="tablehead"> Start </td>
        <td class="tablehead"> Dauer </td>
        <td class="breitezeitentd">  </td>
    </tr>

    <g:each in="${untitled3.Likes.findByLikename(params.name).term}">
    <tr>
        <td> ${it.dayOfWeek} </td>
        <td> ${it.getStarttimeConverted()} </td>
        <td> ${it.duration} </td>

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