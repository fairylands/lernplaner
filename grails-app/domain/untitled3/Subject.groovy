package untitled3

class Subject {

    String subjectname
    String kuerzel
    String typeOfExam
    Integer hours
    Integer selfstudy
    String modul
    Integer creditpoints

    static belongsTo = [professor: Professor]
    static hasMany = [term: Term]

    static constraints = {

        professor(nullable: true)
    }
}
