package com.example.examen1evapsp.ui.author

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.examen1evapsp.data.entities.Author
import com.example.examen1evapsp.databinding.ItemAuthorBinding


class AuthorAdapter(
    private val onClickListener: (Author) -> Unit
) : ListAdapter<Author, AuthorAdapter.AuthorViewHolder>(CarDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorAdapter.AuthorViewHolder {
        val binding = ItemAuthorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AuthorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AuthorViewHolder, position: Int) {
        TODO("Not yet implemented")
        val author = getItem(position)
        holder.bind(author)
        holder.itemView.setOnClickListener(){
            onClickListener(author)
        }
    }

    inner class AuthorViewHolder(private val binding: ItemAuthorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(author: Author) {
            binding.textViewTitle.text = author.id.toString()
            binding.textViewSubtitle1.text = author.name
            binding.textViewSubtitle2.text = "count"
        }
    }
    class CarDiffCallback : DiffUtil.ItemCallback<Author>() {

        override fun areItemsTheSame(oldItem: Author, newItem: Author): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Author, newItem: Author): Boolean {
            return oldItem == newItem
        }

    }
}