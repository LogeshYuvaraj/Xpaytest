package com.example.xpaytest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.xpaytest.data.repository.UserRepository
import com.example.xpaytest.databinding.ActivityUserDetailBinding
import com.example.xpaytest.ui.userlist.UserViewModel
import com.example.xpaytest.ui.userlist.UserViewModelFactory


class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding
    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory(UserRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userId = intent.getIntExtra("USER_ID", -1)
        loadUserDetail(userId)
    }

    private fun loadUserDetail(userId: Int) {
        userViewModel.getUserDetail(userId).observe(this, Observer { user ->
            binding.userDetailName.text = "${user.firstName} ${user.lastName}"
            binding.userDetailEmail.setText(user.email)
            binding.userDetailPassword.setText(user.password)
            binding.userDetailbirthDate.setText(user.birthDate)
            binding.userDetailGender.setText(user.gender)
            binding.userDetailPhone.setText(user.phone)
            binding.userDetailAddress.setText(user.address.address + ", " + user.address.city + ", " + user.address.state + ", " + user.address.country)
            binding.userDetailCompany.setText(user.company.name + ", " + user.company.title + ", " + user.company.department)
            binding.userDetailRole.setText(user.role)
            Glide.with(this).load(user.image).into(binding.userDetailImage)
        })
    }
}