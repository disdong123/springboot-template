package kr.disdong.springboot.template.server.domain.user.service

import kr.disdong.springboot.template.domain.user.fixture.UserFixture
import kr.disdong.springboot.template.domain.user.service.UserManager
import kr.disdong.springboot.template.server.domain.user.dto.CreateUserBody
import kr.disdong.springboot.template.server.domain.user.exception.UserNotFound
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

internal class UserServiceTest {

    private val userManager: UserManager = mock()
    private val sut = UserService(userManager)

    @Nested
    @DisplayName("id 로 유저를 조회할 때")
    inner class GetByUserIdTest {

        @Nested
        inner class SuccessCase {
            @BeforeEach
            fun setup() {
                whenever(userManager.getUser(any())).thenReturn(UserFixture.any())
            }

            @Test
            fun `유저 정보가 있으면 null 이 아닌 값을 반환한다`() {
                val response = sut.getByUserId(1)

                assertNotNull(response)
            }
        }

        @Nested
        inner class FailureCase {
            @BeforeEach
            fun setup() {
                whenever(userManager.getUser(any())).thenReturn(null)
            }

            @Test
            fun `유저 정보가 없으면 예외가 발생한다`() {
                assertThrows<UserNotFound> {
                    sut.getByUserId(1)
                }
            }
        }
    }

    @Nested
    inner class CreateTest {
        @BeforeEach
        fun setup() {
            whenever(userManager.create(any())).thenReturn(UserFixture.any("name"))
        }

        @Test
        fun `샘플 테스트 1`() {
            // given, when
            val response = sut.create(CreateUserBody("name", "010"))

            // then
            assertEquals(response.name, "name")
        }
    }
}
