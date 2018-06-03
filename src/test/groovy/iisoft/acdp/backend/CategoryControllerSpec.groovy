package iisoft.acdp.backend

import grails.converters.JSON
import grails.test.hibernate.HibernateSpec
import grails.testing.web.controllers.ControllerUnitTest
import groovy.json.JsonBuilder

import static org.junit.Assert.*

class CategoryControllerSpec extends HibernateSpec implements ControllerUnitTest<CategoryController> {

    Category        aCategory
    CategoryService aCategoryService
    def             aJsonBuilder
    def             aCategories

    def setup() {
        aJsonBuilder     = new JsonBuilder()
        aCategory        = new Category(name:"IISoftware", publications: [])
        aCategories      = [aCategory]
        aCategory.save()
        aCategoryService = new CategoryService()

        controller.categoryService = aCategoryService
    }

    void "when the controller is requested for a category, it returns aCategory"() {
        given:
            def aJsonBuilder = new JsonBuilder()

            def categories = aCategories.collect {
                def x = it
                def jsonBuilder = aJsonBuilder
                jsonBuilder {
                    id           1
                    name         x.name
                    publications x.publications
                }
            } as JSON

        when:
            controller.allCategories()

        then:
            assertEquals(200, response.status)
            assertEquals(categories.toString(), response.contentAsString)
    }
}