<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<head>


<meta name="layout" content="main"/>


</head>


<body>
<g:form >
<table>

    <h1> Neues Fach eintragen: </h1>


    <!-- folgende Inhalte später via DB generieren (relevante Spalten, Datentypen) -->
    <tr>
        <td> Fach </td>
        <td>
            <g:field name="subjectname" type="text" required=""/>
        </td>
    </tr>
    <tr>
        <td> Dozent </td>
        <td>
            <g:field name="profname" type="text" required=""/>

        </td>
    </tr>
    <tr>
        <td> Präsenzstunden </td>
        <td>
            <g:field name="hours" type="number" step="1" min="0" required=""/>
        </td>
    </tr>
    <tr>
        <td> Selbststudium </td>
        <td>
            <g:field name="selfstudy" type="number" step="1" min="0" required=""/>
        </td>
    </tr>
    <tr>
        <td> Modulname </td>
        <td>
            <g:field name="modul" type="text" required=""/>
        </td>
    </tr>
    <tr>
        <td> Prüfungsform </td>
        <td>
            <g:field name="typeOfExam" type="text" required=""/>
        </td>
    </tr>
    <tr>
        <td> Credit Points </td>
        <td>
            <g:field name="creditpoints" type="number" step="1" min="0" required=""/>
        </td>
    </tr>
    <tr>
        <td></td>
        <td>
            <input type="button" value="Abbrechen" onclick="if(confirm('Abbrechen und alle Eingaben verlieren?')){ document.location.href='<g:createLink controller="timetable" action="timetable"/>'}"/>
            <g:actionSubmit controller="timetable" action="safenewsubject" value="Speichern"/>
        </td>
    </tr>

</table>
</g:form>

<p>${session.user}</p>

</body>
</html>