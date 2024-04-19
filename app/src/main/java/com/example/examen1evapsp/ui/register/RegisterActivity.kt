package com.example.examen1evapsp.ui.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.examen1evapsp.databinding.ActivityLoginBinding
import com.example.examen1evapsp.databinding.ActivityRegisterBinding
import com.example.examen1evapsp.ui.login.LoginActivity

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView4.setOnClickListener(){
            val intent = Intent(this, LoginActivity::class.java).apply {

            }
            startActivity(intent)
            finish()
        }
        binding.button4.setOnClickListener(){
            var  pass1= binding.editTextTextPassword3.text.toString()
            var  pass2= binding.editTextTextPassword4.text.toString()
            var username=binding.editTextText13.text.toString()
            if (pass1 == pass2){
                Log.i("login-groups", "butonLoginsetonclik")
                val intent = Intent(this, LoginActivity::class.java).apply {
                    putExtra("pass1",pass1)
                    putExtra("username",username)
                }
                startActivity(intent)
                finish()
            } else {
                binding.editTextTextPassword3.setText("");
                binding.editTextTextPassword4.setText("")
                val duration = Toast.LENGTH_SHORT
                val text="Las contraseñas no son iguales"
                val toast= Toast.makeText(this,text,duration)
                toast.show()
            }
        }
    }

}