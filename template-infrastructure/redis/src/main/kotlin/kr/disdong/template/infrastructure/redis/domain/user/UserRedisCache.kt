package kr.disdong.template.infrastructure.redis.domain.user

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

@Component
class UserRedisCache(
    private val redisTemplate: RedisTemplate<String, String>
) {

    companion object {
        private const val KEY = "user"
    }

    fun findPhoneByName(name: String): String? {
        return redisTemplate.opsForValue().get(phoneKey(name))
    }

    fun setPhoneByName(name: String, phone: String) {
        redisTemplate.opsForValue().set(phoneKey(name), phone)
    }

    private fun phoneKey(name: String): String = "$KEY-$name"
}
