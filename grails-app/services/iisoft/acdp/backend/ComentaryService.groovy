package iisoft.acdp.backend

import grails.gorm.transactions.Transactional

@Transactional
class ComentaryService {

    def getComentaryssOfPublication(long idPublication) {
        Comentary.findAllByIdPublication(idPublication)
    }

    def save (Comentary aComentary){
        aComentary.save()
    }
}
