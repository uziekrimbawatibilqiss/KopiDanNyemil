package com.example.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvName = findViewById<TextView>(R.id.tvProfileName)
        val tvEmail = findViewById<TextView>(R.id.tvProfileEmail)
        val tvPhone = findViewById<TextView>(R.id.tvProfilePhone)
        val btnBackHome = findViewById<Button>(R.id.btnBackHome)

        val preferences = getSharedPreferences(
            "KopiDanNyemil",
            MODE_PRIVATE
        )

        val name = preferences.getString("name", "Nama Pengguna")
        val email = preferences.getString("email", "-")
        val phone = preferences.getString("phone", "-")

        tvName.text = name
        tvEmail.text = email
        tvPhone.text = phone

        btnBackHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
