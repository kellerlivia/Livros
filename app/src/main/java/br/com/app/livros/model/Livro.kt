package br.com.app.livros.model

import java.math.BigDecimal

data class Livro(
    val titulo: String,
    val autor: String,
    val preco: BigDecimal
)
