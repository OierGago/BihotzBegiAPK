package com.example.examen1evapsp.ui.education

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examen1evapsp.data.entities.Video
import com.example.examen1evapsp.databinding.ActivityEducationBinding
import com.example.examen1evapsp.ui.groups.GroupsActivity
import com.example.examen1evapsp.ui.myPlaning.MyPlaningActivity
import com.example.examen1evapsp.ui.publicos.PublicosActivity

class EducationActivity : ComponentActivity() {
    private lateinit var videoAdapter: VideoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEducationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listaVideos = listOf(
            Video(1, "Video 1", "https://www.youtube.com/watch?v=video1"),
            Video(2, "Video 2", "https://www.youtube.com/watch?v=video2"),
            Video(3, "Video 3", "https://www.youtube.com/watch?v=video3")
        )

        // Configura el RecyclerView

       binding.recyclerView3.layoutManager = LinearLayoutManager(this)
        videoAdapter = VideoAdapter(listaVideos)
       binding.recyclerView3.adapter = videoAdapter
        // TODO realizar toda la logica pendiente...
        binding.textView13.setOnClickListener(){
            Log.i("login-groups", "butonLoginsetonclik")
            val intent = Intent(this, PublicosActivity::class.java).apply {
            }
            startActivity(intent)
            finish()

        }
        binding.textView12.setOnClickListener(){
            Log.i("login-groups", "grupos")
            val intent = Intent(this, GroupsActivity::class.java).apply {
            }
            startActivity(intent)
            finish()

        }
        binding.textView11.setOnClickListener(){
            Log.i("login-groups", "education")
            val intent = Intent(this, EducationActivity::class.java).apply {
            }
            startActivity(intent)
            finish()

        }
        binding.textView10.setOnClickListener(){
            Log.i("login-groups", "myplaning")
            val intent = Intent(this, MyPlaningActivity::class.java).apply {
            }
            startActivity(intent)
            finish()

        }


    }

}