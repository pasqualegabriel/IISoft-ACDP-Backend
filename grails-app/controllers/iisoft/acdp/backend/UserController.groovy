package iisoft.acdp.backend

import grails.gorm.transactions.Transactional
import iisoft.acdp.backend.authentication.NormalUser
import grails.rest.*

class UserController extends RestfulController<UserProfile> {

    def userService
    def springSecurityService

	static responseFormats = ['json']

    UserController() {
        super(UserProfile)
    }

    // get    "/users"
    def allUsers() {
        respond userService.allUsers()
    }

    //get    "/user/$userName"
    def getUserByUserName(){
        UserProfile user = userService.getUserByUserName(params.userName as String)
        if (user == null) {
            render status: 404
        }
        else {
            respond user
        }
    }

        //post    "/user"
    def saveUser(UserProfile anUserProfile){
        if(leCorrespondeElProfile(anUserProfile)){
            userService.saveProfile(anUserProfile)
        }
        else{
            render status: 403
        }
    }



    Boolean leCorrespondeElProfile(Profile anUser) {
        NormalUser currentUser = springSecurityService.currentUser
        anUser.userID == currentUser.id
    }

    //post    "/newUser"
    @Transactional
    def newUser(UserRegisterForm anUserUserForm){
        NormalUser hidratatedUser = anUserUserForm.hidrateUser()
        userService.newUser(hidratatedUser)

        long userId = hidratatedUser.id

        UserProfile hidratedProfile   = anUserUserForm.hidrateprofile(userId)
        userService.saveProfile(hidratedProfile)
    }

    //get   "/user/mail/$mail"
    def mail(){
        UserProfile user = userService.getUserByMail(params.mail as String)
        if (user == null) {
            render status: 404
        }
        else {
            respond user
        }
    }

}
