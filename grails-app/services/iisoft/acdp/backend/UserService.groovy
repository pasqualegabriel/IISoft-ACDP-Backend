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
}
