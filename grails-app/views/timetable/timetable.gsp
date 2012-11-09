<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>

</head>






<body>

<div id="timetable">
Tabelle mit Stundenplan
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

            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>

        </tr>




    </table>


</div>
<div id="termtable">
Tabelle mit Fachübersicht

    <table class="table">
        <tr>
            <td class="tablehead">Fach</td>
            <td class="tablehead">Dozent</td>
            <td class="tablehead">Prüfungsart</td>
            <td class="tablehead">Änderungen</td>

        </tr>


    <g:each in="${subjects}">



        <tr>
            <td>${it.subjectname}</td>
            <td>${it.professor.profname}</td>
            <td>${it.typeOfExam}</td>

            <td>
                <g:link controller="timetable" action="editsubject" id="${it.id}">
                    <img src="${resource(dir: 'images', file: 'bearbeiten.png')}" alt="bild"/>
                </g:link>

                <g:link controller="timetable" action="deletesubject">
                    <img src="${resource(dir: 'images', file: 'loeschen.png')}" alt="bild"/>
                </g:link>
            </td>

        </tr>
    </g:each>

        <tr>
            <td></td>
            <td></td>
            <td></td>

            <td>
                <g:link controller="timetable" action="insertnewsubject">
                    <img src="${resource(dir: 'images', file: 'plus.png')}" alt="bild"/>
                </g:link>
             </td>

        </tr>




    </table>

</div>




</body>
</html>