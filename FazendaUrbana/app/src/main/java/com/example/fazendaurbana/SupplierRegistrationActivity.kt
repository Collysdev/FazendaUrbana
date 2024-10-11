package com.example.fazendaurbana

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fazendaurbana.databinding.ActivitySupplierRegistrationBinding

class SupplierRegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySupplierRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySupplierRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val phone = binding.etPhone.text.toString()
            val sector = binding.etSector.text.toString()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || sector.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            } else {
                // Aqui você pode adicionar a lógica para salvar os dados dos fornecedores
                Toast.makeText(this, "Fornecedor cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                finish()  // Fecha a SupplierRegistrationActivity
            }
        }
    }
}
