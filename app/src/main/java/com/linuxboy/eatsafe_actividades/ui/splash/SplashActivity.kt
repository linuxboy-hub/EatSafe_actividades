package com.linuxboy.eatsafe_actividades.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.linuxboy.eatsafe_actividades.R
import com.linuxboy.eatsafe_actividades.ui.login.LoginActivity
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val timer = Timer()
        timer.schedule(timerTask { goToLoginActivity() }, 2000)
    }

    fun goToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}