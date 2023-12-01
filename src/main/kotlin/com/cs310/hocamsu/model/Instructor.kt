package com.cs310.hocamsu.model

import jakarta.persistence.*

@Entity
@Table(name = "instructors")
data class Instructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @OneToMany(mappedBy = "instructor", cascade = [CascadeType.ALL], orphanRemoval = true)
    val comments: MutableList<Comment> = mutableListOf()

//    @OneToMany(mappedBy = "instructor", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.EAGER)
//    val comments: MutableList<Comment> = mutableListOf()
)
