package iisoft.acdp.backend

abstract class Profile {
    long          userID

    static constraints = {
        userID    nullable:false
    }
}
