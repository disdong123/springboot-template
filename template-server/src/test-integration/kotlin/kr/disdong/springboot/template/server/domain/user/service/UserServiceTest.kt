package kr.disdong.springboot.template.server.domain.user.service

import kr.disdong.springboot.template.domain.user.model.impl.PlainUserJpaImpl
import kr.disdong.springboot.template.domain.user.repository.UserRepository
import kr.disdong.springboot.template.server.core.config.IntegrationTestConfiguration
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class UserServiceTest : IntegrationTestConfiguration() {
    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var sut: UserService

    @BeforeEach
    fun setup() {
        userRepository.deleteAll()
        userRepository.save(PlainUserJpaImpl(name = "one", phone = "01012341234"))
    }

    @Test
    fun `simple test`() {
        val response = sut.getByUserId(1L)

        assertNotNull(response)
    }
}
