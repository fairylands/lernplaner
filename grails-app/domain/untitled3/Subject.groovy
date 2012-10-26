package untitled3

class Subject {

    String subjectname
    Professor professor
    String typeOfExam
    Integer hours
    Integer selfstudy
    String modul
    Integer creditpoints


    static hasMany = [term:Term]

    static constraints = {

        professor(nullable: true)

    }
}
