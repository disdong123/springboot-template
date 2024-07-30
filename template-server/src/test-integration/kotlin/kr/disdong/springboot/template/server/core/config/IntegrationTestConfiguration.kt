package kr.disdong.springboot.template.server.core.config

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(classes = [RedisTestConfiguration::class])
@AutoConfigureMockMvc
@ActiveProfiles("test")
abstract class IntegrationTestConfiguration
