package untitled3

class TimetableController {

    def beforeInterceptor = {

        if(session.user == null) {

            redirect(controller: 'login', action: 'doLogin')
        }
    }

    def index(){
        redirect(action:   'timetable')
    }

    def timetable() {
    }

    def insertnewsubject = {


        def staticAuthor = "Anonymus"
        def staticContent = "Hello World"
        [author: staticAuthor, content: staticContent]
    }

    def editsubject(){


    }

    def deletesubject(){

    }

    def safenewsubject(Subject subject){   //neues Subject und Werte werden automatisch eingefüllt

        //def subject = new  Subject(params)

        if (!subject.save()){

            printf("Fehler")
            println subject.errors

        }


        redirect(action: 'timetable')


    }
}
