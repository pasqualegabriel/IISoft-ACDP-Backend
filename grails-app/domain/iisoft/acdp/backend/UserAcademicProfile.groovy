package iisoft.acdp.backend

class UserAcademicProfile extends Profile {

    String        career
    List<String>  approvedSubjects


    static constraints = {
        career      nullable:true

    }
}
