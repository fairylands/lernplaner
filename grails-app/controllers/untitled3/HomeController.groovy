package untitled3

class HomeController {

    def beforeInterceptor = {

        if(session.user == null) {

            redirect(controller: 'login', action: 'doLogin')
            return false
        }

        if(!session.user.isAttached()) {

            session.user.attach()
        }
    }

    boolean login = true;

    def index() {




        //Überprüfung ob der User eingeloggt ist
        if(login==true){
            //wenn ja, dann sollt die Hauptseite aufgerufen werden
            redirect(action:  'home')
            render "Login erfolgreich"



        }else{

            redirect(action: 'login')

            def answer= "Sie sind noch nicht eingeloggt"

            [answer: answer ]




        }

    }



    def home(){




    }

    def login(){


    }
}
