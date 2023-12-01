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

    @GetMapping("/{id}")
    fun getInstructorById(@PathVariable id: Long): ResponseEntity<InstructorDTO> =
        instructorService.getById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    fun createInstructor(@RequestBody instructorDTO: InstructorDTO) : ResponseEntity<InstructorDTO> =
        ResponseEntity.ok(instructorService.create(instructorDTO))
}