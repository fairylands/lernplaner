<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="notLoggedIn"/>

</head>





<body>

<h1>Registrieren</h1>

<table>

    <!-- folgende Inhalte später in die Datenbank eintragen oder abfragen (relevante Spalten, Datentypen) -->
    ${flash.message}
    <g:form controller="login" action="doRegistration" id="reg">
    <tr>  <td> Vorname </td>     <td> <input type="text" name="pren" value="${params.pren}" required=""/> </td>  </tr>
    <tr>  <td> Name</td>         <td> <input type="text" name="surn" value="${params.surn}" required=""/> </td>  </tr>
    <tr>  <td> Loginname</td>    <td> <input type="text" name="logn" value="${params.logn}" required=""/> </td>  </tr>
    <tr>  <td> Passwort </td>    <td> <input type="password" name="pwd" required=""/> </td>  </tr>
    <tr>  <td> Passwort Wiederholen </td>    <td> <input type="password" name="pwd2"  required=""/> </td>  </tr>
    <tr>  <td> Kursname </td>    <td> <g:select name="coursen" from="${untitled3.Course.list()}"/>
                                      <g:link controller="login" action="insertNewCourse">
                                        <img src="${resource(dir: 'images', file: 'plus.png')}" alt="bild"/>
                                      </g:link>
                                      </td></tr>

    <tr>  <td></td>              <td> <input type="submit" value="Registrieren"/> </td></tr>
    </g:form>


    <br>
    <br>

</table>

<br>


<g:link controller="login" action="login" class="button">

    Zum Login

</g:link>

<br>
<br>