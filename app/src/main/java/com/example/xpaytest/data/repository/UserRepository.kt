package com.example.xpaytest.data.repository

import com.example.xpaytest.data.network.RetrofitClient

class UserRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun getUsers(limit: Int, skip: Int) = apiService.getUsers(limit, skip)
    suspend fun getUserDetail(id: Int) = apiService.getUserDetail(id)
}