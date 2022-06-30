package jp.ac.it_college.std.s21007.news_manager.application


import jp.ac.it_college.std.s21007.news_manager.domain.model.User
import jp.ac.it_college.std.s21007.news_manager.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthenticationService(private val userRepository: UserRepository) {
    fun findUser(username: String): User? {
        return userRepository.find(username)
    }
}