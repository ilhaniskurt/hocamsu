package com.cs310.hocamsu.entity

import jakarta.persistence.*

@Entity
@Table(name = "comments")
data class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val text: String
)
