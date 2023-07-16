package com.example.messagebox

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.messagebox.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

/*
        3 Called ID
        1. findById = bisa mendeteksi semua id pada widget di layout
        2. viewBinding = deteksi ID widget hanya pada layoutnya sendiri
        3. kotlin sintetik = sudah tidak support
     */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        withById()
        withViewBinding()
        snackBar()


    }

    private fun snackBar() {
        binding.btnSnackbar.setOnClickListener {
            val snackbar = Snackbar.make(
                findViewById(R.id.lay_message),
                "Email diarsipkan",
                Snackbar.LENGTH_SHORT
            )
            snackbar.setAction("Urungkan", View.OnClickListener {
                Toast.makeText(this@MainActivity,"Anda memilih YA", Toast.LENGTH_SHORT).show()
            })
            snackbar.show()
        }

    }

    private fun withViewBinding() {
        binding.btnAlert.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this@MainActivity)
            alertDialog.setTitle("YAKIN MAU HAPUS DATA?")
            alertDialog.setMessage("Ini adalah pesan alert")

            alertDialog.setPositiveButton("ya", DialogInterface.OnClickListener{dialog, which ->
                Toast.makeText(this, "Anda memilih ya", Toast.LENGTH_SHORT).show()
            })

            alertDialog.show()
        }
    }

    private fun withById(){
        val tombolToast = findViewById<Button>(R.id.btn_toast)
        tombolToast.setOnClickListener {
            Toast.makeText(this, "Ini toast dengan By Id", Toast.LENGTH_SHORT).show()
        }
    }


}