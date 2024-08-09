package com.example.xpaytest.data.model

data class UserResponse(
    val users: List<User>,
    val total: Int,
    val skip: Int,
    val limit: Int
)