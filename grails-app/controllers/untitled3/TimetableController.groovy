package untitled3

class TimetableController {

    def beforeInterceptor = {

        if (session.user == null) {

            redirect(controller: 'login', action: 'doLogin')
        }
    }

    def index() {
        redirect(action: 'timetable')
    }

    def timetable() {
        [subjects: Subject.list()]
    }

    def insertnewsubject = {


        def staticAuthor = "Anonymus"
        def staticContent = "Hello World"
        [author: staticAuthor, content: staticContent]
    }

    def editsubject(int id) {

        [subject: Subject.get(id)]


    }

    def deletesubject() {

    }

    def safenewsubject() {   //neues Subject und Werte werden automatisch eingefüllt

        def subject;
        if (params.id) {
            subject = Subject.get(params.id)
            subject.properties = params
        }
        else {
            subject = new Subject(params)
        }

        def professor = Professor.findByProfname(params.profname)

        if (!professor) {
            professor = new Professor(profname: params.profname).save()
        }

        subject.professor = professor

        if (!subject.save()) {
            printf("Fehler")
            println subject.errors
        }

        professor.addToSubject(subject)
        professor.save()

        redirect(action: 'timetable')
    }
}
