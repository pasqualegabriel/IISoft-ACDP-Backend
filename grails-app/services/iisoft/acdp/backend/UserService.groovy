package iisoft.acdp.backend

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def getPepita() {
        User.findByName("pepita")
    }

    def allUsers() {
        User.findAll()
    }

    def save(User anUser) {
        anUser.save()
    }

    def getUserByUserName(String anUserName) {
        User.findByUserName(anUserName)
    }
}
