package untitled3

class Likes {

    String likename
    Integer priority

    static hasMany = [term:Term]

    static constraints = {
    }

    String toString() {

        likename
    }
}
