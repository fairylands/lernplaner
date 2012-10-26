package untitled3

class SubjectController {

    def beforeInterceptor = {

        if(session.user == null) {

            redirect(controller: 'login', action: 'doLogin')
        }
    }

    static scaffold = true
}
