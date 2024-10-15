package com.example.fazendaurbana.listitems

import com.example.fazendaurbana.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.fazendaurbana.R


class Products {

    private val _productList = MutableStateFlow<MutableList<Product>>(mutableListOf())
    val productListFlow: StateFlow<MutableList<Product>> get() = _productList

    fun loadProducts(): Flow<MutableList<Product>> {
        val productList = mutableListOf(
            Product(
                imgProduct = R.drawable.abobrinha,
                name = "1 unidade de Abobrinha",
                price = "2.90"
            ),
            Product(
                imgProduct = R.drawable.abobora,
                name = "1kg de Abóbora",
                price = "18.99"
            ),
            Product(
                imgProduct = R.drawable.alface,
                name = "1 unidade de Alface",
                price = "3.90"
            ),
            Product(
                imgProduct = R.drawable.alho,
                name = "100g de Alho",
                price = "4.50"
            ),
            Product(
                imgProduct = R.drawable.batata,
                name = "1kg de Batata",
                price = "15.00"
            ),
            Product(
                imgProduct = R.drawable.batata_doce,
                name = "1kg de Batata Doce",
                price = "15.99"
            ),
            Product(
                imgProduct = R.drawable.beterraba,
                name = "500g de Beterraba",
                price = "5.50"
            ),
            Product(
                imgProduct = R.drawable.brocolis,
                name = "200g de Brócolis",
                price = "13.90"
            ),
            Product(
                imgProduct = R.drawable.cebola,
                name = "4 unidades de Cebola",
                price = "7.90"
            ),
            Product(
                imgProduct = R.drawable.cenoura,
                name = "500g de Cenoura",
                price = "10.90"
            ),
            Product(
                imgProduct = R.drawable.coentro,
                name = "1 unidade de Coentro",
                price = "3.90"
            ),
            Product(
                imgProduct = R.drawable.couve,
                name = "100g de Couve",
                price = "4.50"
            ),
            Product(
                imgProduct = R.drawable.espinafre,
                name = "100g de Espinafre",
                price = "9.99"
            ),
            Product(
                imgProduct = R.drawable.manjericao,
                name = "1 unidade de Manjericão",
                price = "3.90"
            ),
            Product(
                imgProduct = R.drawable.pimentao,
                name = "3 unidades de Pimentão",
                price = "3.90"
            ),
            Product(
                imgProduct = R.drawable.rabanete,
                name = "6 unidades de Rabanete",
                price = "12.50"
            ),
            Product(
                imgProduct = R.drawable.salsa,
                name = "1 unidade de Salsa",
                price = "2.90"
            ),
            Product(
                imgProduct = R.drawable.tomate,
                name = "6 unidades de Tomate",
                price = "12.90"
            )
        )
        _productList.value = productList
        return productListFlow
    }
}
