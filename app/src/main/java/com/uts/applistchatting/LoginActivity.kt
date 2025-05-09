package com.uts.applistchatting

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerTextView: TextView
    private lateinit var backButton: ImageView

    private val TAG = "LoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Log.d(TAG, "onCreate: LoginActivity dimulai")

        emailEditText = findViewById(R.id.edt_email)
        confirmPasswordEditText = findViewById(R.id.edt_confirm_password)
        loginButton = findViewById(R.id.L_btn_1)
        registerTextView = findViewById(R.id.txt_register)
        backButton = findViewById(R.id.L_btn_back)

        val sharedPref: SharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        loginButton.setOnClickListener {
            val inputEmail = emailEditText.text.toString().trim()
            val inputPassword = confirmPasswordEditText.text.toString().trim()

            Log.d(TAG, "Tombol login diklik")

            val savedEmail = sharedPref.getString("email", null)
            val savedPassword = sharedPref.getString("password", null)

            if (inputEmail == savedEmail && inputPassword == savedPassword) {
                Log.d(TAG, "Login berhasil dengan email: $inputEmail")
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ListChattingActivity::class.java))
                finish()
            } else {
                Log.d(TAG, "Login gagal - Email atau password salah")
                Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

        registerTextView.setOnClickListener {
            Log.d(TAG, "Text register diklik")
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }

        backButton.setOnClickListener {
            Log.d(TAG, "Tombol kembali diklik")
            onBackPressed()
        }
    }
}
