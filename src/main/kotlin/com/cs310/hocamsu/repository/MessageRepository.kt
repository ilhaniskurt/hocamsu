package com.cs310.hocamsu.repository

import org.springframework.data.repository.CrudRepository

import com.cs310.hocamsu.model.Message


interface MessageRepository : CrudRepository<Message, String>