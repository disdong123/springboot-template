package kr.disdong.springboot.template.domain.user.fixture

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import com.navercorp.fixturemonkey.kotlin.setExp
import kr.disdong.springboot.template.domain.common.fixture.FixtureUtil
import kr.disdong.springboot.template.domain.user.model.User
import kr.disdong.springboot.template.domain.user.model.impl.UserJpaImpl
import kr.disdong.springboot.template.jpa.domain.user.model.UserEntity

object UserFixture {

    fun any(): User = FixtureUtil.monkey().giveMeBuilder<UserJpaImpl>()
        .sample()

    fun any(name: String): User = UserJpaImpl(UserEntityFixture.any(name))
}

private object UserEntityFixture {
    fun any(name: String): UserEntity = FixtureUtil.monkey().giveMeBuilder<UserEntity>()
        .setExp(UserEntity::name, name)
        .sample()
}
