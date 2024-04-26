package com.example.examen1evapsp.ui.myPlaning

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AlertDialog
import com.example.examen1evapsp.R
import com.example.examen1evapsp.data.entities.Nota
import com.example.examen1evapsp.databinding.ActivityMyplaningBinding
import com.example.examen1evapsp.databinding.ActivityNotasBinding
import com.example.examen1evapsp.ui.education.EducationActivity
import com.example.examen1evapsp.ui.groups.GroupsActivity
import com.example.examen1evapsp.ui.notas.NotasActivity
import com.example.examen1evapsp.ui.publicos.PublicosActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MyPlaningActivity : ComponentActivity() {
    private var selectedYear = 0
    private var selectedMonth = 0
    private var selectedDay = 0
    private val notasList = mutableListOf<Nota>() // Lista para almacenar las notas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMyplaningBinding.inflate(layoutInflater)


        binding.button7.setOnClickListener() {
            Log.i("login-groups", "butonLoginsetonclik")
            val intent = Intent(this, NotasActivity::class.java).apply {
            }
            startActivity(intent)
            finish()
        }
        setContentView(binding.root)
        binding.button6.setOnClickListener(){
            mostrarDialogoAgregarNota()
        }
       binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val selectedDate = formatDate(year, month, dayOfMonth)
showDatePickerDialog()
           Toast.makeText(this, "Fecha seleccionada: $selectedDate", Toast.LENGTH_SHORT).show()
        }
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
    private fun mostrarDialogoAgregarNota() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog, null)
        val datePicker = dialogView.findViewById<DatePicker>(R.id.datePicker)
       val editTextNota = dialogView.findViewById<EditText>(R.id.editTextNota)
        val checkBoxNotificacion = dialogView.findViewById<CheckBox>(R.id.checkBoxNotificacion)

        val dialogBuilder = AlertDialog.Builder(ContextThemeWrapper(this,
            androidx.constraintlayout.widget.R.style.Base_ThemeOverlay_AppCompat_Dialog))
            .setTitle("Agregar Nota")
            .setView(dialogView)
            .setPositiveButton("Guardar") { _, _ ->
                val dia = datePicker.dayOfMonth
                val mes = datePicker.month
                val anio = datePicker.year
                val fechaSeleccionada = "$dia/${mes + 1}/$anio"
                val notaTexto = editTextNota.text.toString()
                val notificable = checkBoxNotificacion.isChecked
                val nota = Nota(fechaSeleccionada,  notaTexto,notificable)
                Toast.makeText(this, nota.toString(), Toast.LENGTH_SHORT).show()

                notasList.add(nota)
            }
            .setNegativeButton("Cancelar", null)

        val alertDialog = dialogBuilder.create()
        alertDialog.show()

    }
    private fun showDatePickerDialog() {
        // Obtiene la fecha actual
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Crea un DatePickerDialog
        val datePickerDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Procesa la fecha seleccionada
                selectedYear = year
                selectedMonth = monthOfYear
                selectedDay = dayOfMonth

                // Muestra la fecha seleccionada en un mensaje
                val selectedDateStr = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                Toast.makeText(this, "Fecha seleccionada: $selectedDateStr", Toast.LENGTH_SHORT).show()
            },
            year, month, day)

        // Muestra el DatePicke rDialog
        datePickerDialog.show()
    }
    private fun formatDate(year: Int, month: Int, dayOfMonth: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }
}