package iisoft.acdp.backend

import grails.gorm.transactions.Transactional

@Transactional
class CategoryService {

    def allCategories(){
        Category.findAll()
    }
}
