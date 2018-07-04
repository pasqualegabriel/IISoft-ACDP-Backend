package iisoft.acdp.backend

import iisoft.acdp.backend.authentication.NormalUser
import grails.gorm.transactions.Transactional
import iisoft.acdp.backend.authentication.NormalUserRole
import iisoft.acdp.backend.authentication.Role

@Transactional
class UserService {

    def allUsers() {
        UserProfile.findAll()
    }

    def newUser(NormalUser anUser) {
        anUser.save()
        Role role = Role.findByAuthority('ROLE_NORMAL_USER')
        NormalUserRole.create(anUser, role,true)
        return anUser
    }

    def getUserByUserName(String anUserName) {
        UserProfile.findByUserName(anUserName)
    }

    UserProfile getProfileforId(long userId) {
        UserProfile.findByUserID(userId)
    }

    def saveProfile(UserProfile userProfile) {
        userProfile.save()
    }

    def getUserByMail(String aMail) {
        UserProfile.findByMail(aMail)
    }

    UserWorkProfile getUserWorkProfileByUserName(String anUserName) {
        //nota: esto es recontra make it work. Hay que hacer una query con join para hacerlo bien.
        def userID = UserProfile.findByUserName(anUserName).userID
        UserWorkProfile.findByUserID(userID)
    }

    UserAcademicProfile getUserAcademicProfileByUserName(String anUserName) {
        //nota: esto es recontra make it work. Hay que hacer una query con join para hacerlo bien.
        def userID = UserProfile.findByUserName(anUserName).userID
        UserAcademicProfile.findByUserID(userID)
    }

    def saveWorkProfile(UserWorkProfile userWorkProfile) {
        def userwP= UserWorkProfile.findByUserID(userWorkProfile.userID)
        if (userwP != null){
            userWorkProfile.id = userwP.id
        }
        userWorkProfile.save()
    }

    def saveAcademicProfile(UserAcademicProfile userAcademicProfile) {
        def userwP= UserAcademicProfile.findByUserID(userAcademicProfile.userID)
        if (userwP != null){
            userAcademicProfile.id = userwP.id
        }

        userAcademicProfile.save()
    }
}
