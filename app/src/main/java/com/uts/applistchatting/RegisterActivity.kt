package com.uts.applistchatting

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var fullNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var loginTextView: TextView
    private lateinit var backButton: ImageView

    private val TAG = "RegisterActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        Log.d(TAG, "onCreate: RegisterActivity dimulai")

        fullNameEditText = findViewById(R.id.edt_fullname)
        emailEditText = findViewById(R.id.edt_email)
        passwordEditText = findViewById(R.id.edt_password)
        confirmPasswordEditText = findViewById(R.id.edt_confirm_password)
        registerButton = findViewById(R.id.R_btn_1)
        loginTextView = findViewById(R.id.txt_login)
        backButton = findViewById(R.id.btn_back)

        val sharedPref: SharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        // Tombol Register
        registerButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val confirmPassword = confirmPasswordEditText.text.toString().trim()

            Log.d(TAG, "Tombol Register diklik")

            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Log.d(TAG, "Input tidak lengkap")
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Log.d(TAG, "Password dan konfirmasi tidak sama")
                Toast.makeText(this, "Password tidak cocok", Toast.LENGTH_SHORT).show()
            } else {
                val editor = sharedPref.edit()
                editor.putString("email", email)
                editor.putString("password", password)
                editor.putString("nama", fullName)
                editor.apply()

                Log.d(TAG, "Registrasi berhasil - email disimpan: $email")

                Toast.makeText(this, "Registrasi berhasil. Silakan login.", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

        // Klik "Login"
        loginTextView.setOnClickListener {
            Log.d(TAG, "Text login diklik")
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        // Tombol kembali
        backButton.setOnClickListener {
            Log.d(TAG, "Tombol kembali diklik")
            onBackPressed()
        }
    }
}
