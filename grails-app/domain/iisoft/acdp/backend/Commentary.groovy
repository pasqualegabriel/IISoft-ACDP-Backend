package iisoft.acdp.backend

class Commentary {

    long idPublication
    Date   date
    String text
    String whoPublishedIt

    static constraints = {
        idPublication   nullable:false
        whoPublishedIt  nullable:false
        text            nullable:false
        date            nullable:true
    }

    Commentary(){}
}
