package gradle.cucumber

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import iisoft.acdp.backend.User

import static org.junit.Assert.*

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

def aUser

Given(~/^An User$/) { ->
    aUser = new User()
}

When(~/^Pepita name$/) { ->
    aUser.setName("Pepita")
}

Then(~/^User name is Pepita$/) { ->
    assertEquals("Pepita", aUser.name)
}

