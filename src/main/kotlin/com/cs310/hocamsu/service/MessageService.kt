package com.cs310.hocamsu.service

import org.springframework.stereotype.Service

import com.cs310.hocamsu.model.Message
import com.cs310.hocamsu.dao.MessageDAO


@Service
class MessageService(val messageDAO: MessageDAO) {
    fun findMessages(): List<Message> = messageDAO.getAll()

    fun save(message: Message) {
        messageDAO.save(message)
    }
}