package com.cs310.hocamsu

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
// import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping

import com.cs310.hocamsu.model.Message
import com.cs310.hocamsu.service.MessageService

@SpringBootApplication
class HocamsuApplication

@RestController
class MessageController(val service: MessageService) {
    // @GetMapping("/")
    // fun index(@RequestParam("name") name: String) = "Hello, $name!"

	// @GetMapping("/")
    // fun index() = listOf(
    //     Message("1", "Hello!"),
    //     Message("2", "Bonjour!"),
    //     Message("3", "Privet!"),
    // )

	@GetMapping("/list")
    fun index(): List<Message> = service.findMessages()

    @PostMapping("/list")
    fun post(@RequestBody message: Message) {
       service.save(message)
    }
}

fun main(args: Array<String>) {
	runApplication<HocamsuApplication>(*args)
}
