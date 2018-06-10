package iisoft.acdp.backend

class BootStrap {

    def init = { servletContext ->
        def pepita    = new User(name:"pepita")
        pepita.save()

        def category1 = new Category(name:"IISoftware" )
        def category2 = new Category(name:"Intro")
        category1.save()
        category2.save()

        def publication1 = new Publication  (   text            : "CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS",
                                                idCategory      : category1.id,
                                                name            : "Retrospective",
                                                title           : "RetrospectiveIISoft",
                                                whoPublishedIt  : "Diego",
                                                date            : new Date(2018, 06, 22)
                                            )

        def publication2 = new Publication  (   text            : "CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS",
                                                idCategory      : category2.id,
                                                name            : "BDD",
                                                title           : "BDDIISoft",
                                                whoPublishedIt  : "Pablo",
                                                date            : new Date(2017, 05, 10)
                                            )

        def publication3 = new Publication  (   text            : "CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS",
                                                idCategory      : category2.id,
                                                name            : "TDD",
                                                title           : "TDDIISoft",
                                                whoPublishedIt  : "Diego",
                                                date            : new Date(2016, 02, 14)
                                            )

        category1.publications = [publication1]
        category2.publications = [publication2, publication3]
//        category1.save()
//        category2.save()
        publication1.save()
        publication2.save()
        publication3.save()

        Commentary commentaryForPub1        = new Commentary(   text            : "CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS",
                                                                idPublication   : publication1.id,
                                                                whoPublishedIt  : "Diego",
                                                                date            : new Date(2013, 07, 22)
                                                            )

        Commentary otherCommentaryForPub1   = new Commentary(   text            : "CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS",
                                                                idPublication   : publication1.id,
                                                                whoPublishedIt  : "Diego",
                                                                date            : new Date(2013, 07, 22)
                                                            )

        Commentary commentaryForPub2        = new Commentary(   text            : "CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS",
                                                                idPublication   : publication2.id,
                                                                whoPublishedIt  : "Diego",
                                                                date            : new Date(2013, 07, 22)
                                                            )

        Commentary commentaryForPub3        = new Commentary(   text            : "CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS",
                                                                idPublication   : publication3.id,
                                                                whoPublishedIt  : "Diego",
                                                                date            : new Date(2013, 07, 22)
                                                            )

        Commentary otherCommentaryForPub3   = new Commentary(   text            : "CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS",
                                                                idPublication   : publication3.id,
                                                                whoPublishedIt  : "Diego",
                                                                date            : new Date(2013, 07, 22)
                                                            )

        Commentary anotherCommentaryForPub3 = new Commentary(   text            : "CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS",
                                                                idPublication   : publication3.id,
                                                                whoPublishedIt  : "Diego",
                                                                date            : new Date(2013, 07, 22)
                                                            )

        commentaryForPub1.save()
        otherCommentaryForPub1.save()

        commentaryForPub2.save()

        commentaryForPub3.save()
        otherCommentaryForPub3.save()
        anotherCommentaryForPub3.save()
    }

    def destroy = {
    }
}
