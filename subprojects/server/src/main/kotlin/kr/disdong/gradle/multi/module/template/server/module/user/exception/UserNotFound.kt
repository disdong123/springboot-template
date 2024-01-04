package kr.disdong.gradle.multi.module.template.server.module.user.exception

import kr.disdong.gradle.multi.module.template.common.exception.TemplateException

class UserNotFound(private val userId: Long) : TemplateException("$userId 유저를 찾을 수 없습니다.") {
    override fun getCode(): Int {
        return 404
    }
}
