package iisoft.acdp.backend

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")
        "/"(controller: 'application', action:'index')

        get    "/user"                          (controller:"user", action:"userPepita")

        get    "/categories"                    (controller:"category", action:"allCategories")

        get    "/publications"                  (controller:"publication", action:"allPublications")
        get    "/publication/$idCat"            (controller:"publication", action:"publications")
        post   "/publication"                   (controller:"publication", action:"savePublication")

        get    "/comments/$idPub"             (controller:"commentary",   action:"getCommentsOfPublication")
        post   "/commentary"                     (controller:"commentary",   action:"saveCommentary")

        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
