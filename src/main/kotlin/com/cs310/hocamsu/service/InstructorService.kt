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

//    fun update(id: Long, instructorDTO: InstructorDTO) =
//        instructorRepository.findById(id).orElse(null)?.let {
//            it.name = instructorDTO.name
//            mapToDTO(instructorRepository.save(it))
//        }
//
//    fun deleteById(id: Long) = instructorRepository.deleteById(id)

    private fun mapToDTO(instructor: Instructor): InstructorDTO  = InstructorDTO(id = instructor.id, name = instructor.name)

    private fun mapToEntity(instructorDTO: InstructorDTO): Instructor = Instructor(name = instructorDTO.name)
}