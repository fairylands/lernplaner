package untitled3

class Professor {

    String profname
    static hasMany = [subject:Subject]
    static mappedBy = [subject:"subjectname"]

    static constraints = {
    }
}
