package iisoft.acdp.backend

import grails.rest.*
import grails.converters.*

class CategoryController extends RestfulController<Category> {

    def categoryService

	static responseFormats = ['json', 'xml']

    CategoryController() {
        super(Category)
    }

    //     get    "/categories"
    def allCategories(){
        respond  categoryService.allCategories()
    }
}
