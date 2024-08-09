package com.example.xpaytest.ui.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xpaytest.data.network.RetrofitClient
import com.example.xpaytest.data.repository.UserRepository
import com.example.xpaytest.databinding.FragmentUserListBinding
import com.example.xpaytest.util.ViewModelFactory

class UserListFragment : Fragment() {

    private lateinit var binding: FragmentUserListBinding
    private lateinit var userListViewModel: UserListViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
//        userListViewModel = ViewModelProvider(
//            this, ViewModelFactory(UserRepository(RetrofitClient.apiService))
//        ).get(UserListViewModel::class.java)

//        userAdapter = UserAdapter { user ->
//            val action = UserListFragmentDirections.actionUserListFragmentToUserDetailFragment(user.id)
//            findNavController().navigate(action)
//        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userAdapter
        }

//        userListViewModel.users.observe(viewLifecycleOwner, { users ->
//            userAdapter.submitList(users)
//        })

        userListViewModel.loadUsers()
    }
}