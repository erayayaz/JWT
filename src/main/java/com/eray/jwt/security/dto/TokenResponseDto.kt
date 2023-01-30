package com.eray.jwt.security.dto

data class TokenResponseDto(
    val accessToken: String,
    val userDto: UserDto,
)
