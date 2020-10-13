package com.linuxboy.eatsafe_actividades.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.linuxboy.eatsafe_actividades.R
import com.linuxboy.eatsafe_actividades.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datosRecibidos = intent.extras
        val mail = datosRecibidos?.getString("correo")

        Toast.makeText(this, getString(R.string.bienvenido), Toast.LENGTH_SHORT).show()

        main_text_view.text = getString(R.string.main, mail)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.cerrar_sesion -> {
                val datosRecibidos = intent.extras
                val mail = datosRecibidos?.getString("correo")
                val pass = datosRecibidos?.getString("password")
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("correo", mail)
                intent.putExtra("password", pass)
                startActivity(intent)
                finish()

            }
        }
        return super.onOptionsItemSelected(item)
    }

}