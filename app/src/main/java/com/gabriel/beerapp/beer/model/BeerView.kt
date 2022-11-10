package com.gabriel.beerapp.beer.model

import com.gabriel.beerapp.ingrediente.model.IngredientesView

data class BeerView(
    val id: Int? = null,
    val name: String? = null,
    val tagline: String? = null,
    val firstBrewed: String? = null,
    val description: String? = null,
    // porcentagem alcool
    val abv: Double? = null,
    val ingredients: List<IngredientesView>? = null,
    // dicas cervejeiros
    val brewersTips: String? = null
)
