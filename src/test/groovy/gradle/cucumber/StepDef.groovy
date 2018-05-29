package gradle.cucumber

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks

import static org.junit.Assert.assertTrue

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

boolean aBool

Given(~/^aBool in false$/) { ->
    aBool = false
}

When(~/^aBool in true$/) { ->
    aBool = true
}

Then(~/^true returns$/) { ->
    assertTrue(aBool)
}