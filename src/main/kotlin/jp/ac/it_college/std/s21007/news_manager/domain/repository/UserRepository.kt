package jp.ac.it_college.std.s21007.news_manager.domain.repository

import jp.ac.it_college.std.s21007.news_manager.domain.model.User


interface UserRepository {
    fun find(email: String) : User?

    fun find(id: Long) : User?
}