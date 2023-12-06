package com.cs310.hocamsu.repository

import com.cs310.hocamsu.model.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : JpaRepository<Comment, Long> {
    fun findByInstructorId(id: Long) : List<Comment>
}