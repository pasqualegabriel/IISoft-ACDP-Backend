package iisoft.acdp.backend

import grails.gorm.transactions.Transactional

@Transactional
class CommentaryService {

    def getCommentsOfPublication(long idPublication) {
        Commentary.findAllByIdPublication(idPublication)
    }

    def save(Commentary aCommentary){
        aCommentary.save()
    }
}
