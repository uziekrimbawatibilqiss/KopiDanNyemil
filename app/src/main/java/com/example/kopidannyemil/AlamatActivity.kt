package com.example.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AlamatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alamat)

        val tvMenu = findViewById<TextView>(R.id.tvSelectedMenu)
        val tvPrice = findViewById<TextView>(R.id.tvSelectedPrice)

        val etRecipient = findViewById<EditText>(R.id.etRecipient)
        val etPhone = findViewById<EditText>(R.id.etAddressPhone)
        val etAddress = findViewById<EditText>(R.id.etAddress)
        val etNote = findViewById<EditText>(R.id.etNote)

        val btnContinue = findViewById<Button>(R.id.btnContinue)

        val menu = intent.getStringExtra("menu") ?: "Menu"
        val price = intent.getIntExtra("price", 0)

        tvMenu.text = menu
        tvPrice.text = "Rp${String.format("%,d", price).replace(',', '.')}"

        btnContinue.setOnClickListener {

            val recipient = etRecipient.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val address = etAddress.text.toString().trim()
            val note = etNote.text.toString().trim()

            if (recipient.isEmpty() || phone.isEmpty() ||
                address.isEmpty()
            ) {
                Toast.makeText(
                    this,
                    "Nama, nomor HP, dan alamat wajib diisi",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                val intent = Intent(this, KonfirmasiActivity::class.java)

                intent.putExtra("menu", menu)
                intent.putExtra("price", price)
                intent.putExtra("recipient", recipient)
                intent.putExtra("phone", phone)
                intent.putExtra("address", address)
                intent.putExtra("note", note)

                startActivity(intent)
            }
        }
    }
}
