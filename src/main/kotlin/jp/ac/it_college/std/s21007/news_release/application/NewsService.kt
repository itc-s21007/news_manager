package jp.ac.it_college.std.s21007.news_release.application

import jp.ac.it_college.std.s21007.news_release.domain.model.NewsWithCategory
import jp.ac.it_college.std.s21007.news_release.domain.repository.NewsRepository
import org.springframework.stereotype.Service

@Service
class NewsService(
    private val newsRepository: NewsRepository
){
    fun getList(): List<NewsWithCategory> {
        return newsRepository.findAllWithRental()
    }
}