package untitled3

class Course {

    String coursename

    static hasMany = [subject:Subject]

    User speaker1
    User speaker2


    static constraints = {

        subject(nullable: true)
        speaker1(nullable: true)
        speaker2(nullable: true)

    }

    String toString()
    {
        coursename
    }
}
