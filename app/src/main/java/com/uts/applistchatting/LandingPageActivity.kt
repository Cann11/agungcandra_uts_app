package com.uts.applistchatting

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class LandingPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        val btnLogin = findViewById<Button>(R.id.btn_1)
        val btnRegister = findViewById<Button>(R.id.btn_2)

        btnLogin.setOnClickListener {
            // Arahkan ke LoginActivity (ubah sesuai kebutuhan)
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnRegister.setOnClickListener {
            // Arahkan ke RegisterActivity (ubah sesuai kebutuhan)
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}