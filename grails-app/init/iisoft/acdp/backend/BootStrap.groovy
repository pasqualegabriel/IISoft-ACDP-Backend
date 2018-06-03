package iisoft.acdp.backend

class BootStrap {

    def init = { servletContext ->
        def pepita    = new User(name:"pepita")
        pepita.save()

        def category1 = new Category(name:"IISoftware" )
        def category2 = new Category(name:"Intro")
        category1.save()
        category2.save()

        def publication1 = new Publication(text:"CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS" ,idCategory: category1.id,name: "Retrospective",
                title: "RetrospectiveIISoft",
                whoPublishedIt: "Diego",
                date: new Date(2018, 06, 22))
        def publication2 = new Publication(text:"CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS" ,idCategory: category2.id,name: "BDD",
                title: "BDDIISoft",
                whoPublishedIt: "Pablo",
                date: new Date(2017, 05, 10))
        def publication3 = new Publication(text:"CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS" ,idCategory: category2.id,name: "TDD",
                title: "TDDIISoft",
                whoPublishedIt: "Diego",
                date: new Date(2016, 02, 14))

        category1.publications = [publication1]
        category2.publications = [publication2, publication3]
        category1.save()
        category2.save()

        Comentary comentaryForPub1        = new Comentary(text:"CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS" ,idPublication: publication1.id,
                whoPublishedIt: "Diego",
                date: new Date(2013, 07, 22))
        Comentary otherComentaryForPub1        = new Comentary(text:"CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS" ,idPublication: publication1.id,
                whoPublishedIt: "Diego",
                date: new Date(2013, 07, 22))

        Comentary comentaryForPub2        = new Comentary(text:"CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS" ,idPublication: publication2.id,
                whoPublishedIt: "Diego",
                date: new Date(2013, 07, 22))

        Comentary comentaryForPub3        = new Comentary(text:"CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS" ,idPublication: publication3.id,
                whoPublishedIt: "Diego",
                date: new Date(2013, 07, 22))
        Comentary otherComentaryForPub3        = new Comentary(text:"CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS" ,idPublication: publication3.id,
                whoPublishedIt: "Diego",
                date: new Date(2013, 07, 22))
        Comentary anotherComentaryForPub3        = new Comentary(text:"CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS" ,idPublication: publication3.id,
                whoPublishedIt: "Diego",
                date: new Date(2013, 07, 22))

        comentaryForPub1.save()
        otherComentaryForPub1.save()

        comentaryForPub2.save()

        comentaryForPub3.save()
        otherComentaryForPub3.save()
        anotherComentaryForPub3.save()


    }

    def destroy = {
    }
}
