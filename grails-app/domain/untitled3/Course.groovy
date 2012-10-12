package untitled3

class Course {

    String coursename

    static hasMany = [subject:Subject]
    static mappedBy = [subject:"subjectname"]

    User speaker1
    User speaker2


    static constraints = {
    }
}
