package kr.disdong.springboot.template.domain.user.cache.impl

import kr.disdong.springboot.template.domain.user.cache.UserCache
import kr.disdong.template.infrastructure.redis.domain.user.UserRedisCache
import org.springframework.stereotype.Component

@Component
class UserCacheImpl(
    private val userRedisCache: UserRedisCache,
) : UserCache {
    override fun findPhoneByName(name: String): String? {
        return userRedisCache.findPhoneByName(name)
    }

    override fun setPhoneByName(name: String, phone: String) {
        userRedisCache.setPhoneByName(name, phone)
    }
}
