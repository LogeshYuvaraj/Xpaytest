package com.example.xpaytest.ui.userdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.xpaytest.data.network.RetrofitClient
import com.example.xpaytest.data.repository.UserRepository
import com.example.xpaytest.databinding.FragmentUserDetailBinding
import com.example.xpaytest.util.ViewModelFactory

class UserDetailFragment : Fragment() {

    private lateinit var binding: FragmentUserDetailBinding
    private lateinit var userDetailViewModel: UserDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        userDetailViewModel = ViewModelProvider(
//            this, ViewModelFactory(UserRepository(RetrofitClient.apiService))
//        ).get(UserDetailViewModel::class.java)

//        val userId = UserDetailFragmentArgs.fromBundle(requireArguments()).userId

//        userDetailViewModel.loadUserDetails(userId)
//
//        userDetailViewModel.user.observe(viewLifecycleOwner, { user ->
//            binding.nameTextView.text = "${user.firstName} ${user.lastName}"
//            binding.emailTextView.text = user.email
//            Picasso.get().load(user.avatar).into(binding.avatarImageView)
//        })
    }
}