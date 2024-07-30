package kr.disdong.template.infrastructure.redis.config

import org.springframework.boot.autoconfigure.data.redis.RedisProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class RedisConfig {

    @Bean
    fun redisConnectionFactory(
        redisProperties: RedisProperties,
    ): LettuceConnectionFactory {
        return LettuceConnectionFactory(
            redisProperties.host,
            redisProperties.port
        )
    }

    @Bean
    fun redisTemplate(connectionFactory: LettuceConnectionFactory): RedisTemplate<*, *> {
        val template = RedisTemplate<Any, Any>()
        template.connectionFactory = connectionFactory
        return template
    }
}
