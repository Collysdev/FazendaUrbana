package com.example.fazendaurbana

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fazendaurbana.adapter.ProductAdapter
import com.example.fazendaurbana.listitems.Products
import com.example.fazendaurbana.model.Product
import com.example.fazendaurbana.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collectIndexed

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapter: ProductAdapter
    private val products = Products()
    private val productList: MutableList<Product> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#E0E0E0")

        // Configuração inicial do layout
        setupInitialLayout()

        // Lógica para coletar produtos
        CoroutineScope(Dispatchers.IO).launch {
            products.getProducts().collectIndexed { index, value ->
                for (p: Product in value) {
                    productList.add(p)
                }
                // Atualizar a UI na thread principal após a coleta
                runOnUiThread {
                    productAdapter.notifyDataSetChanged()
                }
            }
        }

        // Configurar botões de Login e Cadastro
        binding.btLogin.setOnClickListener {
            showLoginPopup()
        }

        binding.btRegister.setOnClickListener {
            showRegisterPopup()
        }
    }

    private fun setupInitialLayout() {
        // Aqui você pode configurar textos e imagens sobre a empresa
        binding.txtCompanyInfo.text = "Bem-vindo à Fazenda Urbana! Aqui você encontra os melhores produtos."
        binding.imgCompanyLogo.setImageResource(R.drawable.ic_logo) // Substitua por sua imagem
    }

    private fun showLoginPopup() {
        val emailInput = EditText(this).apply { hint = "Email" }
        val passwordInput = EditText(this).apply {
            hint = "Password"
            inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
        }

        AlertDialog.Builder(this)
            .setTitle("Login")
            .setMessage("Por favor, insira suas credenciais")
            .setView(emailInput)
            .setView(passwordInput)
            .setPositiveButton("Login") { _: DialogInterface, _: Int ->
                // Lógica de login aqui
                // Após login, redireciona para a DashboardActivity
                startActivity(Intent(this, DashboardActivity::class.java))
            }
            .setNegativeButton("Cancelar", null)
            .create()
            .show()
    }

    private fun showRegisterPopup() {
        val nameInput = EditText(this).apply { hint = "Nome" }
        val emailInput = EditText(this).apply { hint = "Email" }
        val passwordInput = EditText(this).apply {
            hint = "Password"
            inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
        }

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addView(nameInput)
            addView(emailInput)
            addView(passwordInput)
        }

        AlertDialog.Builder(this)
            .setTitle("Cadastro")
            .setMessage("Por favor, insira suas informações")
            .setView(layout)
            .setPositiveButton("Cadastrar") { _: DialogInterface, _: Int ->
                // Lógica de cadastro aqui
                // Após cadastro, redireciona para a DashboardActivity
                startActivity(Intent(this, DashboardActivity::class.java))
            }
            .setNegativeButton("Cancelar", null)
            .create()
            .show()
    }
}
