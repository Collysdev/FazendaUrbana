package com.example.fazendaurbana

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fazendaurbana.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            // Aqui você deve adicionar a lógica de cadastro
            finish()  // Fecha a RegisterActivity
        }
    }
}
