package iisoft.acdp.backend

import grails.gorm.transactions.Transactional

@Transactional
class PublicationService {

    def allPublications() {
        Publication.executeQuery("from Publication order by cantSubscribers desc")
    }

    def getPublicationsOfCategory(long idOfCategory) {
        Publication.executeQuery("from Publication where idCategory = ? order by cantSubscribers desc",
        [idOfCategory])
    }

    def save(Publication aPublication) {
        aPublication.save()
    }

    def subscribe(Publication aPublication, String anUserName) {
        if(aPublication.isSubscribed(anUserName)){
            aPublication.unsubscribe(anUserName)
        }
        else {
            aPublication.subscribe(anUserName)
        }

    }

    def searchByTitle(String search){
        Publication.executeQuery("from Publication where title like '%" + search + "%' order by cantSubscribers desc")
    }
}
