package com.gabriel.data.beer.model

data class BeerData(
    val id: Int? = null,
    val name: String? = null,
    val tagline: String? = null,
    val firstBrewed: String? = null,
    val description: String? = null,
    val imageUrl: String? = null,
    // porcentagem alcool
    val abv: Double? = null,
    val foodPairing: List<String>? = null,
    // dicas cervejeiros
    val brewersTips: String? = null,
    val usuarioId: String? = null
)
