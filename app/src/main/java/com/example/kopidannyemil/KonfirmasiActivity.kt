package com.example.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class KonfirmasiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konfirmasi)

        val tvMenu = findViewById<TextView>(R.id.tvConfirmMenu)
        val tvPrice = findViewById<TextView>(R.id.tvConfirmPrice)
        val tvRecipient = findViewById<TextView>(R.id.tvConfirmRecipient)
        val tvPhone = findViewById<TextView>(R.id.tvConfirmPhone)
        val tvAddress = findViewById<TextView>(R.id.tvConfirmAddress)
        val tvNote = findViewById<TextView>(R.id.tvConfirmNote)

        val btnConfirm = findViewById<Button>(R.id.btnConfirmOrder)
        val btnBackHome = findViewById<Button>(R.id.btnBackHome)

        val menu = intent.getStringExtra("menu") ?: "-"
        val price = intent.getIntExtra("price", 0)
        val recipient = intent.getStringExtra("recipient") ?: "-"
        val phone = intent.getStringExtra("phone") ?: "-"
        val address = intent.getStringExtra("address") ?: "-"
        val note = intent.getStringExtra("note") ?: "-"

        tvMenu.text = menu
        tvPrice.text = "Rp${String.format("%,d", price).replace(',', '.')}"
        tvRecipient.text = "Nama Penerima: $recipient"
        tvPhone.text = "Nomor HP: $phone"
        tvAddress.text = "Alamat: $address"
        tvNote.text = "Catatan: ${if (note.isEmpty()) "-" else note}"

        btnConfirm.setOnClickListener {
            Toast.makeText(
                this,
                "Pesanan berhasil dikonfirmasi!",
                Toast.LENGTH_LONG
            ).show()

            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

        btnBackHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}
