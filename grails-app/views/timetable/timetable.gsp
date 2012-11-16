<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>

</head>






<body>

<div id="timetable">
<h3>Stundenplan</h3>
    <table class="table">
        <tr>

            <td class="tablehead">Montag</td>
            <td class="tablehead">Dienstag</td>
            <td class="tablehead">Mittwoch</td>
            <td class="tablehead">Donnerstag</td>
            <td class="tablehead">Freitag</td>
            <td class="tablehead">Samstag</td>
        </tr>
        <tr>
            <g:each in="${["Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"]}" var="ittag">
                <td class="timetabletd">
                    <div class="rahmentd">

                        <g:each in="${untitled3.Subject.list()}">
                            <g:each in="${it.term}" var="itterm">
                                <g:if test="${itterm.dayOfWeek == ittag || itterm.dayOfWeek == ittag.substring(0,2)}">

                                <div class="fach" style="top: ${(itterm.starttime-6)*20}px; height: ${itterm.duration*20}px;">${it.kuerzel}</div>


                            </g:if>
                    </g:each>
                </g:each>


                </div>
            </td>

            </g:each>

        </tr>




    </table>


</div>
<div id="termtable">
<h3>Fachübersicht</h3>
<g:if test="${flash.message}">
    <br>
    <h4>${flash.message}</h4>

</g:if>


    <table class="table">
        <tr>
            <td class="tablehead">Fach</td>
            <td class="tablehead">Dozent</td>
            <td class="tablehead">Prüfungsart</td>
            <td class="tablehead"></td>

        </tr>


    <g:each in="${untitled3.Subject.list()}">

        <tr>
            <td>${it.subjectname}</td>
            <td>${it.professor.profname}</td>
            <td>${it.typeOfExam}</td>

            <td>
                <g:link controller="timetable" action="editsubject" id="${it.id}">
                    <img src="${resource(dir: 'images', file: 'bearbeiten.png')}" alt="bild" title="Fach bearbeiten"/>
                </g:link>

                <input type="image" src="../images/loeschen.png" value="Löschen" onclick="if(confirm('Löschen und alle Inhalte verlieren?')){ document.location.href='<g:createLink controller="timetable" action="deletesubject" id="${it.id}"/>'}" title="Fach l&ouml;schen"/>

            </td>

        </tr>
    </g:each>

        <tr>
            <td></td>
            <td></td>
            <td></td>

            <td>
                <g:link controller="timetable" action="insertnewsubject">
                    <img src="${resource(dir: 'images', file: 'plus.png')}" alt="bild" title="Fach hinzuf&uuml;gen"/>
                </g:link>
             </td>

        </tr>




    </table>


</div>




</body>
</html>