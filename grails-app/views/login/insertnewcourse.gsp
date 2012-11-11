<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="notLoggedIn"/>

</head>





<body>

<h1>Neuen Kurs anlegen</h1>

<table>

    <g:form controller="login" action="addCourse">
        <tr>  <td> Kursname </td>          <td> <input type="text" name="cname" value="" required=""/> </td>  </tr>
        <tr>  <td> 1. Kurssprecher </td>   <td> <g:select name="sp1" from="${untitled3.User.list()}" noSelection="['':'---']"/> </td>  </tr>
        <tr>  <td> 2. Kurssprecher </td>   <td> <g:select name="sp2" from="${untitled3.User.list()}" noSelection="['':'---']"/> </td>  </tr>


        <tr>  <td></td>              <td> <input type="submit" value="Kurs eintragen"/> </td></tr>
    </g:form>


    <br>
    <br>

</table>

<br>




<br>
<br>