package kr.disdong.gradle.multi.module.template.domain.repository

import PostDoImpl
import UnsavedPostDoImpl
import kr.disdong.gradle.multi.module.template.domain.jpa.repository.PostRepository
import org.springframework.stereotype.Component

@Component
class PostDoRepository(
    private val postRepository: PostRepository
) {

    fun save(post: UnsavedPostDoImpl): PostDoImpl {
        return PostDoImpl(postRepository.save(post.entity))
    }

    fun hello(): List<PostDoImpl> {
        return postRepository.hello()
            .map {
                PostDoImpl(it)
            }
    }

    fun findAll(): List<PostDoImpl> {
        return postRepository.findAll()
            .map {
                PostDoImpl(it)
            }
    }
}
