package iisoft.acdp.backend


import grails.rest.*
import grails.converters.*

class UserController  extends RestfulController<User> {

    def userService

	static responseFormats = ['json']

    UserController() {
        super(User)
    }


    //     get    "/user"         (controller:"user", action:"userPepita")
    def userPepita(){
        respond  userService.getPepita()
    }

}
