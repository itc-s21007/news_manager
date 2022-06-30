package jp.ac.it_college.std.s21007.news_manager.database.repository

import jp.ac.it_college.std.s21007.news_manager.database.mapper.UserDynamicSqlSupport
import jp.ac.it_college.std.s21007.news_manager.database.mapper.UserDynamicSqlSupport.username
import jp.ac.it_college.std.s21007.news_manager.database.mapper.UserMapper
import jp.ac.it_college.std.s21007.news_manager.database.mapper.selectByPrimaryKey
import jp.ac.it_college.std.s21007.news_manager.database.mapper.selectOne
import jp.ac.it_college.std.s21007.news_manager.domain.model.User
import jp.ac.it_college.std.s21007.news_manager.domain.repository.UserRepository
import org.springframework.stereotype.Repository
import jp.ac.it_college.std.s21007.news_manager.database.record.User as Users

@Repository

class UserRepositoryImp(
    private val mapper: UserMapper
) : UserRepository {
    override fun find(username : String): User? {
        val record = mapper.selectOne {
            where{
                UserDynamicSqlSupport.user.username isEqualTo username
            }
        }
        return record?.let { toMode(it) }
    }

    override fun find(id: Long): User? {
        val record = mapper.selectByPrimaryKey(id)
        return record?.let { toMode(it) }
    }

    private fun toMode(record: Users) : User {
        return User(
            record.id!!,
            record.username!!,
            record.password!!,
            record.viewName!!,
            record.roleType!!
        )
    }
}