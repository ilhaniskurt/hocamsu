package com.cs310.hocamsu.service

import com.cs310.hocamsu.dto.InstructorDTO
import com.cs310.hocamsu.model.Instructor
import com.cs310.hocamsu.repository.InstructorRepository
import org.springframework.stereotype.Service

@Service
class InstructorService(private val instructorRepository: InstructorRepository) {
    fun create(instructorDTO: InstructorDTO): InstructorDTO {
        val instructor = instructorRepository.save(mapToEntity(instructorDTO))
        return mapToDTO(instructor)
    }

    fun getAll(): List<InstructorDTO> = instructorRepository.findAll().map { instructor -> mapToDTO(instructor) }

    fun getById(id: Long): InstructorDTO? = instructorRepository.findById(id).orElse(null)?.let { mapToDTO(it) }

    fun getByName(name: String): List<InstructorDTO> =
            instructorRepository.findByNameContainingIgnoreCase(name).map { instructor -> mapToDTO(instructor) }

    fun like(id: Long): InstructorDTO? =
        instructorRepository.findById(id).orElse(null)?.let {
            it.rating += 1
            mapToDTO(instructorRepository.save(it))
        }


    fun dislike(id: Long): InstructorDTO? =
            instructorRepository.findById(id).orElse(null)?.let {
                it.rating -= 1
                mapToDTO(instructorRepository.save(it))
            }

    private fun mapToDTO(instructor: Instructor): InstructorDTO =
            InstructorDTO(id = instructor.id, name = instructor.name, rating = instructor.rating, courses = instructor.courses)

    private fun mapToEntity(instructorDTO: InstructorDTO): Instructor =
            Instructor(name = instructorDTO.name, rating = instructorDTO.rating, courses = instructorDTO.courses)
}