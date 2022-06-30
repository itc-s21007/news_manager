/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.ac.it_college.std.s21007.news_manager.database.mapper

import jp.ac.it_college.std.s21007.news_manager.database.mapper.UserDynamicSqlSupport.id
import jp.ac.it_college.std.s21007.news_manager.database.mapper.UserDynamicSqlSupport.password
import jp.ac.it_college.std.s21007.news_manager.database.mapper.UserDynamicSqlSupport.roleType
import jp.ac.it_college.std.s21007.news_manager.database.mapper.UserDynamicSqlSupport.user
import jp.ac.it_college.std.s21007.news_manager.database.mapper.UserDynamicSqlSupport.username
import jp.ac.it_college.std.s21007.news_manager.database.mapper.UserDynamicSqlSupport.viewName
import jp.ac.it_college.std.s21007.news_manager.database.record.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.EnumTypeHandler
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.CountCompleter
import org.mybatis.dynamic.sql.util.kotlin.DeleteCompleter
import org.mybatis.dynamic.sql.util.kotlin.KotlinUpdateBuilder
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.UpdateCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.countFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.deleteFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insert
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insertMultiple
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectDistinct
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectOne
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.update
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper

@Mapper
interface UserMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<User>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="UserResult", value = [
        Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        Result(column="view_name", property="viewName", jdbcType=JdbcType.VARCHAR),
        Result(column="role_type", property="roleType", typeHandler=EnumTypeHandler::class, jdbcType=JdbcType.VARCHAR)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<User>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("UserResult")
    fun selectOne(selectStatement: SelectStatementProvider): User?
}

fun UserMapper.count(completer: CountCompleter) =
    countFrom(this::count, user, completer)

fun UserMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, user, completer)

fun UserMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where { id isEqualTo id_ }
    }

fun UserMapper.insert(row: User) =
    insert(this::insert, row, user) {
        map(id) toProperty "id"
        map(username) toProperty "username"
        map(password) toProperty "password"
        map(viewName) toProperty "viewName"
        map(roleType) toProperty "roleType"
    }

fun UserMapper.insertMultiple(records: Collection<User>) =
    insertMultiple(this::insertMultiple, records, user) {
        map(id) toProperty "id"
        map(username) toProperty "username"
        map(password) toProperty "password"
        map(viewName) toProperty "viewName"
        map(roleType) toProperty "roleType"
    }

fun UserMapper.insertMultiple(vararg records: User) =
    insertMultiple(records.toList())

fun UserMapper.insertSelective(row: User) =
    insert(this::insert, row, user) {
        map(id).toPropertyWhenPresent("id", row::id)
        map(username).toPropertyWhenPresent("username", row::username)
        map(password).toPropertyWhenPresent("password", row::password)
        map(viewName).toPropertyWhenPresent("viewName", row::viewName)
        map(roleType).toPropertyWhenPresent("roleType", row::roleType)
    }

private val columnList = listOf(id, username, password, viewName, roleType)

fun UserMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, user, completer)

fun UserMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, user, completer)

fun UserMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, user, completer)

fun UserMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where { id isEqualTo id_ }
    }

fun UserMapper.update(completer: UpdateCompleter) =
    update(this::update, user, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: User) =
    apply {
        set(id) equalToOrNull row::id
        set(username) equalToOrNull row::username
        set(password) equalToOrNull row::password
        set(viewName) equalToOrNull row::viewName
        set(roleType) equalToOrNull row::roleType
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: User) =
    apply {
        set(id) equalToWhenPresent row::id
        set(username) equalToWhenPresent row::username
        set(password) equalToWhenPresent row::password
        set(viewName) equalToWhenPresent row::viewName
        set(roleType) equalToWhenPresent row::roleType
    }

fun UserMapper.updateByPrimaryKey(row: User) =
    update {
        set(username) equalToOrNull row::username
        set(password) equalToOrNull row::password
        set(viewName) equalToOrNull row::viewName
        set(roleType) equalToOrNull row::roleType
        where { id isEqualTo row.id!! }
    }

fun UserMapper.updateByPrimaryKeySelective(row: User) =
    update {
        set(username) equalToWhenPresent row::username
        set(password) equalToWhenPresent row::password
        set(viewName) equalToWhenPresent row::viewName
        set(roleType) equalToWhenPresent row::roleType
        where { id isEqualTo row.id!! }
    }