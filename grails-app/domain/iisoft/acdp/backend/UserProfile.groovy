package iisoft.acdp.backend

class UserProfile extends Profile{

    String userName
    String name
    String surname
    String mail
    Date   birthDate
    String  work
    String  git
    String  linkedin
    String        career
    List<String>  approvedSubjects

    static constraints = {
        mail       nullable:false, blank:false, maxSize:255, unique:true
        userName   nullable:false
        name       nullable:false
        surname    nullable:false
        birthDate  nullable:false
        work      nullable:true
        git       nullable:true
        linkedin  nullable:true
        career      nullable:true

    }
}
