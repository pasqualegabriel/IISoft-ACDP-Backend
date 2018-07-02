package iisoft.acdp.backend

import iisoft.acdp.backend.authentication.NormalUser
import iisoft.acdp.backend.authentication.Role
import iisoft.acdp.backend.authentication.NormalUserRole

class BootStrap {

    def init = { servletContext ->

        // Salvamos en la base de datos un nuevo rol y un Actor
        def userRole     = new Role(authority:'ROLE_NORMAL_USER').save()

        def pepitaUser   = new NormalUser(username:'pepita',password: 'vuela').save()
        def ivanUser     = new NormalUser(username:'ivan',password: 'password').save()
        def nahuUser     = new NormalUser(username:'nahu',password: 'password').save()
        def gabiUser     = new NormalUser(username:'gabi',password: 'password').save()
        def victorUser   = new NormalUser(username:'victor',password: 'password').save()
        def diegoUser    = new NormalUser(username:'diego',password: 'password').save()
        def pabloUser    = new NormalUser(username:'pablo',password: 'password').save()
        def camiUser     = new NormalUser(username:'cami',password: 'password').save()

        NormalUserRole.create(pepitaUser , userRole)
        NormalUserRole.create(ivanUser   , userRole)
        NormalUserRole.create(nahuUser   , userRole)
        NormalUserRole.create(gabiUser   , userRole)
        NormalUserRole.create(victorUser , userRole)
        NormalUserRole.create(diegoUser  , userRole)
        NormalUserRole.create(pabloUser  , userRole)
        NormalUserRole.create(camiUser   , userRole)

        NormalUserRole.withSession {
            it.flush()
            it.clear()
        }

        def pepitaProfile = new UserProfile(userName:"pepita",name:"pepita", surname: "Swallow", mail: "pepita@gmail.com", birthDate: new Date(2018, 06, 22),userID: pepitaUser.getId() ).save()
        def ivanProfile = new UserProfile(userName:"ivan",name:"Ivan", surname: "D", mail: "ivan@gmail.com", birthDate: new Date(2018, 06, 22), userID: ivanUser.getId()).save()
        def nahuProfile = new UserProfile(userName:"nahu",name:"Nahu", surname: "A", mail: "nahu@gmail.com", birthDate: new Date(2018, 06, 22), userID: nahuUser.getId()).save()
        def gabiProfile = new UserProfile(userName:"gabi",name:"Gabi", surname: "P", mail: "gabi@gmail.com", birthDate: new Date(2018, 06, 22), userID:  gabiUser.getId()).save()
        def victorProfile = new UserProfile(userName:"victor",name:"Victor", surname: "D", mail: "victor@gmail.com", birthDate: new Date(2018, 06, 22), userID: victorUser.getId()).save()
        def diegoProfile = new UserProfile(userName:"diego",name:"Diego", surname: "Diego", mail: "diego@gmail.com", birthDate: new Date(2018, 06, 22), userID: diegoUser.getId()).save()
        def pabloProfile = new UserProfile(userName:"pablo",name:"Pablo", surname: "Suarez", mail: "pablo@gmail.com", birthDate: new Date(2018, 06, 22), userID: pabloUser.getId()).save()
        def camiProfile = new UserProfile(userName:"cami",name:"Cami", surname: "Cintioli", mail: "cami@gmail.com", birthDate: new Date(2018, 06, 22), userID: camiUser.getId()).save()

        def pepitaWorkProfile = new UserWorkProfile(work:"devop",git:"www.git.com/pepita", linkedin:"wwww.linkedin.com/pepita",userID: pepitaUser.getId() ).save()
        def ivanWorkProfile = new UserWorkProfile(work:"devop",git:"www.git.com/pepita", linkedin:"wwww.linkedin.com/pepita", userID: ivanUser.getId()).save()
        def nahuWorkProfile = new UserWorkProfile(work:"devop",git:"www.git.com/pepita", linkedin:"wwww.linkedin.com/pepita", userID: nahuUser.getId()).save()
        def gabiWorkProfile = new UserWorkProfile(work:"devop",git:"www.git.com/pepita", linkedin:"wwww.linkedin.com/pepita", userID:  gabiUser.getId()).save()
        def victorWorkProfile = new UserWorkProfile(work:"devop",git:"www.git.com/pepita", linkedin:"wwww.linkedin.com/pepita", userID: victorUser.getId()).save()
        def diegoWorkProfile = new UserWorkProfile(work:"devop",git:"www.git.com/pepita", linkedin:"wwww.linkedin.com/pepita", userID: diegoUser.getId()).save()
        def pabloWorkProfile = new UserWorkProfile(work:"devop",git:"www.git.com/pepita", linkedin:"wwww.linkedin.com/pepita", userID: pabloUser.getId()).save()
        def camiWorkProfile = new UserWorkProfile(work:"devop",git:"www.git.com/pepita", linkedin:"wwww.linkedin.com/pepita", userID: camiUser.getId()).save()

        def pepitaAcademicProfile = new UserAcademicProfile(career: "tpi", approvedSubjects:["Intro","Orga"], userID: pepitaUser.getId() ).save()
        def ivanAcademicProfile = new UserAcademicProfile(career: "tpi", approvedSubjects:["Intro","Orga"], userID: ivanUser.getId()).save()
        def nahuAcademicProfile = new UserAcademicProfile(career: "tpi", approvedSubjects:["Intro","Orga"], userID: nahuUser.getId()).save()
        def gabiAcademicProfile = new UserAcademicProfile(career: "tpi", approvedSubjects:["Intro","Orga"], userID:  gabiUser.getId()).save()
        def victorAcademicProfile = new UserAcademicProfile(career: "tpi", approvedSubjects:["Intro","Orga"], userID: victorUser.getId()).save()
        def diegoAcademicProfile= new UserAcademicProfile(career: "tpi", approvedSubjects:["Intro","Orga"], userID: diegoUser.getId()).save()
        def pabloAcademicProfile = new UserAcademicProfile(career: "tpi", approvedSubjects:["Intro","Orga"], userID: pabloUser.getId()).save()
        def camiAcademicProfile = new UserAcademicProfile(career: "tpi", approvedSubjects:["Intro","Orga"], userID: camiUser.getId()).save()


        def category1 = new Category(name:"IISoftware" )
        def category2 = new Category(name:"Intro")
        category1.save()
        category2.save()

        def publication1 = new Publication( text           : "The Sprint Retrospective",
                                            idCategory     : category1.id,
                                            name           : "Retrospective",
                                            title          : "RetrospectiveIISoft",
                                            whoPublishedIt : diegoUser.username,
                                            date           : new Date(2018, 06, 22)
                                          )
        publication1.subscribe(ivanUser.username)

        def publication2 = new Publication( text           : "Behavior-Driven Development",
                                            idCategory     : category2.id,
                                            name           : "BDD",
                                            title          : "BDDIISoft",
                                            whoPublishedIt : pabloUser.username,
                                            date           : new Date(2017, 05, 10)
                                          )
        publication2.subscribe(nahuUser.username)
        publication2.subscribe(gabiUser.username)
        publication2.subscribe(victorUser.username)

        def publication3 = new Publication( text           : "Test-driven development",
                                            idCategory     : category2.id,
                                            name           : "TDD",
                                            title          : "TDDIISoft",
                                            whoPublishedIt : ivanUser.username,
                                            date           : new Date(2016, 02, 14)
                                          )

        publication3.subscribe(diegoUser.username)
        publication3.subscribe(pabloUser.username)

        category1.publications = [publication1]
        category2.publications = [publication2, publication3]
        publication1.save()
        publication2.save()
        publication3.save()

        Commentary commentaryForPub1        = new Commentary(   text            : "Is an opportunity for the Scrum Team to inspect itself",
                                                                idPublication   : publication1.id,
                                                                whoPublishedIt  : gabiUser.username,
                                                                date            : new Date(2013, 01, 21)
                                                            )

        Commentary otherCommentaryForPub1   = new Commentary(   text            : "Create a plan for improvements to be enacted during the next Sprint",
                                                                idPublication   : publication1.id,
                                                                whoPublishedIt  : nahuUser.username,
                                                                date            : new Date(2013, 02, 18)
                                                            )

        Commentary commentaryForPub2        = new Commentary(   text            : "Is a software development process that emerged from TDD",
                                                                idPublication   : publication2.id,
                                                                whoPublishedIt  : victorUser.username,
                                                                date            : new Date(2013, 03, 22)
                                                            )

        Commentary commentaryForPub3        = new Commentary(   text            : "Is principally an idea about how software development should be managed by both business interests and technical insight",
                                                                idPublication   : publication2.id,
                                                                whoPublishedIt  : victorUser.username,
                                                                date            : new Date(2013, 04, 23)
                                                            )

        Commentary otherCommentaryForPub3   = new Commentary(   text            : "Is a software development process",
                                                                idPublication   : publication3.id,
                                                                whoPublishedIt  : nahuUser.username,
                                                                date            : new Date(2013, 05, 21)
                                                            )

        Commentary anotherCommentaryForPub3 = new Commentary(   text            : "Is related to the test-first programming concepts of extreme programming",
                                                                idPublication   : publication3.id,
                                                                whoPublishedIt  : ivanUser.username,
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
