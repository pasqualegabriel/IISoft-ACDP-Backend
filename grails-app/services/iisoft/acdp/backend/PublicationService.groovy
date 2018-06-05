package iisoft.acdp.backend

import grails.gorm.transactions.Transactional

@Transactional
class PublicationService {

    def allPublications() {
        //Publication.findAll()
        Publication.executeQuery("from Publication")
    }

    def getPublicationsOfCategory(long idOfCategory) {
        Publication.findAllByIdCategory(idOfCategory)
    }

    def save(Publication aPublication) {
        aPublication.save()
    }
}
