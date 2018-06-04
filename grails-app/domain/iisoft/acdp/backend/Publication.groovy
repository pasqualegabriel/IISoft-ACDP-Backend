package iisoft.acdp.backend

class Publication {

    Long  idCategory
    String  title
    String  whoPublishedIt
    String  text
    Date    date

    Publication(){}

    static belongsTo = Category

    static constraints = {
        idCategory      nullable:false
        title           nullable:false
        whoPublishedIt  nullable:false
        text            nullable:false
        date            nullable:true
    }

}
