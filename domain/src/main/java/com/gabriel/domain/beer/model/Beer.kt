package com.gabriel.domain.beer.model

data class Beer(
    val id: Int? = null,
    val name: String? = null,
    val tagline: String? = null,
    val firstBrewed: String? = null,
    val description: String? = null,
    val imageUrl: String? = null,
    val abv: Double? = null,
    val foodPairing: List<String>? = null,
    val brewersTips: String? = null,
    val usuarioId: String? = null
)
