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

        get    "/users"                            (controller:"user", action:"allUsers")
        get    "/user/$userName"                   (controller:"user", action:"getUserByUserName")
        get    "/userWorkProfile/$userName"        (controller:"user", action:"getUserWorkProfileByUserName")
        get    "/userAcademicProfile/$userName"    (controller:"user", action:"getUserAcademicProfileByUserName")

        post   "/user"                             (controller:"user", action:"saveUser")
        post   "/userWorkProfile"                  (controller:"user", action:"saveUserWorkProfile")
        post   "/userAcademicProfile"              (controller:"user", action:"saveUserAcademicProfile")

        post   "/newUser"                          (controller:"user", action:"newUser")
        get   "/user/mail/$mail"                   (controller:"user", action:"mail")

        get    "/categories"                       (controller:"category", action:"allCategories")

        get    "/publications"                     (controller:"publication", action:"allPublications")
        get    "/publication/$idCat"               (controller:"publication", action:"publications")
        post   "/publication"                      (controller:"publication", action:"savePublication")
        put   "/publication/subscriber/$userName"  (controller:"publication", action:"updatePublication")
        get   "/publication/title/$title"          (controller:"publication", action:"searchByTitle")

        get    "/comments/$idPub"                  (controller:"commentary",   action:"getCommentsOfPublication")
        post   "/commentary"                       (controller:"commentary",   action:"saveCommentary")

        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
