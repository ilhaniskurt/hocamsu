package com.cs310.hocamsu.controller

import com.cs310.hocamsu.dto.InstructorDTO
import com.cs310.hocamsu.service.InstructorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/instructors")
class InstructorController(private val instructorService: InstructorService) {

    @GetMapping
    fun getAllInstructors(): ResponseEntity<List<InstructorDTO>> = ResponseEntity.ok(instructorService.getAll())

    @GetMapping("/search")
    fun searchByNameContaining(@RequestParam(required = true) name: String): ResponseEntity<List<InstructorDTO>> =
            ResponseEntity.ok(instructorService.getByName(name))

    @GetMapping("/{id}")
    fun getInstructorById(@PathVariable id: Long): ResponseEntity<InstructorDTO> =
        instructorService.getById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PutMapping("/{id}/like")
    fun like(@PathVariable id: Long): ResponseEntity<InstructorDTO> =
        instructorService.like(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PutMapping("/{id}/dislike")
    fun dislike(@PathVariable id: Long): ResponseEntity<InstructorDTO> =
            instructorService.dislike(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    fun createInstructor(@RequestBody instructorDTO: InstructorDTO) : ResponseEntity<InstructorDTO> =
        ResponseEntity.ok(instructorService.create(instructorDTO))
}