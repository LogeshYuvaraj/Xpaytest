package com.example.xpaytest.ui.userlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.xpaytest.data.repository.UserRepository

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    fun getUsers(limit: Int, skip: Int) = liveData {
        val response = repository.getUsers(limit, skip)
        emit(response)
    }

    fun getUserDetail(userId: Int) = liveData {
        val user = repository.getUserDetail(userId)
        emit(user)
    }
}