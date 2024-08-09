package com.example.xpaytest.ui.userlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xpaytest.R
import com.example.xpaytest.data.model.User

import com.bumptech.glide.Glide
import com.example.xpaytest.databinding.ItemUserBinding

class UserAdapter(private val users: MutableList<User>, private val onItemClick: (User) -> Unit) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    fun addUsers(newUsers: List<User>) {
        users.addAll(newUsers)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.userName.text = "${user.firstName} ${user.lastName}"
            binding.userEmail.text = user.email
            Glide.with(binding.root.context).load(user.image).into(binding.userImage)

            binding.root.setOnClickListener {
                onItemClick(user)
            }
        }
    }
}

