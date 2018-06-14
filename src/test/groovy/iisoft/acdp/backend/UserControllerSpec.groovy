package iisoft.acdp.backend

import grails.converters.JSON
import grails.test.hibernate.HibernateSpec
import grails.testing.web.controllers.ControllerUnitTest
import groovy.json.JsonBuilder

class UserControllerSpec extends HibernateSpec implements ControllerUnitTest<UserController> {

    User            pepita
    UserService     aUserService
    def             aJsonBuilder

    def setup() {
        aJsonBuilder= new JsonBuilder()
        pepita = new User(name:"pepita")
        pepita.save()
        aUserService = new UserService()

        controller.userService = aUserService

    }

    void "when the controller is requested for a user, it returns pepita"() {
        given:

        def pepita = aJsonBuilder{
            id  1
            name "pepita" } as JSON

        when:
        controller.userPepita()

        then:
        response.status == 200
        response.contentAsString ==  pepita.toString()
    }
}
