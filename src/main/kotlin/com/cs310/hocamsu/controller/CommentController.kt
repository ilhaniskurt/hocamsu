package com.cs310.hocamsu.controller

import com.cs310.hocamsu.dto.CommentDTO
import com.cs310.hocamsu.service.CommentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comments")
class CommentController(private val commentService: CommentService) {
    @PostMapping("/{id}")
    fun createComment(@PathVariable id: Long, @RequestBody commentDTO: CommentDTO): ResponseEntity<CommentDTO> =
        ResponseEntity.ok(commentService.create(id, commentDTO))

    @GetMapping("/{id}")
    fun getCommentsByInstructorId(@PathVariable id: Long): ResponseEntity<List<CommentDTO>> =
        ResponseEntity.ok(commentService.getByInstructorId(id))
}