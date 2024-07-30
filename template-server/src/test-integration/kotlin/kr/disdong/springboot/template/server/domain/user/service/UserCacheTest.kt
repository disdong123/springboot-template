package kr.disdong.springboot.template.server.domain.user.service

import kr.disdong.springboot.template.domain.user.cache.UserCache
import kr.disdong.springboot.template.server.core.config.IntegrationTestConfiguration
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class UserCacheTest : IntegrationTestConfiguration() {

    @Autowired
    private lateinit var userCache: UserCache

    @Test
    fun `simple test`() {
        userCache.setPhoneByName("name", "phone")

        assertEquals(userCache.findPhoneByName("name"), "phone")
    }
}
