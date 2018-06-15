package iisoft.acdp.backend

class User {

    String name
    String surname
    String userName
    String password
    String mail
    Date   birthDate

    static constraints = {
        userName   nullable:false, blank:false, maxSize:255, unique:true
        mail       nullable:false, blank:false, maxSize:255, unique:true
        name       nullable:false
        surname    nullable:false
        password   nullable:false
        birthDate  nullable:false
    }
}
