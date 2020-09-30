package com.linuxboy.registrousuario

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

private var fechaNacimiento: String = ""
private var cal = Calendar.getInstance()

class MainActivity : AppCompatActivity() {

    companion object{
        private const val EMPTY = ""
        private const val SPACE = " "
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val format = "MM/dd/yyyy"
                val sdf = SimpleDateFormat(format, Locale.US)
                fechaNacimiento = sdf.format(cal.time).toString()
                fecha_text_view.text = fechaNacimiento
            }

        fecha_text_view.setOnClickListener {
            DatePickerDialog(
                this,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        registrar_button.setOnClickListener {

            val nombre = nombre_edit_text.text.toString()
            val correo = correo_edit_text.text.toString()
            val telefono = telefono_edit_text.text.toString()
            val password = password_edit_text.text.toString()
            val repassword = rep_passw_edit_text.text.toString()
            val genero = if (masculino_radio_button.isChecked) "Masculino" else "Femenino"
            var hobbies = EMPTY
            if (cine_checkbox.isChecked) hobbies += getString(R.string.cine) + SPACE
            if (deportes_checkbox.isChecked) hobbies += getString(R.string.deportes) + SPACE
            if (estudiar_checkbox.isChecked) hobbies += getString(R.string.estudiar) + SPACE
            if (comer_checkbox.isChecked) hobbies += getString(R.string.comer) + SPACE
            if (nadar_checkbox.isChecked) hobbies += getString(R.string.nadar) + SPACE
            if (musica_checkbox.isChecked) hobbies += getString(R.string.musica)

            val nacimiento = fechaNacimiento
            val ciudad = ciudad_spinner.selectedItem.toString()


            if (nombre.isEmpty()) {
                respuesta_text_view.text = "Ingrese el NOMBRE!"
                return@setOnClickListener
            }

            if (correo.isEmpty()) {
                respuesta_text_view.text = "Ingrese el CORREO!"
                return@setOnClickListener
            }

            if (telefono.isEmpty()) {
                respuesta_text_view.text = "Ingrese el TELEFONO!"
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                respuesta_text_view.text = "Ingrese PASSWORD!"
                return@setOnClickListener
            }

            if (repassword.isEmpty()) {
                respuesta_text_view.text = "Repita PASSWORD!"
                return@setOnClickListener
            }

            if (nacimiento.isEmpty()) {
                respuesta_text_view.text = "Ingrese FECHA DE NACIMIENTO!"
                return@setOnClickListener
            }

            if (ciudad == "Seleccione ciudad") {
                respuesta_text_view.text = "Ingrese CIUDAD DE NACIMIENTO!"
                return@setOnClickListener
            }

            if (password != repassword) {
                respuesta_text_view.text = "PASSWORDS NO COINCIDEN!"
                return@setOnClickListener
            }


            respuesta_text_view.text = getString(R.string.respuesta, nombre, correo, telefono, password, genero, hobbies, fechaNacimiento, ciudad)

        }

    }
}