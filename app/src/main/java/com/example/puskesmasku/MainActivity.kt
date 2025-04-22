package com.example.puskesmasku

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var inputNama: EditText
    private lateinit var inputPhone: EditText
    private lateinit var btnDaftar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        inputNama = findViewById(R.id.inputNama)
        inputPhone = findViewById(R.id.inputPhone)
        btnDaftar = findViewById(R.id.btnDaftar)

        btnDaftar.setOnClickListener {
            val nama = inputNama.text.toString().trim()
            val phoneNumber = inputPhone.text.toString().trim()

            when {
                nama.isEmpty() -> {
                    showToast("Nama tidak boleh kosong")
                }
                phoneNumber.isEmpty() -> {
                    showToast("Nomor HP tidak boleh kosong")
                }
                !phoneNumber.matches(Regex("^08[0-9]{8,11}$")) -> {
                    showToast("Format nomor HP tidak valid")
                }
                else -> {
                    showToast("Pendaftaran berhasil:\nNama: $nama\nNomor: $phoneNumber")
                    inputNama.text.clear()
                    inputPhone.text.clear()
                }
            }
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}