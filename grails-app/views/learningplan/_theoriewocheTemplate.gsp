<h1>Theoriewochenübersicht</h1>

<div id="theoriewoche">
    <g:each in="${1..12}">
            <g:link controller="learningplan" action="theoriewoche" id="${it}" class="${(params.id == it.toString()) ? 'active' : '' } button">TW ${it}</g:link>
    </g:each>
</div>



    <table class="table">
        <tr>

            <td class="tablehead">Montag</td>
            <td class="tablehead">Dienstag</td>
            <td class="tablehead">Mittwoch</td>
            <td class="tablehead">Donnerstag</td>
            <td class="tablehead">Freitag</td>
            <td class="tablehead">Samstag</td>
            <td class="tablehead">Sonntag</td>
        </tr>
        <tr>

            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>


        </tr>




    </table>


