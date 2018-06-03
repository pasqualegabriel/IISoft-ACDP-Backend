package iisoft.acdp.backend

import grails.converters.JSON
import grails.test.hibernate.HibernateSpec
import grails.testing.web.controllers.ControllerUnitTest
import groovy.json.JsonBuilder

import static org.junit.Assert.*

class PublicationControllerSpec extends HibernateSpec implements ControllerUnitTest<PublicationController> {

    Publication        aPublication
    PublicationService aPublicationService
    def                aJsonBuilder
    def                aPublications

    def setup() {
        aJsonBuilder        = new JsonBuilder()
        aPublication        = new Publication(name: "Retrospective",
                                              title: "RetrospectiveIISoft",
                                              whoPublishedIt: "Diego",
                                              date: new Date(2018, 06, 22))
        aPublications       = [aPublication]
        aPublication.save()
        aPublicationService = new PublicationService()

        controller.publicationService = aPublicationService
    }

    void "when the controller is requested for a publication, it returns aPublication"() {
        given:
            def aJsonBuilder = new JsonBuilder()

            def categories = aPublications.collect {
                def publication = it
                def jsonBuilder = aJsonBuilder
                jsonBuilder {
                    id             1
                    title          publication.title
                    date           publication.date
                    name           publication.name
                    whoPublishedIt publication.whoPublishedIt
                }
            } as JSON

        when:
            controller.allPublications()

        then:
            assertEquals(200, response.status)
            assertEquals(categories.toString(), response.contentAsString)
    }
}