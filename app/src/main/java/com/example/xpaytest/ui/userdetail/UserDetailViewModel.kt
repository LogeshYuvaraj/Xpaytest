package com.example.xpaytest.ui.userdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.xpaytest.data.model.User
import com.example.xpaytest.data.repository.UserRepository
import kotlinx.coroutines.launch

class UserDetailViewModel(private val repository: UserRepository) : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    fun loadUserDetails(id: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getUserDetail(id)
                _user.value = response
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}