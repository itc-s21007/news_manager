package jp.ac.it_college.std.s21007.news_manager.database.repository

import jp.ac.it_college.std.s21007.news_manager.database.mapper.*
import jp.ac.it_college.std.s21007.news_manager.domain.model.News
import jp.ac.it_college.std.s21007.news_manager.domain.model.NewsWithCategory
import jp.ac.it_college.std.s21007.news_manager.domain.repository.NewsRepository
import org.springframework.stereotype.Repository
import jp.ac.it_college.std.s21007.news_manager.database.record.News as RecordNews
import jp.ac.it_college.std.s21007.news_manager.database.record.NewsWithCategory as NewsWithCategoryRecord



@Repository
class NewsRepositoryImpl(
    private val newsWithRentalMapper: NewsWithRentalMapper,
    private val newsMapper: NewsMapper
): NewsRepository {
    override fun findAllWithRental(): List<NewsWithCategory> {
        return newsWithRentalMapper.select { }.map { toModel(it) }
    }

    override fun findWithRental(id: Long): NewsWithCategory? {
        return newsWithRentalMapper.selectByPrimaryKey(id) {
        }?.let { toModel(it) }
    }

    override fun register(news: News) {
        newsMapper.insert(toCategory(news))
    }


    private fun toModel(record: NewsWithCategoryRecord): NewsWithCategory {
        return NewsWithCategory(
            record.id!!,
            record.title!!,
            record.categoryId!!,
            record.publishAt!!,
            record.createAt!!,
            record.userId!!,
            record.body!!,)
    }
    private fun toCategory(model: News): RecordNews {
        return RecordNews(model.id, model.title, model.categoryId, model.publishAt, model.createAt, model.userId, model.body)
    }
}