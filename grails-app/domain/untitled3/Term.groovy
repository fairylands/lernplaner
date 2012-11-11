package untitled3

class Term {

    String dayOfWeek
    float starttime
    float endtime
    float duration

    static belongsTo = [subject: Subject]

    static constraints = {

        subject(nullable: true) //Weil es ja auch Terms gibt, die zu einem Like gehören
    }
}
