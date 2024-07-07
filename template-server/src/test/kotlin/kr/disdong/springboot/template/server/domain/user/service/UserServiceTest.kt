package kr.disdong.springboot.template.server.domain.user.service

import kr.disdong.springboot.template.domain.user.service.UserManager
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

@Disabled
internal class UserServiceTest {

    private val userManager: UserManager = mock()
    private val sut = UserService(userManager)

    @BeforeEach
    fun setup() {
        whenever(userManager.getUser(any())).thenReturn(null)
        // whenever(userManager.create(any())).thenReturn(UserJpaImpl)
    }

    @Test
    fun `샘플 테스트 1`() {
        val response = sut.getByUserId(1)
        assertNull(response)
    }

    // @Test
    // fun `샘플 테스트 2`() {
    //     // given, when
    //     val response = sut.create(CreateUserBody("name", "010"))
    //
    //     // then
    //     assertEquals("name", response.name)
    //     assertEquals("010", response.phone)
    // }
}
