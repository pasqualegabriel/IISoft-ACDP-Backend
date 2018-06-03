package iisoft.acdp.backend

import grails.rest.*
import grails.converters.*

class PublicationController extends RestfulController<Publication> {

    def publicationService

    static responseFormats = ['json']

    PublicationController() {
        super(Publication)
    }

    // get    "/publications"
    def allPublications() {
        respond  publicationService.allPublications()
    }

    //get    "/publication/$idCat"
    def publications(){
        def somePublications = publicationService.getPublicationsOfCategory(params.idCat)
        if (somePublications.size() == 0) {
            render status: 404
        }
        else{
            respond somePublications
        }
    }

    //post    "/publication"
    def savePublication(Publication aPublication){
        publicationService.save(aPublication)
    }


}
