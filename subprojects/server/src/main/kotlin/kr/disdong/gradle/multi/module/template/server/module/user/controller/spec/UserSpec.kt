package kr.disdong.gradle.multi.module.template.server.module.user.controller.spec

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import kr.disdong.gradle.multi.module.template.common.dto.TemplateResponse
import kr.disdong.gradle.multi.module.template.domain.module.user.model.User
import kr.disdong.gradle.multi.module.template.server.module.user.dto.CreateUserBody

@Tag(name = "유저")
interface UserSpec {

    @Operation
    fun getByUserId(userId: Long): TemplateResponse<User>

    @Operation
    fun create(body: CreateUserBody): TemplateResponse<User>
}
