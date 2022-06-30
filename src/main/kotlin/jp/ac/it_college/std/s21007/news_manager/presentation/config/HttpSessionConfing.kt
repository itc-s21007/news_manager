package jp.ac.it_college.std.s21007.news_manager.presentation.config

import org.springframework.context.annotation.Bean
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession

@EnableRedisHttpSession
class HttpSessionConfing{
    @Bean
    fun connectionFactory(): JedisConnectionFactory {
        return JedisConnectionFactory()
    }
}