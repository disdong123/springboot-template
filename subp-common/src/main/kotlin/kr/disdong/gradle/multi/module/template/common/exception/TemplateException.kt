package kr.disdong.gradle.multi.module.template.common.exception

import java.lang.RuntimeException

/**
 *
 * @property message
 */
abstract class TemplateException(
    override val message: String,
) : RuntimeException(message) {

    abstract fun getCode(): Int
}
