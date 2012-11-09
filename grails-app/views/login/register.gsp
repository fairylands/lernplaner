<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="notLoggedIn"/>

</head>





<body>

<h1>Registrieren</h1>

<table>

    <!-- folgende Inhalte später in die Datenbank eintragen oder abfragen (relevante Spalten, Datentypen) -->
    <g:form controller="login" action="doRegistration" id="reg">
    <tr>  <td> Vorname </td>     <td> <input type="text" name="pren"/> </td>  </tr>
    <tr>  <td> Name</td>         <td> <input type="text" name="surn"/> </td>  </tr>
    <tr>  <td> Loginname</td>    <td> <input type="text" name="logn"/> </td>  </tr>
    <tr>  <td> Passwort </td>    <td> <input type="text" name="pwd"/> </td>  </tr>
    <tr>  <td> PasswortWiederholen </td>    <td> <input type="text"></input> </td>  </tr>

    <!-- später dann auswahlfeld -->
    <tr>  <td> Kursname </td>     <td><input type="text"></input>  </td>  </tr>

    <tr>  <td></td>              <td> <input type="submit" value="Registrieren"></input> </td></tr>
    </g:form>


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

<br>


<g:link controller="login" action="login" class="button">

    Zum Login

</g:link>

<br>
<br>