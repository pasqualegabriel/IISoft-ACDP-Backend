package iisoft.acdp.backend

class BootStrap {

    def init = { servletContext ->
        def pepita   = new User(name:"pepita")
        pepita.save()
    }
    def destroy = {
    }
}
