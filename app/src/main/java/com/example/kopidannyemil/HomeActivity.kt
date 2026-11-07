package com.example.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.btnProfile).setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnPesan1).setOnClickListener {
            bukaAlamat("Kopi Susu Gula Aren", 18000)
        }

        findViewById<Button>(R.id.btnPesan2).setOnClickListener {
            bukaAlamat("Matcha Latte", 20000)
        }

        findViewById<Button>(R.id.btnPesan3).setOnClickListener {
            bukaAlamat("Cokelat Panas", 17000)
        }

        findViewById<Button>(R.id.btnPesan4).setOnClickListener {
            bukaAlamat("Roti Bakar Cokelat", 15000)
        }

        findViewById<Button>(R.id.btnPesan5).setOnClickListener {
            bukaAlamat("Kentang Goreng", 14000)
        }
    }

    private fun bukaAlamat(menu: String, price: Int) {
        val intent = Intent(this, AlamatActivity::class.java)
        intent.putExtra("menu", menu)
        intent.putExtra("price", price)
        startActivity(intent)
    }
}
