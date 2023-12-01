package com.cs310.hocamsu.model

import jakarta.persistence.*

@Entity
@Table(name = "comments")
data class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val text: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    val instructor: Instructor

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "instructor_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    var instructor: Instructor

//    @ManyToOne
//    @JoinColumn(name = "instructor_id")
//    val instructor: Instructor
)
