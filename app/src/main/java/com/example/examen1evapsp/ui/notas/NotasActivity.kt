package com.example.examen1evapsp.ui.notas

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examen1evapsp.data.entities.Groups
import com.example.examen1evapsp.data.entities.Nota
import com.example.examen1evapsp.databinding.ActivityNotasBinding
import com.example.examen1evapsp.ui.education.EducationActivity
import com.example.examen1evapsp.ui.groups.GroupsActivity
import com.example.examen1evapsp.ui.groups.GrupoAdapter
import com.example.examen1evapsp.ui.myPlaning.MyPlaningActivity
import com.example.examen1evapsp.ui.publicos.PublicosActivity
import java.time.LocalDate
import java.time.LocalDateTime

class NotasActivity : ComponentActivity(){
    private lateinit var recyclerView: RecyclerView
    private lateinit var notasAdapter: NotasAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNotasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaNotas = listOf(
            Nota("02/02/24", "Texto de nota A",true),
            Nota("02/02/24", "Texto de nota B",false),
            Nota("02/02/24", "Texto de nota C",false)
        )

        // Configura el RecyclerView
        binding.recyclerView4.layoutManager = LinearLayoutManager(this)
        notasAdapter = NotasAdapter(listaNotas)
        binding.recyclerView4.adapter = notasAdapter



        binding.textView13.setOnClickListener(){
            Log.i("login-groups", "butonLoginsetonclik")
            val intent = Intent(this, PublicosActivity::class.java).apply {
            }
            startActivity(intent)
            finish()

        }
        binding.textView12.setOnClickListener(){
            Log.i("login-groups", "butonLoginsetonclik")
            val intent = Intent(this, GroupsActivity::class.java).apply {
            }
            startActivity(intent)
            finish()

        }
        binding.textView11.setOnClickListener(){
            Log.i("login-groups", "butonLoginsetonclik")
            val intent = Intent(this, EducationActivity::class.java).apply {
            }
            startActivity(intent)
            finish()

        }
        binding.textView10.setOnClickListener(){
            Log.i("login-groups", "butonLoginsetonclik")
            val intent = Intent(this, MyPlaningActivity::class.java).apply {
            }
            startActivity(intent)
            finish()

        }
    }
}