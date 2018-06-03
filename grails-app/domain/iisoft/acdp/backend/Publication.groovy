package iisoft.acdp.backend

class Publication {

    String  name
    String  title
    String  whoPublishedIt
    Date    date

    Publication(){}

    static belongsTo = Category

    static constraints = {
        name            nullable:false
        title           nullable:false
        whoPublishedIt  nullable:false
        date            nullable:true
    }

}
