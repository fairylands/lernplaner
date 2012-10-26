package untitled3

class LearningplanController {

    def beforeInterceptor = {

        if(session.user == null) {

            redirect(controller: 'login', action: 'doLogin')
        }
    }

    def index() {


           //if(login == true){

                redirect(action:  'learningplan')

           //}

    }

    def learningplan()  {}

}
