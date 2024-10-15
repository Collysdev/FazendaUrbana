package com.example.fazendaurbana

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DecimalFormat
import java.text.NumberFormat

class Payment : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        window.statusBarColor = Color.parseColor("#E0E0E0")

        val name: String? = intent.extras!!.getString("name")
        val amount: Int = intent.extras!!.getInt("amount")
        val total: Double = intent.extras!!.getDouble("total")
        val saucesAndDrinks: String? = intent.extras!!.getString("saucesAndDrinks")
        val decimalFormat: NumberFormat = DecimalFormat.getCurrencyInstance()

        binding.txtTotal.text = "$name \n Amount: $amount\n Sauces And Drinks: $saucesAndDrinks\n Total: ${decimalFormat.format(total)}"

        binding.btPay.setOnClickListener {
            if (binding.btCreditCard.isChecked) {
                val intent = Intent(this, ThankYouScreen::class.java)
                startActivity(intent)
                Toast.makeText(this, "Card Payment", Toast.LENGTH_SHORT).show()
            } else if (binding.btPix.isChecked) {
                binding.editPix.visibility = View.VISIBLE
                val pix: String = binding.editPix.text.toString()

                if (pix.isNotEmpty()) {
                    val intent = Intent(this, ThankYouScreen::class.java)
                    intent.putExtra("userPix", pix)
                    startActivity(intent)
                    Toast.makeText(this, "Pagamento com Pix", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Fill in the pix field", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
