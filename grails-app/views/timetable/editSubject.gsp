<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>
    <g:form controller="timetable" action="safenewsubject" id="${subject.id}">
        <div id="timetable">

            <table>
                <h1>Fach bearbeiten: </h1>
                <tr>
                    <td> Fach </td>
                    <td> <g:field name="subjectname" type="text" value="${subject.subjectname}" required=""/> </td>
                </tr>

                <tr>
                    <td> Kürzel </td>
                    <td> <g:field name="kuerzel" type="text" value="${subject.kuerzel}" required=""/> </td>
                </tr>

                <tr>
                    <td> Dozent </td>
                    <td> <g:field name="profname" type="text" value="${subject.professor.profname}" required="" /> </td>
                </tr>

                <tr>
                    <td> Präsenzstunden </td>
                    <td> <g:field name="hours" type="number" step="1" min="0" value="${subject.hours}" required=""/> </td>
                </tr>

                <tr>
                    <td> Selbststudium </td>
                    <td> <g:field name="selfstudy" type="number" step="1" min="0" value="${subject.selfstudy}" required=""/> </td>
                </tr>

                <tr>
                    <td> Modulname </td>
                    <td> <g:field name="modul" type="text" value="${subject.modul}" required=""/> </td>
                </tr>

                <tr>
                    <td> Prüfungsform </td>
                    <td> <g:field name="typeOfExam" type="text" value="${subject.typeOfExam}" required=""/> </td>
                </tr>

                <tr>
                    <td> Credit Points </td>
                    <td>  <g:field name="creditpoints" type="number" step="1" min="0" value="${subject.creditpoints}" required=""/> </td>
                </tr>
            </table>

        <br>
        <p>${session.user}</p>
        <g:actionSubmit controller="timetable" action="safenewsubject" value="Speichern"/>
        <input type="button" value="Abbrechen" onclick="if(confirm('Abbrechen und alle Änderungen verlieren?')){ document.location.href='<g:createLink controller="timetable" action="timetable"/>'}"/>

        </div>
        <div id="termtable">

            <table class="table">
                <h1> Zeiten eintragen: </h1>
                <tr>
                    <td class="tablehead">Wochentag</td>
                    <td class="tablehead">Beginn</td>
                    <td class="tablehead">Ende</td>
                    <td class="tablehead">Dauer</td>
                </tr>

                <g:each in="${subject.term}">
                    <tr>
                        <td><g:field name="dayOfWeek" type="text" class="eingabefeldwochentag" value="${it.dayOfWeek}" /></td>
                        <td><g:field name="starttime" type="text" class="eingabefeld" value="${it.starttime}"/></td>
                        <td><g:field name="endtime" type="text" class="eingabefeld" value="${it.endtime}"/></td>
                        <td><g:field name="duration" type="text" class="eingabefeld" value="${it.duration}"/></td>
                    </tr>
                </g:each>
            </table>

        <br>
        <a onclick="plusZeile()">
            <img src="${resource(dir: 'images', file: 'plus.png')}" alt="bild"/>
        </a>
        </div>
    </g:form>


</body>
</html>