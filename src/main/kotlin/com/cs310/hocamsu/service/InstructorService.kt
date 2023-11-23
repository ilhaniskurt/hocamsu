package com.cs310.hocamsu.service

import com.cs310.hocamsu.entity.Instructor
import com.cs310.hocamsu.repository.InstructorRepository
import org.springframework.stereotype.Service

@Service
class InstructorService(private val instructorRepository: InstructorRepository) {
    fun findAll(): List<Instructor> = instructorRepository.findAll()

    fun findById(id: Long): Instructor? = instructorRepository.findById(id).orElse(null)

    fun save(instructor: Instructor): Instructor = instructorRepository.save(instructor)

    fun deleteById(id: Long) = instructorRepository.deleteById(id)
}