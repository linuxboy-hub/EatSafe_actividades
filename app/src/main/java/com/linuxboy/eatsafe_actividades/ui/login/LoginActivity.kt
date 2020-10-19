package com.linuxboy.eatsafe_actividades.ui.login

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.linuxboy.eatsafe_actividades.R
import com.linuxboy.eatsafe_actividades.ui.bottom.BottomActivity
import com.linuxboy.eatsafe_actividades.ui.registro.RegistroActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val datosRecibidos = intent.extras
        val mail = datosRecibidos?.getString("correo")
        val contra = datosRecibidos?.getString("password")


        login_button.setOnClickListener {
            val correologin = mail_edit_text.text.toString()
            val pass = passwordlogin_edit_text.text.toString()

            if (correologin.isEmpty()) {
                Toast.makeText(this, getString(R.string.mail_vacio), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (pass.isEmpty()) {
                Toast.makeText(this, getString(R.string.password_vacio), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (correologin == mail) {
                if (pass == contra) {
                    val intent = Intent(this, BottomActivity::class.java)
                    intent.putExtra("correo", correologin)
                    intent.putExtra("password", pass)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)


                } else {
                    Toast.makeText(this, getString(R.string.incorrecta), Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            } else {
                Toast.makeText(this, getString(R.string.noexiste), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }

        registrar_login_button.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

    }
}