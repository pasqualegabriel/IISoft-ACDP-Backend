package iisoft.acdp.backend

import grails.rest.*
import grails.converters.*

class UserController extends RestfulController<User> {

    def userService

	static responseFormats = ['json']

    UserController() {
        super(User)
    }

    def index(){
        respond ( [usersToRender: userService.allUsers()], view:'index' )
    }

    def show(User user) {
        if (user == null) {
            render status: 404
        }
        else {
            respond ([anUser: user], view:'show')
        }
    }

    //     get    "/user"         (controller:"user", action:"userPepita")
    def userPepita(){
        respond  userService.getPepita()
    }

    // get    "/users"
    def allUsers() {
        respond  userService.allUsers()
    }

    //get    "/user/$userName"
    def getUserByUserName(){
        def user = userService.getUserByUserName(params.userName as String)
        if (user == null) {
            render status: 404
        }
        else {
            respond user
        }
    }

    //post    "/user"
    def saveUser(User anUser){
        userService.save(anUser)
    }

}
