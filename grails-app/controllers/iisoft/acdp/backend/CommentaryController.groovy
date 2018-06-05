package iisoft.acdp.backend


import grails.rest.*

class CommentaryController extends RestfulController<Commentary> {

    def commentaryService

    static responseFormats = ['json']

    CommentaryController() {
        super(Commentary)
    }

    //get    "/comments/$idPub"
    def getCommentsOfPublication(){
        def someComments = commentaryService.getCommentsOfPublication(params.idPub as long)
        respond someComments
    }

    //post    "/commentary"
    def saveCommentary(Commentary aCommentary){
        commentaryService.save(aCommentary)
    }

}
