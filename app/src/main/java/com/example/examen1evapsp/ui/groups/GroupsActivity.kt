package com.example.examen1evapsp.ui.groups

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examen1evapsp.data.entities.Groups
import com.example.examen1evapsp.databinding.ActivityGroupsBinding
import com.example.examen1evapsp.ui.chat.ChatActivity
import com.example.examen1evapsp.ui.education.EducationActivity
import com.example.examen1evapsp.ui.myPlaning.MyPlaningActivity
import com.example.examen1evapsp.ui.publicos.PublicosActivity

class GroupsActivity : ComponentActivity() {
    private val viewModel:GroupsViewModel by viewModels {GroupsViewModelFactory()  }
    private lateinit var recyclerView: RecyclerView
    private lateinit var grupoAdapter: GrupoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGroupsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listaGrupos = listOf(
            Groups(1, "Grupo A","Grupo A",true),
            Groups(2, "Grupo B","Grupo B",false),
            Groups(3, "Grupo C","Grupo C",false)
        )

        // Configura el RecyclerView
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        grupoAdapter = GrupoAdapter(listaGrupos,this)
        recyclerView.adapter = grupoAdapter




        // TODO realizar toda la logica pendiente...
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

    infix fun changeToChat(group: Groups)  {
        Log.i("login-groups", "butonLoginsetonclik")
        val intent = Intent(this, ChatActivity::class.java).apply {
            intent.putExtra("id",group.id.toString())
            intent.putExtra("name", group.nombre)
        }
        startActivity(intent)
        finish()
    }
}


