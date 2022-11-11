package com.gabriel.data.beer.model

import com.gabriel.data.ingrediente.model.IngredientesData

data class BeerData(
    val id: Int? = null,
    val name: String? = null,
    val tagline: String? = null,
    val firstBrewed: String? = null,
    val description: String? = null,
    val imageUrl: String? = null,
    // porcentagem alcool
    val abv: Double? = null,
    val ingredients: List<IngredientesData>? = null,
    // dicas cervejeiros
    val brewersTips: String? = null
)
