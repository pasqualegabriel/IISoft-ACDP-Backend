package iisoft.acdp.backend

class Comentary {

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

    Comentary(){}
}
