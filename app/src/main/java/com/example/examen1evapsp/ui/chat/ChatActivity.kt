package com.example.examen1evapsp.ui.chat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examen1evapsp.data.entities.Mensaje
import com.example.examen1evapsp.databinding.ActivityChatBinding
import com.example.examen1evapsp.databinding.ActivityGroupsBinding
import com.example.examen1evapsp.ui.groups.GrupoAdapter
import java.util.Date
import java.util.Locale

class ChatActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var mensajeAdapter: MensajeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mensajes = listOf(
            Mensaje(1, "Hola!", getCurrentDateTime(), 1, 1),
            Mensaje(2, "Cómo estás?", getCurrentDateTime(), 2, 1),
            Mensaje(3, "Todo bien por aquí.", getCurrentDateTime(), 1, 2),
            Mensaje(4, "Necesitamos reunirnos pronto.", getCurrentDateTime(), 3, 2),
            Mensaje(5, "Estoy ocupado ahora mismo.", getCurrentDateTime(), 2, 3),
            Mensaje(6, "Hablemos más tarde.", getCurrentDateTime(), 1, 3),
            Mensaje(7, "Ok, entendido.", getCurrentDateTime(), 3, 1),
            Mensaje(8, "Qué planes tienes para el fin de semana?", getCurrentDateTime(), 2, 2),
            Mensaje(9, "No lo sé aún, tú?", getCurrentDateTime(), 1, 4),
            Mensaje(10, "Probablemente salga con amigos.", getCurrentDateTime(), 3, 4)
        )

        recyclerView = binding.recyclerView5
        recyclerView.layoutManager = LinearLayoutManager(this)
        mensajeAdapter = MensajeAdapter(mensajes,this)
        recyclerView.adapter = mensajeAdapter


        binding.button.setOnClickListener {
            finish()
        }
    }



    fun getCurrentDateTime(): String {
        val sdf = java.text.SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return sdf.format(Date())
    }
}