package untitled3

class TermController {

    def beforeInterceptor = {

        if(session.user == null) {

            redirect(controller: 'login', action: 'doLogin')
            return false
        }

        if(!session.user.isAttached()) {

            session.user.attach()
        }
    }
    static scaffold = true
}
