package com.linuxboy.eatsafe_actividades.ui.registro

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.linuxboy.eatsafe_actividades.R
import com.linuxboy.eatsafe_actividades.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_registro.*
import java.text.SimpleDateFormat
import java.util.*

private var fechaNacimiento: String = ""
private var cal = Calendar.getInstance()

class RegistroActivity : AppCompatActivity() {
/*
    companion object{
        private const val EMPTY = ""
        private const val SPACE = " "
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

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
            val nacimiento = fechaNacimiento


            if (nombre.isEmpty()) {
                //Toast.makeText(this, "Ingrese el NOMBRE!",  Toast.LENGTH_SHORT).show()
                Toast.makeText(this, getString(R.string.nombre_vacio), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (correo.isEmpty()) {
                Toast.makeText(this, getString(R.string.mail_vacio), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (telefono.isEmpty()) {
                Toast.makeText(this, getString(R.string.telefono_vacio), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                Toast.makeText(this, getString(R.string.password_vacio), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (repassword.isEmpty()) {
                Toast.makeText(this, getString(R.string.repassword_vacio), Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            if (nacimiento.isEmpty()) {
                Toast.makeText(this, getString(R.string.fecha_vacio), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.length < 6) {
                Toast.makeText(this, getString(R.string.min_password), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password != repassword) {
                Toast.makeText(this, getString(R.string.nomatch_password), Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("correo", correo)
            intent.putExtra("password", password)
            Toast.makeText(this, getString(R.string.exitoso), Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()

        }

    }
}