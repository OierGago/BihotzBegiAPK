package com.example.examen1evapsp.ui.pantallaCarga

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.examen1evapsp.databinding.ActivityPantallacargaBinding
import com.example.examen1evapsp.databinding.ActivityRegisterBinding
import com.example.examen1evapsp.ui.login.LoginActivity
import com.example.examen1evapsp.ui.register.RegisterActivity

class PantallaCargaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPantallacargaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO realizar toda la logica pendiente...
        binding.root.setOnClickListener(){
            Log.i("Pantalla-login", "butonLoginsetonclik")
            val intent = Intent(this, LoginActivity::class.java).apply {
            }
            startActivity(intent)
        }
    }

}