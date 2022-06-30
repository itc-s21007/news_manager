package jp.ac.it_college.std.s21007.news_manager.presentation.controller

import jp.ac.it_college.std.s21007.news_manager.application.AdminNewsService
import jp.ac.it_college.std.s21007.news_manager.application.NewsManagerUserDetails
import jp.ac.it_college.std.s21007.news_manager.domain.model.News
import jp.ac.it_college.std.s21007.news_manager.presentation.form.NewsInfo
import jp.ac.it_college.std.s21007.news_manager.presentation.form.RegisterNewsRequest
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("admin/news")
@CrossOrigin(origins = ["http://localhost:8081/"], allowCredentials = "true")
class AdminNewsController(
    private val adminNewsService: AdminNewsService
) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterNewsRequest, authentication: Authentication) {
        val data = authentication.principal as NewsManagerUserDetails
        adminNewsService.register(
            News(0, request.title, request.categoryId, request.publishAt, LocalDateTime.now(), data.id, request.body)
        )
    }
}
