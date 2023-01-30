package com.eray.jwt.security.dto

data class LoginRequest(
    val username: String,
    val password: String
)
