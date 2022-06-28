package jp.ac.it_college.std.s21007.news_release.database.record

import java.time.LocalDate
import java.time.LocalDateTime

data class NewsWithCategory(
    var id: Long? = null,
    var name: String? = null,
    var title: String? = null,
    var categoryId: Long? = null,
    var publishAt: LocalDateTime? = null,
    var createAt: LocalDateTime? = null,
    var userId: Long? = null,
    var body: String? = null
    )