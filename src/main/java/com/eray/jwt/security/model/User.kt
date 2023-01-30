package com.eray.jwt.security.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @Column(name = "user_id", unique = true, nullable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val username: String,
    val password: String,
    val email: String,

    @Enumerated(EnumType.STRING)
    val role: Role,
)
