package untitled3

import org.springframework.dao.DataIntegrityViolationException

class CourseController {

    static scaffold = true

    def beforeInterceptor = {

        if(session.user == null) {

            redirect(controller: 'login', action: 'doLogin')
            return false
        }

        if(!session.user.isAttached()) {

            session.user.attach()
        }
    }
}
