package es.davidcorcuera.roomdatabasesample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.davidcorcuera.roomdatabasesample.databinding.ItemListBinding
import es.davidcorcuera.roomdatabasesample.model.User

class UserAdapter(val clickListener: MyListener) : ListAdapter<User, UserAdapter.UserViewHolder>(RowItemDiffCallback()) {

    class UserViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(layoutInflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.binding.user = user
        holder.itemView.setOnClickListener { clickListener.onClick(user) }
    }
}

class RowItemDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}

class MyListener(val clickListener: (user: User) -> Unit) {
    fun onClick(user: User) = clickListener(user)
}

