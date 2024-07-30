package kr.disdong.springboot.template.domain.user.cache

interface UserCache {
    fun findPhoneByName(name: String): String?

    fun setPhoneByName(name: String, phone: String)
}
