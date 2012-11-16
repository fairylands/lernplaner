<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>

</head>





<body>

 HOME <br> <br>

<p>Hallo ${session.user.prename}!</p>

<table class="table">

    <h2> Aktivit&auml;ten &nbsp;
        <g:link controller="likes" action="likes">
            <img src="${resource(dir: 'images', file: 'bearbeiten.png')}" title="Aktivit&auml;ten bearbeiten" alt="bild"/>
        </g:link>
    </h2>

    <tr>
        <td class="tablehead"> Aktivit&auml;ten </td>
        <td class="tablehead"> Priorit&auml;t</td>
        <td class="tablehead" style="width: 150px"> Zeit</td>

    </tr>

    <g:each in="${untitled3.User.findByLoginname(session.user.loginname).likes}">
        <tr>
            <td>${it.likename}</td>
            <td>${it.priority}</td>
            <td><g:each var="t" in="${it.term}"> ${t.dayOfWeek}, ${ t.getStarttimeConverted() } - ${t.getEndtimeConverted() } <br></g:each></td>
        </tr>

    </g:each>
</table>


</body>
</html>
