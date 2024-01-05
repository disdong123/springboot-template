package kr.disdong.gradle.multi.module.template.jdbc.module.user.repository

import kr.disdong.gradle.multi.module.template.jdbc.module.user.model.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserJdbcRepository : CrudRepository<UserEntity, Long>
