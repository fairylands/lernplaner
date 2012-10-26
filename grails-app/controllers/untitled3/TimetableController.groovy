package untitled3

class TimetableController {

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
}
