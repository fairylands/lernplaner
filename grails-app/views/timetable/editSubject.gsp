<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>

</head>
<body>
<g:form controller="timetable" action="safenewsubject" id="${subject.id}">
    <table>

        <h1>Fach bearbeiten: </h1>


        <!-- folgende Inhalte später via DB generieren (relevante Spalten, Datentypen) -->
        <tr>
            <td> Fach </td>
            <td>
                <g:field name="subjectname" type="text" value="${subject.subjectname}"/>
            </td>
        </tr>
        <tr>
            <td> Dozent </td>
            <td>
                <g:field name="profname" type="text" value="${subject.professor.profname}" />

            </td>
        </tr>
        <tr>
            <td> Präsenzstunden </td>
            <td>
                <g:field name="hours" type="number" step="1" min="0" value="${subject.hours}"/>
            </td>
        </tr>
        <tr>
            <td> Selbststudium </td>
            <td>
                <g:field name="selfstudy" type="number" step="1" min="0" value="${subject.selfstudy}"/>
            </td>
        </tr>
        <tr>
            <td> Modulname </td>
            <td>
                <g:field name="modul" type="text" value="${subject.modul}"/>
            </td>
        </tr>
        <tr>
            <td> Prüfungsform </td>
            <td>
                <g:field name="typeOfExam" type="text" value="${subject.typeOfExam}"/>
            </td>
        </tr>
        <tr>
            <td> Credit Points </td>
            <td>
                <g:field name="creditpoints" type="number" step="1" min="0" value="${subject.creditpoints}"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <g:actionSubmit controller="timetable" action="safenewsubject" value="Speichern"/>
                <g:actionSubmit value="Abbrechen" onclick="return confirm('Abbrechen und alle Eingaben verlieren?')" />

            </td>
        </tr>

    </table>


</g:form>

<p>${session.user}</p>

</body>
</html>