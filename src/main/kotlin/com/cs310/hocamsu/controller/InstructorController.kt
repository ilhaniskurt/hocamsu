package com.cs310.hocamsu.controller

import com.cs310.hocamsu.entity.Instructor
import com.cs310.hocamsu.service.InstructorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/instructors")
class InstructorController(private val instructorService: InstructorService) {

    @GetMapping
    fun getAllInstructors(): ResponseEntity<List<Instructor>> =
        ResponseEntity.ok(instructorService.findAll())

    @GetMapping("/{id}")
    fun getInstructorById(@PathVariable id: Long): ResponseEntity<Instructor> =
        instructorService.findById(id)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @PostMapping
    fun createInstructor(@RequestBody instructor: Instructor): ResponseEntity<Instructor> =
        ResponseEntity.ok(instructorService.save(instructor))

    @DeleteMapping("/{id}")
    fun deleteInstructor(@PathVariable id: Long): ResponseEntity<Void> {
        instructorService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}