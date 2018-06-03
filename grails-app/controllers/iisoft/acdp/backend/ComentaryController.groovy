package iisoft.acdp.backend


import grails.rest.*
import grails.converters.*

class ComentaryController extends RestfulController<Comentary> {

    def comentaryService

    static responseFormats = ['json']

    ComentaryController() {
        super(Comentary)
    }

    //get    "/comentarys/$idPub"
    def getComentarysOfPublication(){
        def someComentarys = comentaryService.getComentaryssOfPublication(params.idPub)
        respond someComentarys
    }

    //post    "/comentary"
    def saveComentary(Comentary aComentary){
        comentaryService.save(aComentary)
    }

}
