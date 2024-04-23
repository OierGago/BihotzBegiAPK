package com.example.examen1evapsp.ui.education

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen1evapsp.R
import com.example.examen1evapsp.data.entities.Video

class VideoAdapter(private val videos: List<Video>) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tituloTextView: TextView = itemView.findViewById(R.id.tituloTextView)
        private val enlaceTextView: TextView = itemView.findViewById(R.id.enlaceTextView)

        fun bind(video: Video) {
            tituloTextView.text = video.titulo
            enlaceTextView.text = video.enlace

            // Establecer un clic listener para abrir el enlace del video
            enlaceTextView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(video.enlace))
                it.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = videos[position]
        holder.bind(video)
    }

    override fun getItemCount(): Int {
        return videos.size
    }
}