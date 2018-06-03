package iisoft.acdp.backend

import grails.rest.*
import grails.converters.*

class PublicationController extends RestfulController<Publication> {

    def publicationService

    static responseFormats = ['json', 'xml']

    PublicationController() {
        super(Publication)
    }

    def index() { }

    def allPublications() {
        respond  publicationService.allPublications()
    }
}
