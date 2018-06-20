package iisoft.acdp.backend

class BootStrap {

    def init = { servletContext ->
        def pepita = new User(name:"pepita", surname: "Swallow", userName: "pepita",
                password: "pepitaPassword", mail: "pepita@gmail.com", birthDate: new Date(2018, 06, 22))
        def ivan = new User(name:"Ivan", surname: "D", userName: "ivan",
                password: "password", mail: "ivan@gmail.com", birthDate: new Date(2018, 06, 22))
        def nahu = new User(name:"Nahu", surname: "A", userName: "nahu",
                password: "password", mail: "nahu@gmail.com", birthDate: new Date(2018, 06, 22))
        def gabi = new User(name:"Gabi", surname: "P", userName: "gabi",
                password: "password", mail: "gabi@gmail.com", birthDate: new Date(2018, 06, 22))
        def victor = new User(name:"Victor", surname: "D", userName: "victor",
                password: "password", mail: "victor@gmail.com", birthDate: new Date(2018, 06, 22))
        def diego = new User(name:"Diego", surname: "Diego", userName: "diego",
                password: "password", mail: "diego@gmail.com", birthDate: new Date(2018, 06, 22))
        def pablo = new User(name:"Pablo", surname: "Suarez", userName: "pablo",
                password: "password", mail: "pablo@gmail.com", birthDate: new Date(2018, 06, 22))

        pepita.save()
        ivan.save()
        nahu.save()
        gabi.save()
        victor.save()
        diego.save()
        pablo.save()

        def category1 = new Category(name:"IISoftware" )
        def category2 = new Category(name:"Intro")
        category1.save()
        category2.save()

        def publication1 = new Publication( text           : "The Sprint Retrospective",
                                            idCategory     : category1.id,
                                            name           : "Retrospective",
                                            title          : "RetrospectiveIISoft",
                                            whoPublishedIt : diego.userName,
                                            date           : new Date(2018, 06, 22)
                                          )
        publication1.subscribe(ivan.userName)

        def publication2 = new Publication( text           : "Behavior-Driven Development",
                                            idCategory     : category2.id,
                                            name           : "BDD",
                                            title          : "BDDIISoft",
                                            whoPublishedIt : pablo.userName,
                                            date           : new Date(2017, 05, 10)
                                          )
        publication2.subscribe(nahu.userName)
        publication2.subscribe(gabi.userName)
        publication2.subscribe(victor.userName)

        def publication3 = new Publication( text           : "Test-driven development",
                                            idCategory     : category2.id,
                                            name           : "TDD",
                                            title          : "TDDIISoft",
                                            whoPublishedIt : ivan.userName,
                                            date           : new Date(2016, 02, 14)
                                          )

        publication3.subscribe(diego.userName)
        publication3.subscribe(pablo.userName)

        category1.publications = [publication1]
        category2.publications = [publication2, publication3]
        publication1.save()
        publication2.save()
        publication3.save()

        Commentary commentaryForPub1        = new Commentary(   text            : "Is an opportunity for the Scrum Team to inspect itself",
                                                                idPublication   : publication1.id,
                                                                whoPublishedIt  : gabi.userName,
                                                                date            : new Date(2013, 01, 21)
                                                            )

        Commentary otherCommentaryForPub1   = new Commentary(   text            : "Create a plan for improvements to be enacted during the next Sprint",
                                                                idPublication   : publication1.id,
                                                                whoPublishedIt  : nahu.userName,
                                                                date            : new Date(2013, 02, 18)
                                                            )

        Commentary commentaryForPub2        = new Commentary(   text            : "Is a software development process that emerged from TDD",
                                                                idPublication   : publication2.id,
                                                                whoPublishedIt  : victor.userName,
                                                                date            : new Date(2013, 03, 22)
                                                            )

        Commentary commentaryForPub3        = new Commentary(   text            : "Is principally an idea about how software development should be managed by both business interests and technical insight",
                                                                idPublication   : publication2.id,
                                                                whoPublishedIt  : victor.userName,
                                                                date            : new Date(2013, 04, 23)
                                                            )

        Commentary otherCommentaryForPub3   = new Commentary(   text            : "Is a software development process",
                                                                idPublication   : publication3.id,
                                                                whoPublishedIt  : nahu.userName,
                                                                date            : new Date(2013, 05, 21)
                                                            )

        Commentary anotherCommentaryForPub3 = new Commentary(   text            : "Is related to the test-first programming concepts of extreme programming",
                                                                idPublication   : publication3.id,
                                                                whoPublishedIt  : ivan.userName,
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
