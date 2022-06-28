package jp.ac.it_college.std.s21007.news_release.presentation

import jp.ac.it_college.std.s21007.news_release.domain.model.NewsWithCategory
import java.time.LocalDateTime

data class GetNewsListResponse(val newsList: List<NewsInfo>)

data class NewsInfo(
    val id: Long,
    val title: String,
    val category: Long,
    val publishAt: LocalDateTime,
    val createAt: LocalDateTime,
    val userId: Long,
    val body: String,
    val isCategory: Boolean
) {
    constructor(model: NewsWithCategory) : this(
        model.news.id, model.news.title, model.news.categoryId, model.news.publishAt,
        model.news.createAt, model.news.userId, model.news.body, model.isCategory
    )

}