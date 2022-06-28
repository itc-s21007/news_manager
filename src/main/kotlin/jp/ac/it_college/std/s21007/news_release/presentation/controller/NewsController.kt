package jp.ac.it_college.std.s21007.news_release.presentation.controller

import jp.ac.it_college.std.s21007.news_release.application.NewsService
import jp.ac.it_college.std.s21007.news_release.presentation.GetNewsListResponse
import jp.ac.it_college.std.s21007.news_release.presentation.NewsInfo
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("news")
@CrossOrigin
class NewsController(
    private val newsService: NewsService
) {
    @GetMapping("/list")
    fun getList(): GetNewsListResponse {
        val newsList = newsService.getList().map {
            NewsInfo(it)
        }
        return GetNewsListResponse(newsList)
    }
}