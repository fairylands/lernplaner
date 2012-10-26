<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>

</head>
<body>

<table>

    <h1> Fach Löschen </h1>


    <!-- folgende Inhalte später via DB generieren (relevante Spalten, Datentypen) -->
    <tr>  <td> Fach (Modulname) </td>  <td> bla </td>  </tr>
    <tr>  <td> Dozent </td>            <td> bla </td>  </tr>
    <tr>  <td> Präsenzstunden </td>    <td> bla </td>  </tr>
    <tr>  <td> Selbststudium </td>     <td> bla </td>  </tr>
    <tr>  <td> Modulnummer </td>       <td> bla </td>  </tr>
    <tr>  <td> Prüfungsform </td>      <td> bla </td>  </tr>
    <tr>  <td> Credit Points </td>     <td> bla </td>  </tr>

    <tr>  <td></td>
        <td>
            <g:actionSubmit value="Abbrechen" onclick="return confirm('Abbrechen und alle Eingaben verlieren?')" />
            <input type="button" value="Fach löschen"></input>
        </td>
    </tr>

</table>

</body>
</html>