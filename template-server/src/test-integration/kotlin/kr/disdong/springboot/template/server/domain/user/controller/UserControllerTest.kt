package kr.disdong.springboot.template.server.domain.user.controller

import kr.disdong.springboot.template.domain.user.fixture.UserFixture
import kr.disdong.springboot.template.server.core.config.ControllerTestConfiguration
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class UserControllerTest : ControllerTestConfiguration() {

    @Test
    fun `simple test`() {
        whenever(userService.getByUserId(any())).thenReturn(UserFixture.any("one"))

        // when
        val result = mockMvc.perform(get("/users/1"))

        // then
        result
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.data.name").value("one"))
            .andDo(print())
    }
}
