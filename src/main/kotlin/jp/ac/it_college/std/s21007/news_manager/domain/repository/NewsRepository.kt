package jp.ac.it_college.std.s21007.news_manager.domain.repository

import jp.ac.it_college.std.s21007.news_manager.domain.model.News
import jp.ac.it_college.std.s21007.news_manager.domain.model.NewsWithCategory
import java.time.LocalDateTime


interface NewsRepository {
    fun findAllWithRental(): List<NewsWithCategory>

    fun findWithRental(id: Long): NewsWithCategory?

    fun register(news: News)


}

