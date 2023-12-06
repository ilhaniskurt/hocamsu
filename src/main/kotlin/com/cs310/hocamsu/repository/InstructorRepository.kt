package com.cs310.hocamsu.repository

import com.cs310.hocamsu.model.Instructor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InstructorRepository : JpaRepository<Instructor, Long> {
    fun findByNameContainingIgnoreCase(name: String): List<Instructor>
}