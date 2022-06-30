package jp.ac.it_college.std.s21007.news_manager.presentation.controller

import jp.ac.it_college.std.s21007.news_manager.application.AdminCategoryService
import jp.ac.it_college.std.s21007.news_manager.domain.model.Category
import jp.ac.it_college.std.s21007.news_manager.presentation.form.RegisterCategoryRequest
import jp.ac.it_college.std.s21007.news_manager.presentation.form.UpdateCategoryRequest
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("admin/category")
@CrossOrigin(origins = ["http://localhost8081/"], allowCredentials = "true")
class CategoryController(
    private val adminCategoryService: AdminCategoryService
) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterCategoryRequest) {
        adminCategoryService.register(
            Category(0, request.name)
        )
    }

    @PutMapping("/update")
    fun update(@RequestBody request: UpdateCategoryRequest) {
        adminCategoryService.update(
            Category(request.id, request.name)
        )
    }

    @DeleteMapping("/delete/{category_id}")
    fun delete(@PathVariable("category_id") categoryId: Long) {
        adminCategoryService.delete(categoryId)
    }
}