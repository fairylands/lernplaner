package untitled3

class User {

    String prename
    String surname

    Course course

    static hasMany = [likes:Likes]
    static mappedBy = [likes: "likename"]





    static constraints = {
    }
}
