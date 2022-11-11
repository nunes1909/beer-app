package com.gabriel.beerapp.ingrediente.model

data class IngredientesView(
    val malt: List<TipoView>? = null,
    val hops: List<TipoView>? = null,
)
