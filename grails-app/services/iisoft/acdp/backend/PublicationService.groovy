package iisoft.acdp.backend

import grails.gorm.transactions.Transactional

@Transactional
class PublicationService {

    def serviceMethod() {

    }

    def allPublications() {
        Publication.findAll()
    }
}
