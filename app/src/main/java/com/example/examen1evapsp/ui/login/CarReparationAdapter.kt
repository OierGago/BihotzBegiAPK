package com.example.examen1evapsp.ui.login

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.examen1evapsp.data.entities.Reparation
import com.example.examen1evapsp.databinding.ItemGroupsBinding

class CarReparationAdapter(
    private val onClickListener: (reparation: Reparation) -> Unit
): ListAdapter<Reparation, CarReparationAdapter.ReparationViewHolder>(ReparationDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReparationViewHolder {
        val binding = ItemGroupsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReparationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReparationViewHolder, position: Int) {
        val reparation = getItem(position)
        holder.bind(reparation)
        holder.itemView.setOnClickListener {
            onClickListener(reparation)
        }
    }

    inner class ReparationViewHolder(private val binding: ItemGroupsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(reparation: Reparation) {
            binding.textViewTitle.text = reparation.reparationDate.toString();
            binding.textViewSubtitle1.text = reparation.price.toString();
            binding.textViewSubtitle2.text = reparation.idCar.toString();
            // TODO setear los valores de precio y fecha en el titulo y subtitulo respectivamente
        }
    }

    class ReparationDiffCallback : DiffUtil.ItemCallback<Reparation>() {

        override fun areItemsTheSame(oldItem: Reparation, newItem: Reparation): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Reparation, newItem: Reparation): Boolean {
            return oldItem == newItem
        }

    }
}