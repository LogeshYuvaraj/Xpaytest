package com.example.xpaytest

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xpaytest.data.model.User
import com.example.xpaytest.data.repository.UserRepository
import com.example.xpaytest.databinding.ActivityMainBinding
import com.example.xpaytest.ui.userlist.UserAdapter
import com.example.xpaytest.ui.userlist.UserViewModel
import com.example.xpaytest.ui.userlist.UserViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userAdapter by lazy { UserAdapter(mutableListOf()) { user -> onUserClicked(user) } }
    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory(UserRepository())
    }

    private var isLoading = false
    private var skip = 0
    private val limit = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadUsers()
        setupPagination()
    }


    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }

    private fun loadUsers() {
        isLoading = true
        userViewModel.getUsers(limit, skip).observe(this, Observer { response ->
            userAdapter.addUsers(response.users)
            isLoading = false
        })
    }

    private fun setupPagination() {
        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                if (!isLoading && visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
                    skip += limit
                    loadUsers()
                }
            }
        })
    }

    private fun onUserClicked(user: User) {
        val intent = Intent(this, UserDetailActivity::class.java).apply {
            putExtra("USER_ID", user.id)
        }
        startActivity(intent)
    }
}