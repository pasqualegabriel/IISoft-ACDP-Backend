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
        aPublication        = new Publication(text:"CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS" ,idCategory: 1,name: "Retrospective",
                                              title: "RetrospectiveIISoft",
                                              whoPublishedIt: "Diego",
                                              date: new Date(2018, 06, 22))
        aPublications       = [aPublication]
        aPublication.save()
        aPublicationService = new PublicationService()

        controller.publicationService = aPublicationService
    }

    void "when the controller is requested for all publications, it returns all Publications"() {
        given:
            def categories = aPublications.collect {
                def publication = it
                def jsonBuilder = aJsonBuilder
                jsonBuilder {
                    id              1
                    title           publication.title
                    date            publication.date
                    idCategory      publication.idCategory
                    subscribers     publication.subscribers
                    whoPublishedIt  publication.whoPublishedIt
                    text            publication.text
                    cantSubscribers publication.cantSubscribers

                }
            } as JSON

        when:
            controller.allPublications()

        then:
            assertEquals(200, response.status)
            assertEquals(categories.toString(), response.contentAsString)
    }

    void "when the controller is requested for the publications of a category it returns all its publications"() {
        given:
            Publication aNewPublication        = new Publication(text:"CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS" ,idCategory: 5,name: "Retrospectivepepe",
                                                  title: "RetrospectiveIISoftdepepe",
                                                  whoPublishedIt: "Diego",
                                                  date: new Date(2013, 07, 22))

            aNewPublication.save()

            Publication aNotherPublication     = new Publication(text:"CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS", idCategory: 5, name: "Retrospectivepepin",
                                                  title: "RetrospectiveIISoftdepepin",
                                                  whoPublishedIt: "Diego",
                                                  date: new Date(2015, 06, 22))
            aNotherPublication.save()


            aPublications       = [aNewPublication,aNotherPublication]

            def thePublications = aPublications.collect {
                def publication = it
                def jsonBuilder = aJsonBuilder
                jsonBuilder {
                    id              publication.id
                    title           publication.title
                    date            publication.date
                    idCategory      publication.idCategory
                    subscribers     publication.subscribers
                    whoPublishedIt  publication.whoPublishedIt
                    text            publication.text
                    cantSubscribers publication.cantSubscribers
                }
            } as JSON

            params.idCat = 5

        when:
            controller.publications()

        then:
            assertEquals(200, response.status)
            assertEquals(thePublications.toString(), response.contentAsString)
    }

    void "when the controller is requested for the publications of a category and the category has no publications, it returns 404"() {
        given:
            params.idCat = 5

        when:
            controller.publications()

        then:
            assertEquals(404, response.status)
    }

    void "when requested to save a publication, it is saved"() {
        given:
            def aNewPublicationJson = aJsonBuilder {
                title           "un titulo x"
                text            "un texto x"
                idCategory      32
                date            new Date(2015, 06, 22)
                whoPublishedIt "un Nombre x"

            } as JSON

            request.setMethod("POST")
            request.setJSON(aNewPublicationJson)

        when:
            controller.savePublication()

        then:
            assertEquals(200, response.status)
            assertNotNull(Publication.findByTitle("un titulo x"))
    }

    def 'given an userName and a Json request, updatePublication changes the state of aPublication in the Data Base'() {
        given:
        UserProfile anUser = new UserProfile(name:"pepita", surname: "Swallow", userName: "pepita",
                password: "pepitaPassword", mail: "pepita@gmail.com", birthDate: new Date(2018, 06, 22))

        anUser.save()
        params.userName = "pepita"

        def aPublicationModified =  aJsonBuilder {
            id              aPublication.id
            title           aPublication.title
            date            aPublication.date
            idCategory      aPublication.idCategory
            subscribers     aPublication.subscribers
            whoPublishedIt  aPublication.whoPublishedIt
            text            aPublication.text
            cantSubscribers aPublication.cantSubscribers
        } as JSON

        request.setJSON(aPublicationModified)
        request.setMethod("PUT")

        when:
        controller.updatePublication(aPublication)

        then:
        response.status == 200
        Publication.findById(aPublication.id).cantSubscribers == 1
        Publication.findById(aPublication.id).subscribers     == ["pepita"]
    }

    def 'Dado un id invalido en los parametros, la accion update devuelve error'() {
        given:
        params.userName = "none"

        def aPublicationModified =  aJsonBuilder {
            id              aPublication.id
            title           aPublication.title
            date            aPublication.date
            idCategory      aPublication.idCategory
            subscribers     aPublication.subscribers
            whoPublishedIt  aPublication.whoPublishedIt
            text            aPublication.text
            cantSubscribers aPublication.cantSubscribers
        } as JSON

        request.setJSON(aPublicationModified)
        request.setMethod("PUT")

        when:
        controller.updatePublication(aPublication)

        then:
        response.status == 404

    }
}