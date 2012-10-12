package untitled3

class Subject {

    String subjectname
    Professor professor
    String typeOfExam

    static hasMany = [term:Term]
    static mappedBy = [term: "starttime"]




    static constraints = {
    }
}
