package com.example.fazendaurbana

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.fazendaurbana.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#E0E0E0")

        binding.btProducts.setOnClickListener {
            // Lógica para navegar para a tela de produtos
        }

        binding.btSuppliers.setOnClickListener {
            // Lógica para navegar para a tela de fornecedores
        }

        binding.btAbout.setOnClickListener {
            // Lógica para navegar para a tela "Sobre"
        }
    }
}
