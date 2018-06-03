package iisoft.acdp.backend

import grails.converters.JSON
import grails.test.hibernate.HibernateSpec
import grails.testing.web.controllers.ControllerUnitTest
import groovy.json.JsonBuilder

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

class ComentaryControllerSpecextends extends HibernateSpec implements ControllerUnitTest<ComentaryController> {

    ComentaryService   aComentaryService
    def                aJsonBuilder

    def setup() {
        aJsonBuilder        = new JsonBuilder()

        aComentaryService = new ComentaryService()

        controller.comentaryService = aComentaryService
    }


    void "when the controller is requested for the Comentarys of a Publication it returns all its Comentarys"() {
        given:

        Comentary aNewComentary        = new Comentary(text:"CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS" ,idPublication: 5,
                whoPublishedIt: "Diego",
                date: new Date(2013, 07, 22))

        aNewComentary.save()

        Comentary aNotherComentary     = new Comentary(text:"CHAMULLA ACA IVAN MANDAME EL STRING QUE QUIERAS", idPublication: 5,
                title: "RetrospectiveIISoftdepepin",
                whoPublishedIt: "Diego",
                date: new Date(2015, 06, 22))
        aNotherComentary.save()


        def someComentarys       = [aNewComentary,aNotherComentary]

        def theComentarys = someComentarys.collect {
            def comentary = it
            def jsonBuilder = aJsonBuilder
            jsonBuilder {
                id             comentary.id
                date           comentary.date
                idPublication  comentary.idPublication
                whoPublishedIt comentary.whoPublishedIt
                text           comentary.text
            }
        } as JSON

        params.idPub = 5

        when:
        controller.getComentarysOfPublication()

        then:
        assertEquals(200, response.status)
        assertEquals(theComentarys.toString(), response.contentAsString)
    }

    void "when requested to save a Comentary, it is saved"() {
        given:
        def aNewComentaryJson = aJsonBuilder {

            text            "un texto x"
            idPublication   32
            date            new Date(2015, 06, 22)
            whoPublishedIt "un Nombre x"

        } as JSON

        request.setMethod("POST")
        request.setJSON(aNewComentaryJson)

        when:
        controller.saveComentary()

        then:
        assertEquals(200, response.status)
        assertNotNull(Comentary.findByWhoPublishedIt("un Nombre x"))
    }

}