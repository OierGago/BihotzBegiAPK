package com.example.examen1evapsp.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.examen1evapsp.databinding.ActivityLoginBinding
import com.example.examen1evapsp.ui.groups.GroupsActivity
import com.example.examen1evapsp.ui.register.RegisterActivity

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (intent.getStringExtra("username").toString().isNotEmpty()){
            binding.editTextText.setText(intent.getStringExtra("username"))
            binding.editTextTextPassword.setText(intent.getStringExtra("pass1"))
        }
        // TODO realizar toda la logica pendiente...
        binding.button2.setOnClickListener {
            Log.i("login-registro", "butonLoginsetonclik")
            val intent = Intent(this, RegisterActivity::class.java).apply {
            }
            startActivity(intent)
        }
        binding.buttonLogin.setOnClickListener {
            Log.i("login-groups", "butonLoginsetonclik")
            val intent = Intent(this, GroupsActivity::class.java).apply {
            }
            startActivity(intent)
        }
    }

}