package com.cs310.hocamsu.service

import com.cs310.hocamsu.dto.CommentDTO
import com.cs310.hocamsu.model.Comment
import com.cs310.hocamsu.model.Instructor
import com.cs310.hocamsu.repository.CommentRepository
import com.cs310.hocamsu.repository.InstructorRepository
import org.springframework.stereotype.Service

@Service
class CommentService(private val commentRepository: CommentRepository, private val instructorRepository: InstructorRepository) {

    fun create(id: Long, commentDTO: CommentDTO): CommentDTO? =
        instructorRepository.findById(id).orElse(null)?.let {
            val comment = commentRepository.save(mapToEntity(commentDTO, it))
            mapToDTO(comment)
        }

    fun getByInstructorId(id: Long): List<CommentDTO> =
        commentRepository.findByInstructorId(id).map { comment -> mapToDTO(comment) }


    private fun mapToDTO(comment: Comment): CommentDTO = CommentDTO(id = comment.id, text = comment.text)

    private fun mapToEntity(commentDTO: CommentDTO, instructor: Instructor): Comment =
        Comment(text = commentDTO.text, instructor = instructor)
}