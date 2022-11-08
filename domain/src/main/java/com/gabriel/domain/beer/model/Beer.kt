package com.gabriel.domain.beer.model

import com.gabriel.domain.ingrediente.model.Ingredientes

data class Beer(
    val id: Int? = null,
    val name: String? = null,
    val tagline: String? = null,
    val firstBrewed: String? = null,
    val description: String? = null,
    // porcentagem alcool
    val abv: Double? = null,
    val ingredients: List<Ingredientes>? = null,
    // dicas cervejeiros
    val brewersTips: String? = null
)
