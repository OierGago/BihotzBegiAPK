package com.example.examen1evapsp.ui.myPlaning

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.examen1evapsp.databinding.ActivityGroupsBinding
import com.example.examen1evapsp.databinding.ActivityMyplaningBinding
import com.example.examen1evapsp.ui.education.EducationActivity
import com.example.examen1evapsp.ui.groups.GroupsActivity
import com.example.examen1evapsp.ui.publicos.PublicosActivity

class MyPlaningActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMyplaningBinding.inflate(layoutInflater)
        setContentView(binding.root)

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