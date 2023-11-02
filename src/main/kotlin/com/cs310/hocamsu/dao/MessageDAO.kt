package com.cs310.hocamsu.dao

import java.util.UUID

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository;

import com.cs310.hocamsu.model.Message

@Repository
class MessageDAO(val db: JdbcTemplate) {
    fun getAll(): List<Message> = db.query("select * from messages") { response, _ ->
        Message(response.getString("id"), response.getString("text"))
    }

    fun save(message: Message) {
        val id = message.id ?: UUID.randomUUID().toString()
        db.update("insert into messages values ( ?, ? )",
           id, message.text)
    }
}
