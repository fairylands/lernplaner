<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>


<table class="table">

<h1> Meine Likes: </h1>

    <tr>
        <td class="tablehead"> Like </td>
        <td class="tablehead"> Priorit&auml;t</td>
        <td class="tablehead" style="width: 150px"> Zeit</td>
        <td class="tablehead">  </td>

    </tr>

<g:each in="${userlikesList}">
    <tr>
        <td>${it.likename}</td>
        <td>${it.priority}</td>
        <td><g:each var="t" in="${it.term}"> ${t.dayOfWeek}, ${t.starttime} - ${t.endtime} <br> </g:each></td>
        <td>
            <g:link controller="likes" action="updateLikes" params="[name: it.likename]">
                <img src="${resource(dir: 'images', file: 'bearbeiten.png')}" alt="bild"/>
            </g:link>

            <input type="image" src="../images/loeschen.png" value="Löschen" onclick="if(confirm('Löschen und alle Inhalte verlieren?')){ document.location.href='<g:createLink controller="likes" action="deleteLike" params="[name: it.likename]"/>'}"/>

        </td>

    </tr>

</g:each>
</table>

    <br> <br>

<h3> Neues Like eintragen: </h3>

<g:form controller="likes" action="saveLike">
<table>
    <tr>
        <td> Bezeichnung </td>
        <td> Wochentag </td>
        <td> Priorit&auml;t </td>
        <td> Beginn </td>
        <td> Dauer (in h) </td>
    </tr>
    <tr>
        <td> <g:field name="likename" type="text" required=""/> </td>
        <td> <g:select name="dayOfWeek" from="${['Mo', 'Di', 'Mi', 'Do', 'Fr', 'Sa', 'So']}" required=""/> </td>
        <td> <g:select name="priority" from="${1..10}" required=""/> </td>
        <td> <g:select name="starttime" from="${starttimesList}" required=""/> </td>
        <td> <g:select name="duration" from="${durationsList}" required=""/> </td>
    </tr>
    <tr>
        <td>  </td>
        <td>  </td>
        <td>  </td>
        <td>  </td>
        <td> <input type="submit" value="Speichern"/> </td>

    </tr>
</g:form>




</table>



</body>

</html>
