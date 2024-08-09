package com.example.xpaytest.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.xpaytest.data.repository.UserRepository
import com.example.xpaytest.ui.userdetail.UserDetailViewModel
import com.example.xpaytest.ui.userlist.UserListViewModel

class ViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(UserListViewModel::class.java) -> UserListViewModel(repository) as T
            modelClass.isAssignableFrom(UserDetailViewModel::class.java) -> UserDetailViewModel(repository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}