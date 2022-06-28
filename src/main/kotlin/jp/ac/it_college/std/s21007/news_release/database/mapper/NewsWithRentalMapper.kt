package jp.ac.it_college.std.s21007.news_release.database.mapper

import jp.ac.it_college.std.s21007.news_release.database.mapper.CategoryDynamicSqlSupport.category
import jp.ac.it_college.std.s21007.news_release.database.mapper.CategoryDynamicSqlSupport.name
import jp.ac.it_college.std.s21007.news_release.database.mapper.NewsDynamicSqlSupport.id
import jp.ac.it_college.std.s21007.news_release.database.mapper.NewsDynamicSqlSupport.title
import jp.ac.it_college.std.s21007.news_release.database.mapper.NewsDynamicSqlSupport.body
import jp.ac.it_college.std.s21007.news_release.database.mapper.NewsDynamicSqlSupport.categoryId
import jp.ac.it_college.std.s21007.news_release.database.mapper.NewsDynamicSqlSupport.createAt
import jp.ac.it_college.std.s21007.news_release.database.mapper.NewsDynamicSqlSupport.news
import jp.ac.it_college.std.s21007.news_release.database.mapper.NewsDynamicSqlSupport.publishAt
import jp.ac.it_college.std.s21007.news_release.database.mapper.NewsDynamicSqlSupport.userId
import jp.ac.it_college.std.s21007.news_release.database.record.NewsWithCategory
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.SqlBuilder.*
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.select



@Mapper
interface NewsWithRentalMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "NewsWithRentalRecordResult", value = [
            Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            Result(column = "publishAt", property = "publishAt", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "categoryId", property = "categoryId", jdbcType = JdbcType.BIGINT),
            Result(column = "createAt", property = "createAt", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "userId", property = "userId", jdbcType = JdbcType.BIGINT),
            Result(column = "body", property = "body", jdbcType = JdbcType.VARCHAR)
        ]
    )
    fun selectMany(selectStatement: SelectStatementProvider): List<NewsWithCategory>
}

private val columnList = listOf(id,name, title,publishAt,categoryId,createAt,userId,body)

fun NewsWithRentalMapper.select(completer: SelectCompleter): List<NewsWithCategory> =
    select(columnList) {
        from(news, "b")
        leftJoin(category) {
            on(news.id) equalTo category.id
        }
        completer()
    }.run(this::selectMany)






