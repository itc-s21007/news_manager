package jp.ac.it_college.std.s21007.news_release.database.repository

import jp.ac.it_college.std.s21007.news_release.database.mapper.NewsWithRentalMapper
import jp.ac.it_college.std.s21007.news_release.database.mapper.select
import jp.ac.it_college.std.s21007.news_release.domain.model.Category
import jp.ac.it_college.std.s21007.news_release.domain.model.News
import jp.ac.it_college.std.s21007.news_release.domain.model.NewsWithCategory
import jp.ac.it_college.std.s21007.news_release.domain.repository.NewsRepository
import org.springframework.stereotype.Repository
import jp.ac.it_college.std.s21007.news_release.database.record.NewsWithCategory as NewsWithCategory1

@Suppress
@Repository
class NewsRepositoryImpl(
    private val newsWithRentalMapper: NewsWithRentalMapper
): NewsRepository {
    override fun findAllWithRental(): List<NewsWithCategory> {
        return newsWithRentalMapper.select {}.map { toModel(it) }
    }

    private fun toModel(record: NewsWithCategory1): NewsWithCategory {
        val news = News(
            record.id!!,
            record.title!!,
            record.categoryId!!,
            record.publishAt!!,
            record.createAt!!,
            record.userId!!,
            record.body!!,
        )
        val category = record.userId?.let {
            Category(
                record.id!!,
                record.name!!,
            )
        }
        return NewsWithCategory(news, category)
    }
}