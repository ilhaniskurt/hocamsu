package com.cs310.hocamsu

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class HocamsuApplication

@RestController
class MessageController {
    // @GetMapping("/")
    // fun index(@RequestParam("name") name: String) = "Hello, $name!"

	@GetMapping("/")
    fun index() = listOf(
        Message("1", "Hello!"),
        Message("2", "Bonjour!"),
        Message("3", "Privet!"),
    )
}

data class Message(val id: String?, val text: String)

fun main(args: Array<String>) {
	runApplication<HocamsuApplication>(*args)
}
