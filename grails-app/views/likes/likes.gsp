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
        <td class="tablehead"> Wochentag</td>
        <td class="tablehead"> Von </td>
        <td class="tablehead"> Bis </td>
        <td class="tablehead"> Von </td>

    </tr>

<g:each in="${userlikesList}">
    <tr>
        <td>${it.likename}</td>
        <td>${it.priority}</td>
        <td>${it.term.dayOfWeek}</td>
        <td>${it.term.starttime}</td>
        <td>${it.term.endtime}</td>

        <td>
            <g:link controller="likes" action="" id="${it.id}">
                <img src="${resource(dir: 'images', file: 'bearbeiten.png')}" alt="bild"/>
            </g:link>

            <input type="image" src="../images/loeschen.png" value="LÃƒÆ’Ã‚Â¶schen" onclick="if(confirm('LÃƒÆ’Ã‚Â¶schen und alle Inhalte verlieren?')){ document.location.href='<g:createLink controller="timetable" action="deletesubject" id="${it.id}"/>'}"/>

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
        <td> <input name="starttime" type="number" step="0.25" min="0" max="23.45" required=""/> </td>
        <td> <input name="duration" type="number" step="0.25" min="0.25" required=""/> </td>
    </tr>
    <tr>
        <td>  </td>
        <td>  </td>
        <td>  </td>
        <td>  </td>
        <td> <input type="submit" value="Speichern"/> </td

    </tr>
</g:form>




</table>



</body>

</html>
