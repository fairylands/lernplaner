<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

		<title>Lernplaner</title>                    <!-- Wenn kein Titel angegeben ist-->

		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">

		<g:layoutHead/>
		<r:layoutResources />
	</head>




	<body>
        <div id="wrapper">
            <div id="headline">

                    <img id="logo" src="${resource(dir: 'images', file: 'dhbwlogo.png')}" alt=""/>
                    <g:layoutTitle default="Lernplaner"/>

            </div>


            <div id="menu">
                <g:link controller="home" class="button">

                    Home</g:link>
                <g:link controller="timetable" class="button">
                    <img src="${resource(dir: 'images', file: 'stundenplan-icon-kl.png')}" alt=""/>
                    Stundenplan
                </g:link>
                <g:link controller="learningplan" class="button">
                    <img src="${resource(dir: 'images', file: 'lernplan-icon-kl.png')}" alt=""/>
                    Lernplan
                </g:link>
                <g:link controller="login" action="doLogout" class="button">Logout</g:link>


            </div>

            <div id="content">


                <g:layoutBody/>

            </div>






       <jq:resources />
		<g:javascript library="application"/>
		<r:layoutResources />


        </div>
	</body>
</html>
