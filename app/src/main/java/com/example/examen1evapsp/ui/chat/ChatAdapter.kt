package com.example.examen1evapsp.ui.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.examen1evapsp.R
import com.example.examen1evapsp.data.entities.Groups
import com.example.examen1evapsp.data.entities.Mensaje
import com.example.examen1evapsp.ui.groups.GroupsActivity
import com.example.examen1evapsp.ui.groups.GrupoAdapter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MensajeAdapter(private val mensajes: List<Mensaje>, private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_A = 1
        const val VIEW_TYPE_B = 2
    }

    inner class ViewHolderA(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreTextView: TextView = itemView.findViewById(R.id.user)
        private val descripcionTextView: TextView = itemView.findViewById(R.id.texto)
        private val fechaTextView: TextView = itemView.findViewById(R.id.fecha)

        fun bind(mensaje: Mensaje) {
            nombreTextView.text = mensaje.id.toString()
            descripcionTextView.text = mensaje.texto
            fechaTextView.text = mensaje.fecha
        }
    }

    inner class ViewHolderB(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreTextView: TextView = itemView.findViewById(R.id.user)
        private val descripcionTextView: TextView = itemView.findViewById(R.id.texto)
        private val fechaTextView: TextView = itemView.findViewById(R.id.fecha)

        fun bind(mensaje: Mensaje) {
            nombreTextView.text = mensaje.id.toString()
            descripcionTextView.text = mensaje.texto
            fechaTextView.text = mensaje.fecha
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_A -> {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
                ViewHolderA(itemView)
            }
            VIEW_TYPE_B -> {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_chat2, parent, false)
                ViewHolderB(itemView)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mensaje = mensajes[position]
        when (holder.itemViewType) {
            VIEW_TYPE_A -> {
                (holder as ViewHolderA).bind(mensaje)
            }
            VIEW_TYPE_B -> {
                (holder as ViewHolderB).bind(mensaje)
            }
        }
    }

    override fun getItemCount(): Int {
        return mensajes.size
    }

    override fun getItemViewType(position: Int): Int {
        val mensaje = mensajes[position]
        // Aquí decides el tipo de vista (view type) basándote en alguna condición
        return if (mensaje.userId == 1) {
            VIEW_TYPE_A
        } else {
            VIEW_TYPE_B
        }
    }

    private fun formatDate(date: Date): String {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return sdf.format(date)
    }
}