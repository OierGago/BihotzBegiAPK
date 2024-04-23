package com.example.examen1evapsp.ui.publicos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen1evapsp.R
import com.example.examen1evapsp.data.entities.GrupoPublico

class GrupoPublicoAdapter(private val gruposPublicos: List<GrupoPublico>) :
    RecyclerView.Adapter<GrupoPublicoAdapter.GrupoPublicoViewHolder>() {

    inner class GrupoPublicoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreTextView: TextView = itemView.findViewById(R.id.nombreTextView)
        private val descripcionTextView: TextView = itemView.findViewById(R.id.descripcionTextView)

        fun bind(grupoPublico: GrupoPublico) {
            nombreTextView.text = grupoPublico.nombre
            descripcionTextView.text = grupoPublico.descripcion
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GrupoPublicoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return GrupoPublicoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GrupoPublicoViewHolder, position: Int) {
        val grupoPublico = gruposPublicos[position]
        holder.bind(grupoPublico)
    }

    override fun getItemCount(): Int {
        return gruposPublicos.size
    }
}