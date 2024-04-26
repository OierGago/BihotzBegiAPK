package com.example.examen1evapsp.ui.publicos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examen1evapsp.R
import com.example.examen1evapsp.data.entities.Groups
import com.example.examen1evapsp.data.entities.GrupoPublico
import com.example.examen1evapsp.databinding.ActivityGroupsBinding
import com.example.examen1evapsp.databinding.ActivityPublicosBinding
import com.example.examen1evapsp.ui.chat.ChatActivity
import com.example.examen1evapsp.ui.education.EducationActivity
import com.example.examen1evapsp.ui.groups.GroupsActivity
import com.example.examen1evapsp.ui.groups.GrupoAdapter
import com.example.examen1evapsp.ui.myPlaning.MyPlaningActivity

class PublicosActivity : ComponentActivity(){
    private lateinit var grupoAdapter: GrupoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPublicosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtén la lista de grupos públicos (puedes obtenerla de donde sea que la tengas)
        val listaGrupos = listOf(
            Groups(1, "Grupo A","Grupo A",true),
            Groups(2, "Grupo B","Grupo B",false),
            Groups(3, "Grupo C","Grupo C",false)
        )

        // Configura el RecyclerView
        binding.recyclerView2.layoutManager = LinearLayoutManager(this)
        grupoAdapter = GrupoAdapter(listaGrupos,this)
        binding.recyclerView2.adapter = grupoAdapter



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
    infix fun changeToChat(group: Groups)  {
        Log.i("login-groups", "butonLoginsetonclik")
        val intent = Intent(this, ChatActivity::class.java).apply {
            intent.putExtra("id",group.id.toString())
            intent.putExtra("name", group.nombre)
        }
        startActivity(intent)
    }

}