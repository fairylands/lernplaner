package untitled3

class TermController {

    def beforeInterceptor = {

        if(session.user == null) {

            redirect(controller: 'login', action: 'doLogin')
        }
    }

    static scaffold = true
}
