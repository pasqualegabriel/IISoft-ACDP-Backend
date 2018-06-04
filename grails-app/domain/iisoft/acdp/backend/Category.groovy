package iisoft.acdp.backend

class Category {

    String name
    List<Publication> publications

    Category(){
        publications = []
    }

    static constraints = {

    }

    static hasMany   = [publications: Publication]

    static fetchMode = [publications: 'eager']

    static mapping = {
        publications cascade: 'all'
    }
}
