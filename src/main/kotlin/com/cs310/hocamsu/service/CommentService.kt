package com.cs310.hocamsu.service

import com.cs310.hocamsu.entity.Comment
import com.cs310.hocamsu.repository.CommentRepository
import org.springframework.stereotype.Service

@Service
class CommentService(private val commentRepository: CommentRepository) {
    fun findAll(): List<Comment> = commentRepository.findAll()

    fun findById(id: Long): Comment? = commentRepository.findById(id).orElse(null)

    fun save(comment: Comment): Comment = commentRepository.save(comment)

    fun deleteById(id: Long) = commentRepository.deleteById(id)
}