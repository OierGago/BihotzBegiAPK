package com.example.examen1evapsp.ui.groups

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.examen1evapsp.R
import com.example.examen1evapsp.data.entities.Groups
import com.example.examen1evapsp.databinding.ItemGroupsBinding
import com.example.examen1evapsp.ui.chat.ChatActivity

class GrupoAdapter(private val grupos: List<Groups>,private val context: Context) :
    RecyclerView.Adapter<GrupoAdapter.GrupoViewHolder>() {

    inner class GrupoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreTextView: TextView = itemView.findViewById(R.id.nombreTextView)
        private val descripcionTextView: TextView = itemView.findViewById(R.id.descripcionTextView)
        private var currentGrupo: Groups? = null


        fun bind(grupo: Groups        ) {
            nombreTextView.text = grupo.nombre
            descripcionTextView.text = grupo.descripcion
            itemView.rootView.setOnClickListener {
                (context as GroupsActivity)changeToChat(grupo)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GrupoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return GrupoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GrupoViewHolder, position: Int) {
        val grupo = grupos[position]
        holder.bind(grupo)
    }

    override fun getItemCount(): Int {
        return grupos.size
    }
}