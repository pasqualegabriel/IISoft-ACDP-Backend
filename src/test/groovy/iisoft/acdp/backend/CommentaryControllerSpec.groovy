package iisoft.acdp.backend

import grails.converters.JSON
import grails.test.hibernate.HibernateSpec
import grails.testing.web.controllers.ControllerUnitTest
import groovy.json.JsonBuilder
import static org.junit.Assert.*

class CommentaryControllerSpec extends HibernateSpec implements ControllerUnitTest<CommentaryController> {

    CommentaryService  aCommentaryService
    def                aJsonBuilder

    def setup() {
        aJsonBuilder      = new JsonBuilder()

        aCommentaryService = new CommentaryService()

        controller.commentaryService = aCommentaryService
    }


    void "when the controller is requested for the Comments of a Publication it returns all its Comments"() {
        given:

        Commentary aNewComments        = new Commentary(text:"CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS" ,idPublication: 5,
                whoPublishedIt: "Diego",
                date: new Date(2013, 07, 22))

        aNewComments.save()

        Commentary anotherComments     = new Commentary(text:"CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS", idPublication: 5,
                title: "RetrospectiveIISoftdepepin",
                whoPublishedIt: "Diego",
                date: new Date(2015, 06, 22))
        anotherComments.save()


        def someComments       = [aNewComments,anotherComments]

        def theComments = someComments.collect {
            def commentary = it
            def jsonBuilder = aJsonBuilder
            jsonBuilder {
                id             commentary.id
                date           commentary.date
                idPublication  commentary.idPublication
                whoPublishedIt commentary.whoPublishedIt
                text           commentary.text
            }
        } as JSON

        params.idPub = 5

        when:
        controller.getCommentsOfPublication()

        then:
        assertEquals(200, response.status)
        assertEquals(theComments.toString(), response.contentAsString)
    }

    void "when requested to save a Commentary, it is saved"() {
        given:
        def aNewCommentaryJson = aJsonBuilder {

            text            "un texto x"
            idPublication   32
            date            new Date(2015, 06, 22)
            whoPublishedIt "un Nombre x"

        } as JSON

        request.setMethod("POST")
        request.setJSON(aNewCommentaryJson)

        when:
        controller.saveCommentary()

        then:
        assertEquals(200, response.status)
        assertNotNull(Commentary.findByWhoPublishedIt("un Nombre x"))
    }

}