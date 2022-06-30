package jp.ac.it_college.std.s21007.news_manager.application

import jp.ac.it_college.std.s21007.news_manager.domain.model.NewsWithCategory
import jp.ac.it_college.std.s21007.news_manager.domain.repository.NewsRepository
import org.springframework.stereotype.Service

@Service
class NewsService(
    private val newsRepository: NewsRepository
    ){
    fun getList(): List<NewsWithCategory> {
        return newsRepository.findAllWithRental()
    }

    fun getDetail(newsId: Long): NewsWithCategory {
        return newsRepository.findWithRental(newsId) ?: throw IllegalArgumentException("存在しない書籍ID : $newsId")
    }
}