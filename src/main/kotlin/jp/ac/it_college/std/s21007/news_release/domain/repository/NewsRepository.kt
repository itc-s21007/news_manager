package jp.ac.it_college.std.s21007.news_release.domain.repository

import jp.ac.it_college.std.s21007.news_release.domain.model.NewsWithCategory

interface NewsRepository {
    fun findAllWithRental(): List<NewsWithCategory>
}

