package untitled3

class User {

    String prename
    String surname
    String loginname
    String password

    Course course

    static hasMany = [likes:Likes]






    static constraints = {
    }
}
