package com.example.xpaytest.ui.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.xpaytest.data.model.User
import com.example.xpaytest.data.repository.UserRepository
import kotlinx.coroutines.launch

class UserListViewModel(private val repository: UserRepository) : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    private var currentPage = 0
    private val limit = 10

    fun loadUsers() {
        viewModelScope.launch {
            try {
                val userResponse = repository.getUsers(limit, currentPage * limit)
                _users.postValue(userResponse.users)
                currentPage++
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
