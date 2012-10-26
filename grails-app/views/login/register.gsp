<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>

</head>





<body>

<h1>Registrieren</h1>

<table>

    <!-- folgende Inhalte später in die Datenbank eintragen oder abfragen (relevante Spalten, Datentypen) -->
    <tr>  <td> Vorname </td>     <td> <input type="text"></input> </td>  </tr>
    <tr>  <td> Name</td>         <td> <input type="text"></input> </td>  </tr>
    <tr>  <td> Loginname</td>    <td> <input type="text"></input> </td>  </tr>
    <tr>  <td> Passwort </td>    <td> <input type="text"></input> </td>  </tr>
    <tr>  <td> PasswortWiederholen </td>    <td> <input type="text"></input> </td>  </tr>

    <!-- später dann auswahlfeld -->
    <tr>  <td> Kursname </td>     <td><input type="text"></input>  </td>  </tr>

    <br>
    <br>

    <tr>
        <td></td>
        <td>
            <g:link controller="home">
                <input type="button" value="Registrieren"></input>
            </g:link>
        </td>
    </tr>

</table>