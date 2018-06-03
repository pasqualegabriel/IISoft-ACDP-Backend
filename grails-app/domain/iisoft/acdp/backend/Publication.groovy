package iisoft.acdp.backend

class Publication {


    Long  idCategory
    String  name
    String  title
    String  whoPublishedIt
    String  text
    Date    date

    Publication(){}

    static belongsTo = Category

    static constraints = {
        idCategory      nullable:false
        name            nullable:true
        title           nullable:false
        whoPublishedIt  nullable:false
        text            nullable:false
        date            nullable:true
    }

}
