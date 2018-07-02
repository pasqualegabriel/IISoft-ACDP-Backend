package iisoft.acdp.backend

class UserWorkProfile extends Profile {
    String  work
    String  git
    String  linkedin


    static constraints = {
        work      nullable:true
        git       nullable:true
        linkedin  nullable:true
    }
}