package com.example.examen1evapsp.ui.author

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.examen1evapsp.data.entities.Author
import com.example.examen1evapsp.data.entities.Car
import com.example.examen1evapsp.data.remote.RemoteAuthorDataSource
import com.example.examen1evapsp.data.remote.RemoteReparationDataSource
import com.example.examen1evapsp.databinding.AuthorActivityBinding
import com.example.examen1evapsp.ui.book.BookActivity
import com.example.examen1evapsp.ui.car.CarActivity
import com.example.examen1evapsp.ui.cars.CarAdapter
import com.example.examen1evapsp.utils.Resource

class AuthorActivity : ComponentActivity() {
    private lateinit var authorAdapter: AuthorAdapter;

    private val authorRepository = RemoteAuthorDataSource();

    private val viewModel: AuthorViewModel by viewModels {
        AuthorViewModelFactory(
            authorRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = AuthorActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        authorAdapter = AuthorAdapter(::onAuthorListClickItem)
        binding.authorList.adapter = authorAdapter;
        // TODO realizar toda la logica pendiente...
        viewModel.authors.observe(this, Observer{
            Log.i("PruebasDia1", "ha ocurrido un cambio en la lista")
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()) {
                        Log.e("prueba", "esto que es")
                        authorAdapter.submitList(it.data)

                    }
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                Resource.Status.LOADING -> {
                    // de momento
                }
            }
        })
    }
    private fun onAuthorListClickItem(author: Author) {
        Log.i("examen", "onAuthorListClickItem")
        val intent = Intent(this, BookActivity::class.java).apply {
            putExtra("idAuthor", author.id)
        }
        startActivity(intent)
    }
}