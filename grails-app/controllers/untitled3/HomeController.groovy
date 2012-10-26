package untitled3

class HomeController {

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
