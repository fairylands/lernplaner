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

        if(User.findByLoginname(var.logn)) {

            flash.message = "Sorry, dieser Loginname ist bereits vergeben. Bitte wähle einen anderen."
            redirect(action: "register", params: [pren: var.pren, surn: var.surn, logn: var.logn])
            return false

        } else if (var.pwd != var.pwd2) {

            flash.message = "Die eingegebenen Passwörter stimmen nicht überein."
            redirect(action: "register", params: [pren: var.pren, surn: var.surn, logn: var.logn])
            return false

        } else if (!var.pren || !var.surn || !var.logn || !var.coursen || !var.pwd) {

            flash.message = "Bitte alle Felder ausfüllen!"
            redirect(action: "register", params: [pren: var.pren, surn: var.surn, logn: var.logn])
            return false

        } else {

            def tmp = Course.findByCoursename(var.coursen);
            new User(prename: var.pren, surname: var.surn, loginname: var.logn, password: var.pwd, course: tmp).save(flush: true, failOnError: true)

            flash.message = "Registrierung erfolgreich. Bitte einloggen."
            redirect(action: 'login')

        }

    }

    def insertNewCourse = {

        }

    def addCourse = {

        def var = getParams()

        if(Course.findByCoursename(var.cname)) {

            flash.message = "Dieser Kurs Existiert bereits."
            redirect(action: "register")
            return false

        } else if (!var.cname) {

            flash.message = "Bitte einen Kursnamen eintragen."
            redirect(action: "register")
            return false

        } else {

            def tmpCourse = new Course(coursename: var.cname)
                    tmpCourse.save(flush: true)

            if (var.sp1) {

                def tmpName = var.sp1.split()
                def tmpUser = User.findByPrenameAndSurname(tmpName[0], tmpName[1])
                tmpCourse.speaker1 = tmpUser
            }

            if (var.sp2) {
                tmpName = var.sp2.split()
                tmpUser = User.findByPrenameAndSurname(tmpName[0], tmpName[1])
                tmpCourse.speaker2 = tmpUser
            }

            flash.message = "Kurs wurde erfolgreich hinzugefügt."
            redirect(action: "register")
            return false

        }

    }
}
