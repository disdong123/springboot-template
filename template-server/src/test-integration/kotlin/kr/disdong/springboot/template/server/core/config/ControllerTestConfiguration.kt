package kr.disdong.springboot.template.server.core.config

import kr.disdong.springboot.template.server.domain.user.controller.UserController
import kr.disdong.springboot.template.server.domain.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest(
    UserController::class,
)
@ActiveProfiles("test")
abstract class ControllerTestConfiguration {

    @MockBean
    protected lateinit var userService: UserService

    @Autowired
    protected lateinit var mockMvc: MockMvc
}
