package com.example.fazendaurbana

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fazendaurbana.databinding.ActivityAboutUsBinding

class AboutUsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Aqui você pode configurar a lógica se necessário, por exemplo, clicar em botões
    }
}
