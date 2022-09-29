package com.yoshikawa.orgs.model

import java.math.BigDecimal

data class Produto(
    val nome: String,
    val descricao: String,
    val questaoUm: String,
    val valor: BigDecimal

)
