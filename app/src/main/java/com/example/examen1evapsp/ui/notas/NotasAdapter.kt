package com.example.examen1evapsp.ui.notas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.examen1evapsp.R
import com.example.examen1evapsp.data.entities.Groups
import com.example.examen1evapsp.data.entities.Nota
import com.example.examen1evapsp.ui.groups.GrupoAdapter

class NotasAdapter(private val notas: List<Nota>):
    RecyclerView.Adapter<NotasAdapter.NotasViewHolder>() {
    inner class NotasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val fecha: TextView = itemView.findViewById(R.id.textView3)
        private val descipcion: TextView = itemView.findViewById(R.id.textView5)
        fun bind(
            nota: Nota
        ) {
            fecha.text = nota.fecha
            descipcion.text = nota.notaTexto


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotasAdapter.NotasViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_notas, parent, false)
        return NotasViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NotasAdapter.NotasViewHolder, position: Int) {
        val notas = notas[position]
        holder.bind(notas)
    }

    override fun getItemCount(): Int {
        return notas.size
    }
}