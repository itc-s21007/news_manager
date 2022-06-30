/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.ac.it_college.std.s21007.news_manager.database.mapper

import java.sql.JDBCType
import jp.ac.it_college.std.s21007.news_manager.domain.enum.RoleType
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object UserDynamicSqlSupport {
    val user = User()

    val id = user.id

    val username = user.username

    val password = user.password

    val viewName = user.viewName

    val roleType = user.roleType

    class User : AliasableSqlTable<User>("user", ::User) {
        val id = column<Long>(name = "id", jdbcType = JDBCType.BIGINT)

        val username = column<String>(name = "username", jdbcType = JDBCType.VARCHAR)

        val password = column<String>(name = "password", jdbcType = JDBCType.VARCHAR)

        val viewName = column<String>(name = "view_name", jdbcType = JDBCType.VARCHAR)

        val roleType = column<RoleType>(name = "role_type", jdbcType = JDBCType.VARCHAR, typeHandler = "org.apache.ibatis.type.EnumTypeHandler")
    }
}