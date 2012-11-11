package untitled3

class TimetableController {

    def beforeInterceptor = {

        if (session.user == null) {

            redirect(controller: 'login', action: 'doLogin')
            return false
        }

        if(!session.user.isAttached()) {

            session.user.attach()
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

    def deletesubject(int id) {

        def subject = Subject.get(id)
        subject.delete(flush: true)
        flash.message = " - " + subject.subjectname + " gelöscht."
        redirect(action: "timetable")
        return false
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

        int i;

        println(params)

        for (i=0; i < params.dayOfWeek.size(); i++){
            subject.addToTerm(new Term(dayOfWeek: params.dayOfWeek[i], starttime: params.starttime[i], endtime: params.endtime[i], duration: params.duration[i] ))

        }


        flash.message = "Änderungen gespeichert!"

        redirect(action: 'timetable')
    }
}
