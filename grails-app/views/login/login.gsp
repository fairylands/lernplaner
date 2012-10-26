<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="notLoggedIn"/>

</head>





<body>

 <h1>Login</h1>

<table>

    <!-- folgende Inhalte später in die Datenbank eintragen oder abfragen (relevante Spalten, Datentypen) -->

    <tr>  <td> Loginname</td>    <td> <input type="text"></input> </td>  </tr>
    <tr>  <td> Passwort </td>    <td> <input type="text"></input> </td>  </tr>

    <br>
    <br>

    <tr>
        <td></td>
            <td>
                <g:link controller="home">
                    <input type="button" value="Einloggen"></input>
                </g:link>
            </td>
    </tr>

</table>


<br>
<g:link controller="login" action="register" class="button">

    Neu Registrieren

</g:link>
<br>
<br>

</body>
</html>