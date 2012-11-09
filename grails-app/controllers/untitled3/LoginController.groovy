package untitled3

class LoginController {

    def index() {

    }

    def login(){

        //hier müsste die Login-Eingabemaske hin!

    }

    def doLogin = {

        flash.message = ""

        def tmp = User.findByLoginnameAndPassword(params.loginname, params.password)

        if(tmp) {

            session.user = tmp
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


    def doRegistration = {

        def var = getParams()
        render var.pren
        new User(prename: "Hanne", surname: "Nobis", loginname: "hanne", password: "123", course: tinf, likes: [sport]).save(flush: true)

        //render Term.list()
        //render "<br>"
        //render User.list()
    }
}
