package kr.disdong.gradle.multi.module.template.domain.module.user.repository

import kr.disdong.gradle.multi.module.template.domain.module.user.model.UnsavedUser
import kr.disdong.gradle.multi.module.template.domain.module.user.model.User

interface UserRepository {

    fun findByUserId(userId: Long): User?

    fun save(user: UnsavedUser): User
}
