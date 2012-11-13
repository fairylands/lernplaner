package untitled3

class TimetableController {



    LernplanService lernplanService

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

            def termlist=[]
            subject.term.each {
                termlist.add(it)
            }
            termlist.each {
                subject.removeFromTerm(it)
            }


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
        def term;

        def daysOfWeek = request.getParameterValues('dayOfWeek')
        def starttime = request.getParameterValues('starttime')
        def endtime = request.getParameterValues('endtime')

        for (i=0; i < daysOfWeek.length; i++){
            term = new Term(dayOfWeek: daysOfWeek[i], starttime: lernplanService.zeitInZahl(starttime[i].toFloat()), endtime: lernplanService.zeitInZahl(endtime[i].toFloat()), duration: endtime[i].toFloat()-starttime[i].toFloat() )
            subject.addToTerm(term)
        }


        flash.message = "Änderungen gespeichert!"

        redirect(action: 'timetable')
    }
}
