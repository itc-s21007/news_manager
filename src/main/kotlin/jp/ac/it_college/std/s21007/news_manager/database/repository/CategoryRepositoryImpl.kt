package jp.ac.it_college.std.s21007.news_manager.database.repository

import jp.ac.it_college.std.s21007.news_manager.database.mapper.CategoryMapper
import jp.ac.it_college.std.s21007.news_manager.database.mapper.deleteByPrimaryKey
import jp.ac.it_college.std.s21007.news_manager.database.mapper.insert
import jp.ac.it_college.std.s21007.news_manager.database.mapper.updateByPrimaryKeySelective
import jp.ac.it_college.std.s21007.news_manager.domain.model.Category
import jp.ac.it_college.std.s21007.news_manager.domain.repository.CategoryRepository
import org.springframework.stereotype.Repository
import jp.ac.it_college.std.s21007.news_manager.database.record.Category as RecordCategory


@Repository
class CategoryRepositoryImpl(
    private val categoryMapper: CategoryMapper
) : CategoryRepository {
    override fun register(category: Category) {
        categoryMapper.insert(toCategory(category))
    }

    override fun update(id: Long, name: String?) {
        categoryMapper.updateByPrimaryKeySelective(RecordCategory(id, name))
    }

    override fun delete(id: Long) {
        categoryMapper.deleteByPrimaryKey(id)
    }

    private fun toCategory(model: Category): RecordCategory {
        return  RecordCategory(model.id, model.name)
    }


}