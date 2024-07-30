package kr.disdong.springboot.template.domain

import kr.disdong.springboot.template.jpa.JpaApplication
import kr.disdong.template.infrastructure.redis.RedisApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(JpaApplication::class, RedisApplication::class)
class DomainApplication
