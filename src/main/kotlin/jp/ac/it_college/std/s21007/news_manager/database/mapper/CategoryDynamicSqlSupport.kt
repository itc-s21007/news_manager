/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.ac.it_college.std.s21007.news_manager.database.mapper

import java.sql.JDBCType
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object CategoryDynamicSqlSupport {
    val category = jp.ac.it_college.std.s21007.news_manager.database.mapper.CategoryDynamicSqlSupport.Category()

    val id = jp.ac.it_college.std.s21007.news_manager.database.mapper.CategoryDynamicSqlSupport.category.id

    val name = jp.ac.it_college.std.s21007.news_manager.database.mapper.CategoryDynamicSqlSupport.category.name

    class Category : AliasableSqlTable<jp.ac.it_college.std.s21007.news_manager.database.mapper.CategoryDynamicSqlSupport.Category>("category",
        jp.ac.it_college.std.s21007.news_manager.database.mapper.CategoryDynamicSqlSupport::Category
    ) {
        val id = column<Long>(name = "id", jdbcType = JDBCType.BIGINT)

        val name = column<String>(name = "name", jdbcType = JDBCType.VARCHAR)
    }
}