import untitled3.User
import untitled3.Course
/**
 * Created with IntelliJ IDEA.
 * User: Sophie
 * Date: 26.10.12
 * Time: 11:57
 * To change this template use File | Settings | File Templates.
 */
class TestuserBootStrap {

    def init = { servletContext ->

        //def newc = new Course(coursename: "TINF11B", speaker1: "hnobis", speaker2: "mstrobel")
        //newc.save()
        //def c = Course.get(newc.id)

        new User (prename: "Nobis", surname: "Hanne", loginname: "hnobis", password: "123456").save()
    }
    def destroy = {
    }
}
