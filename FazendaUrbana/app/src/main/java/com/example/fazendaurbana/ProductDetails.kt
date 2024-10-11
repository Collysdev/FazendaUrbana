package com.example.fazendaurbana

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class ProductDetails : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding
    var amount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#E0E0E0")

        val imgProduct: Int = intent.extras?.getInt("imgProduct") ?: 0
        val name: String? = intent.extras?.getString("name")
        val price: Double = intent.extras?.getString("price")?.toDoubleOrNull() ?: 0.0
        var newPrice: Double = price
        val decimalFormat = DecimalFormat.getCurrencyInstance()

        binding.imgProduct.setBackgroundResource(imgProduct)
        binding.txtProductName.text = name
        binding.txtPrice.text = decimalFormat.format(price)

        binding.btBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.btIncrease.setOnClickListener {
            if (amount < 3) {
                amount++
                newPrice += price
                binding.txtAmount.text = amount.toString()
                binding.txtPrice.text = decimalFormat.format(newPrice)
            }
        }

        binding.btToDecrease.setOnClickListener {
            if (amount > 1) {
                amount--
                newPrice -= price
                binding.txtAmount.text = amount.toString()
                binding.txtPrice.text = decimalFormat.format(newPrice)
            }
        }

        binding.btConfirm.setOnClickListener {
            val saucesAndDrinks = when {
                binding.btMustard.isChecked -> "Mustard"
                binding.btKetchup.isChecked -> "Ketchup"
                binding.btLemonSoda.isChecked -> "Lemon Soda"
                binding.btJuice.isChecked -> "Juice"
                else -> ""
            }

            val intent = Intent(this, Payment::class.java).apply {
                putExtra("name", name)
                putExtra("amount", amount)
                putExtra("total", newPrice)
                putExtra("saucesAndDrinks", saucesAndDrinks)
            }
            startActivity(intent)
        }
    }
}


