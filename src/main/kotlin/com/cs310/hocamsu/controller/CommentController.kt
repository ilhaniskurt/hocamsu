package com.cs310.hocamsu.controller

import com.cs310.hocamsu.entity.Comment
import com.cs310.hocamsu.service.CommentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comments")
class CommentController(private val commentService: CommentService) {

    @GetMapping
    fun getAllInstructors(): ResponseEntity<List<Comment>> =
        ResponseEntity.ok(commentService.findAll())

    @GetMapping("/{id}")
    fun getInstructorById(@PathVariable id: Long): ResponseEntity<Comment> =
        commentService.findById(id)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @PostMapping
    fun createInstructor(@RequestBody comment: Comment): ResponseEntity<Comment> =
        ResponseEntity.ok(commentService.save(comment))

    @DeleteMapping("/{id}")
    fun deleteInstructor(@PathVariable id: Long): ResponseEntity<Void> {
        commentService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}