package iisoft.acdp.backend

class BootStrap {

    def init = { servletContext ->
        def pepita    = new User(name:"pepita")
        pepita.save()

        def publication1 = new Publication(name: "Retrospective",
                                           title: "RetrospectiveIISoft",
                                           whoPublishedIt: "Diego",
                                           date: new Date(2018, 06, 22))
        def publication2 = new Publication(name: "BDD",
                                           title: "BDDIISoft",
                                           whoPublishedIt: "Pablo",
                                           date: new Date(2017, 05, 10))
        def publication3 = new Publication(name: "TDD",
                                           title: "TDDIISoft",
                                           whoPublishedIt: "Diego",
                                           date: new Date(2016, 02, 14))

        def category1 = new Category(name:"IISoftware", publications: [publication1])
        def category2 = new Category(name:"Intro", publications: [publication2, publication3])
        category1.save()
        category2.save()
    }

    def destroy = {
    }
}
