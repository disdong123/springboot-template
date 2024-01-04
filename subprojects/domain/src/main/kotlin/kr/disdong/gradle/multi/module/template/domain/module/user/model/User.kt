package kr.disdong.gradle.multi.module.template.domain.module.user.model

interface UnsavedUser {
    val id: Long
    var name: String
    val phone: String
}

interface User : UnsavedUser {
    fun updateName(name: String)
}
