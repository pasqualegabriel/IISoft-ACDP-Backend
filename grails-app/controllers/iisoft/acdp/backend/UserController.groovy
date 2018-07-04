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

    //get   "/userWorkProfile/$userName"
    def getUserWorkProfileByUserName(){
        UserWorkProfile user = userService.getUserWorkProfileByUserName(params.userName as String)
        if (user == null) {
            render status: 404
        }
        else {
            respond user
        }
    }

    //get    "/userAcademicProfile/$userName"
    def getUserAcademicProfileByUserName(){
        UserAcademicProfile user = userService.getUserAcademicProfileByUserName(params.userName as String)
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

    //post    "/user"
    def saveUserWorkProfile(UserWorkProfile anUserWorkProfile){
        if(leCorrespondeElProfile(anUserWorkProfile)){
            userService.saveWorkProfile(anUserWorkProfile)
        }
        else{
            render status: 403
        }
    }

    //post    "/user"
    def saveUserAcademicProfile(UserAcademicProfile anUserAcademicProfile){
        if(leCorrespondeElProfile(anUserAcademicProfile)){
            userService.saveAcademicProfile(anUserAcademicProfile)
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

        UserWorkProfile userworkprofile = new UserWorkProfile(work: "", git:"", linkedin: "", userID: userId)
        UserAcademicProfile useracademicprofile = new UserAcademicProfile(career: "", approvedSubjects:[""], userID: userId)

        userService.saveWorkProfile(userworkprofile)
        userService.saveAcademicProfile(useracademicprofile)

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
