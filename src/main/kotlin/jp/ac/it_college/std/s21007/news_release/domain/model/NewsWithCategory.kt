package jp.ac.it_college.std.s21007.news_release.domain.model

data class NewsWithCategory(
    val news: News,
    val category: Category?
){
    val isCategory: Boolean
    get() = category != null
}