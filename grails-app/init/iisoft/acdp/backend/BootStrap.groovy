package iisoft.acdp.backend

class BootStrap {

    def init = { servletContext ->
        def pepita    = new User(name:"pepita")
        pepita.save()

        def category1 = new Category(name:"IISoftware" )
        def category2 = new Category(name:"Intro")
        category1.save()
        category2.save()

        def publication1 = new Publication( text           : "The Sprint Retrospective",
                                            idCategory     : category1.id,
                                            name           : "Retrospective",
                                            title          : "RetrospectiveIISoft",
                                            whoPublishedIt : "Diego",
                                            date           : new Date(2018, 06, 22)
                                          )

        def publication2 = new Publication( text           : "Behavior-Driven Development",
                                            idCategory     : category2.id,
                                            name           : "BDD",
                                            title          : "BDDIISoft",
                                            whoPublishedIt : "Pablo",
                                            date           : new Date(2017, 05, 10)
                                          )

        def publication3 = new Publication( text           : "Test-driven development",
                                            idCategory     : category2.id,
                                            name           : "TDD",
                                            title          : "TDDIISoft",
                                            whoPublishedIt : "Dario",
                                            date           : new Date(2016, 02, 14)
                                          )

        category1.publications = [publication1]
        category2.publications = [publication2, publication3]
        publication1.save()
        publication2.save()
        publication3.save()

        Commentary commentaryForPub1        = new Commentary(   text            : "Is an opportunity for the Scrum Team to inspect itself",
                                                                idPublication   : publication1.id,
                                                                whoPublishedIt  : "Marcos",
                                                                date            : new Date(2013, 01, 21)
                                                            )

        Commentary otherCommentaryForPub1   = new Commentary(   text            : "Create a plan for improvements to be enacted during the next Sprint",
                                                                idPublication   : publication1.id,
                                                                whoPublishedIt  : "Martin",
                                                                date            : new Date(2013, 02, 18)
                                                            )

        Commentary commentaryForPub2        = new Commentary(   text            : "Is a software development process that emerged from TDD",
                                                                idPublication   : publication2.id,
                                                                whoPublishedIt  : "Ivan",
                                                                date            : new Date(2013, 03, 22)
                                                            )

        Commentary commentaryForPub3        = new Commentary(   text            : "Is principally an idea about how software development should be managed by both business interests and technical insight",
                                                                idPublication   : publication2.id,
                                                                whoPublishedIt  : "Gabriel",
                                                                date            : new Date(2013, 04, 23)
                                                            )

        Commentary otherCommentaryForPub3   = new Commentary(   text            : "Is a software development process",
                                                                idPublication   : publication3.id,
                                                                whoPublishedIt  : "Nahuel",
                                                                date            : new Date(2013, 05, 21)
                                                            )

        Commentary anotherCommentaryForPub3 = new Commentary(   text            : "Is related to the test-first programming concepts of extreme programming",
                                                                idPublication   : publication3.id,
                                                                whoPublishedIt  : "Victor",
                                                                date            : new Date(2013, 06, 13)
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
