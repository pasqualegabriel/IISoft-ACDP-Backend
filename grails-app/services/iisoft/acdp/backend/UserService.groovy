package iisoft.acdp.backend

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def getPepita() {
        User.findByName("pepita")
    }
}
