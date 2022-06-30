package jp.ac.it_college.std.s21007.news_manager.application

import jp.ac.it_college.std.s21007.news_manager.domain.model.News
import jp.ac.it_college.std.s21007.news_manager.domain.repository.NewsRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class AdminNewsService(
    private val newsRepository: NewsRepository
) {
    @Transactional
    fun register(news: News) {
        newsRepository.findWithRental(news.id)?.let {
            throw IllegalArgumentException("既に存在する書籍ID : ${news.id}") }
        newsRepository.register(news)
    }
//    @Transactional
//    fun update(newsId: Long, title: String?, category: Long, publishAt: LocalDateTime?, createAt: LocalDateTime?, userId: Long, body: String?) {
//        newsRepository.findWithRental(newsId) ?: throw IllegalArgumentException("存在しない書籍ID : $newsId")
//        newsRepository.update(newsId, title, category, publishAt, createAt, userId, body)
//    }
//    @Transactional
//    fun delete(newsId: Long) {
//        newsRepository.findWithRental(newsId) ?: throw IllegalArgumentException("存在しない書籍ID: $newsId")
//        newsRepository.delete(newsId)
//    }
}