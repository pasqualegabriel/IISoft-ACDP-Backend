package iisoft.acdp.backend

import grails.converters.JSON
import grails.test.hibernate.HibernateSpec
import grails.testing.web.controllers.ControllerUnitTest
import groovy.json.JsonBuilder
import static groovy.util.GroovyTestCase.*

class UserControllerSpec extends HibernateSpec implements ControllerUnitTest<UserController> {

    User            pepita
    UserService     anUserService
    def             aJsonBuilder
    def             users

    def setup() {
        aJsonBuilder = new JsonBuilder()
        pepita = new User(name:"pepita", surname: "Swallow", userName: "PepitaUser",
                          password: "pepitaPassword", mail: "pepita@gmail.com", birthDate: new Date(2018, 06, 22))
        users = [pepita]
        pepita.save()
        anUserService = new UserService()

        controller.userService = anUserService
    }

    void "when the controller is requested for a user, it returns pepita"() {
        given:
            def pepitaJson = aJsonBuilder {
                id        pepita.id
                name      pepita.name
                password  pepita.password
                userName  pepita.userName
                mail      pepita.mail
                birthDate pepita.birthDate
                surname   pepita.surname
            } as JSON

        when:
            controller.userPepita()

        then:
            assertEquals(200, response.status)
            assertEquals(pepitaJson.toString(), response.contentAsString)
    }


    void "when the controller is requested for all users, it returns all users"() {
        given:
            def someUsers = users.collect {
                def pepita = it
                def jsonBuilder = aJsonBuilder
                jsonBuilder {
                    id        pepita.id
                    name      pepita.name
                    password  pepita.password
                    userName  pepita.userName
                    mail      pepita.mail
                    birthDate pepita.birthDate
                    surname   pepita.surname
                }
            } as JSON

        when:
            controller.allUsers()

        then:
            assertEquals(200, response.status)
            assertEquals(someUsers.toString(), response.contentAsString)
    }

    void "when the controller is requested for the users of an userName it returns all its users"() {
        given:
            def pepita2 = new User(name:"Pepita2", surname: "Swallow2", userName: "PepitaUser2",
                    password: "pepitaPassword2", mail: "pepita2@gmail.com", birthDate: new Date(2018, 06, 22))
            pepita2.save()

            def pepitaJson = aJsonBuilder {
                id        pepita.id
                name      pepita.name
                password  pepita.password
                userName  pepita.userName
                mail      pepita.mail
                birthDate pepita.birthDate
                surname   pepita.surname
            } as JSON

            params.userName = "PepitaUser"

        when:
            controller.getUserByUserName()

        then:
            assertEquals(200, response.status)
            assertEquals(pepitaJson.toString(), response.contentAsString)
    }

    void "when the controller is requested for the users of an userName and it has no users, it returns 404"() {
        given:
            params.userName = "none"

        when:
            controller.getUserByUserName()

        then:
            assertEquals(404, response.status)
    }

    void "when requested to save an user, it is saved"() {
        given:
            def aNewUserJson = aJsonBuilder {
                name      "goku"
                password  "pass"
                userName  "gokuUser"
                mail      "goku@gmail.com"
                birthDate new Date(2018, 06, 22)
                surname   "kakaroto"
            } as JSON

            request.setMethod("POST")
            request.setJSON(aNewUserJson)

        when:
            controller.saveUser()

        then:
            assertEquals(200, response.status)
            assertNotNull(User.findByUserName(pepita.userName))
    }
}
