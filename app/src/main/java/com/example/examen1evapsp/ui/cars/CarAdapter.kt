package com.example.examen1evapsp.ui.cars

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.examen1evapsp.data.entities.Car
import com.example.examen1evapsp.databinding.ItemCarBinding

class CarAdapter(
    private val onClickListener: (Car) -> Unit
): ListAdapter<Car, CarAdapter.CarViewHolder>(CarDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = getItem(position)
        holder.bind(car)
        holder.itemView.setOnClickListener {
            onClickListener(car)
        }
    }

    inner class CarViewHolder(private val binding: ItemCarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(car: Car) {
            // TODO pintar la matricula el modelo y el color en los textViews
        }
    }

    class CarDiffCallback : DiffUtil.ItemCallback<Car>() {

        override fun areItemsTheSame(oldItem: Car, newItem: Car): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Car, newItem: Car): Boolean {
            return oldItem == newItem
        }

    }
}