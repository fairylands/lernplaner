package untitled3

class LoginController {

    def index() {

    }

    def login(){

        //hier müsste die Login-Eingabemaske hin!

    }

    def doLogin = {

        flash.message = ""

        if(params.loginname == "admin" && params.password == "123456") {

            session.user = "admin"
            redirect(controller: 'home')

        } else {

            flash.message = "Login fehlgeschlagen."
            redirect(action: 'login')

        }

    }

    def doLogout = {

        session.user = null
        flash.message = "Logout erfolgreich."
        redirect(action: 'login')
    }

    def register(){


    }
}
