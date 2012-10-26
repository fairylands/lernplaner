    <!-- folgende Inhalte spÃ¤ter in die Datenbank eintragen oder abfragen (relevante Spalten, Datentypen) -->
    <g:form controller="login" action="doLogin">
    <tr>  <td> Loginname</td>    <td> <input type="text" name="loginname"/> </td>  </tr>
    <tr>  <td> Passwort </td>    <td> <input type="password" name="password"/> </td>  </tr>
    <tr>  <td>          </td>    <td> <input type="submit" value="Login"/> </td>  </tr>
    </g:form>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="notLoggedIn"/>

</head>





<body>

 <h1>Login</h1>

<table>

    ${flash.message}
    <!-- folgende Inhalte später in die Datenbank eintragen oder abfragen (relevante Spalten, Datentypen) -->
    <g:form controller="login" action="doLogin">
        <tr>  <td> Loginname</td>    <td> <input type="text" name="loginname"/> </td>  </tr>
        <tr>  <td> Passwort </td>    <td> <input type="password" name="password"/> </td>  </tr>
        <tr>  <td>          </td>    <td> <input type="submit" value="Login"/> </td>  </tr>
    </g:form>


</table>


<br>
<g:link controller="login" action="register" class="button">

    Neu Registrieren

</g:link>
<br>
<br>

</body>
</html>