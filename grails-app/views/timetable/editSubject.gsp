<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>

</head>
<body>

<table>

    <h1> Fach Bearbeiten: </h1>


    <!-- folgende Inhalte später via DB generieren (relevante Spalten, Datentypen) -->
    <tr>  <td> Fach (Modulname) </td>  <td> <input type="text"></input> </td>  </tr>
    <tr>  <td> Dozent </td>            <td> <input type="text"></input> </td>  </tr>
    <tr>  <td> Präsenzstunden </td>    <td> <input type="number" step="1" min="0"></input> </td>  </tr>
    <tr>  <td> Selbststudium </td>     <td> <input type="number" step="1" min="0"></input> </td>  </tr>
    <tr>  <td> Modulnummer </td>       <td> <input type="text"></input> </td>  </tr>
    <tr>  <td> Prüfungsform </td>      <td> <input type="text"></input> </td>  </tr>
    <tr>  <td> Credit Points </td>     <td> <input type="number" step="1" min="0"></input> </td>  </tr>

    <tr>  <td></td>
        <td>
            <g:actionSubmit value="Abbrechen" onclick="return confirm('Abbrechen und alle Eingaben verlieren?')" />
            <input type="button" value="Änderungen abschließen"></input>
        </td>
    </tr>

</table>

</body>
</html>