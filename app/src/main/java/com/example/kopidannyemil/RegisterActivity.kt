package com.example.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword =
            findViewById<EditText>(R.id.etConfirmPassword)

        val btnCreateAccount =
            findViewById<Button>(R.id.btnCreateAccount)

        btnCreateAccount.setOnClickListener {

            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if (name.isEmpty() || email.isEmpty() ||
                phone.isEmpty() || password.isEmpty() ||
                confirmPassword.isEmpty()
            ) {
                Toast.makeText(
                    this, "Semua kolom harus diisi",
                    Toast.LENGTH_SHORT
                ).show()

            } else if (!android.util.Patterns.EMAIL_ADDRESS
                    .matcher(email).matches()
            ) {
                etEmail.error = "Format email tidak valid"

            } else if (password.length < 6) {
                etPassword.error = "Password minimal 6 karakter"

            } else if (password != confirmPassword) {
                etConfirmPassword.error = "Password tidak sama"

            } else {

                val preferences = getSharedPreferences(
                    "KopiDanNyemil",
                    MODE_PRIVATE
                )

                preferences.edit()
                    .putString("name", name)
                    .putString("email", email)
                    .putString("phone", phone)
                    .putString("password", password)
                    .apply()

                Toast.makeText(
                    this,
                    "Pendaftaran berhasil! Silakan login.",
                    Toast.LENGTH_SHORT
                ).show()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
