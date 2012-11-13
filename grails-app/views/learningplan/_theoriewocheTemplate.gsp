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

            <g:each in="${["Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"]}" var="ittag">
                <td class="timetabletd">
                    <div class="rahmentd">

                        <g:each in="${untitled3.Subject.list()}">
                            <g:each in="${it.term}" var="itterm">
                                <g:if test="${itterm.dayOfWeek == ittag || itterm.dayOfWeek == ittag.substring(0,2)}">

                                    <div class="fach" style="top: ${(itterm.starttime-6)*20}px; height: ${itterm.duration*20}px;">${it.kuerzel}</div>


                                </g:if>
                            </g:each>
                        </g:each>

                        <g:each in="${untitled3.User.findByLoginname(session.user.loginname).likes}">
                            <g:each in="${it.term}" var="itterm">
                                <g:if test="${itterm.dayOfWeek == ittag || itterm.dayOfWeek == ittag.substring(0,2)}">

                                    <div class="fach" style="top: ${(itterm.starttime-6)*20}px; height: ${itterm.duration*20}px;">${it.likename}</div>

                                </g:if>
                            </g:each>
                        </g:each>

            </g:each>

        </tr>




    </table>


