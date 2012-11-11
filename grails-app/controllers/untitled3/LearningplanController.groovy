package untitled3

class LearningplanController {

    def beforeInterceptor = {

        if(session.user == null) {

            redirect(controller: 'login', action: 'doLogin')
            return false
        }

        if(!session.user.isAttached()) {

            session.user.attach()
        }
    }

    def index() {


           //if(login == true){

                redirect(action:  'learningplan')

           //}

    }

    def learningplan()  {}

}
