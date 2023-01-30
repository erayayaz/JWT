package com.eray.jwt.security.dto

import com.eray.jwt.security.model.Role
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

data class UserDto(
    val username: String,
    val password: String,
    val email: String,

    @Enumerated(EnumType.STRING)
    val role: Role,
)
