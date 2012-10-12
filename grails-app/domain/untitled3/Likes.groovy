package untitled3

class Likes {

    String likename
    Integer priority

    static hasMany = [term:Term]
    static mappedBy = [term: "starttime"]



    static constraints = {
    }
}
