package com.gabriel.remote.beer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BeerRemote(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("tagline")
    val tagline: String? = null,

    @SerializedName("first_brewed")
    val firstBrewed: String? = null,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("image_url")
    val imageUrl: String? = null,

    // porcentagem alcool
    @SerializedName("abv")
    val abv: Double? = null,

    @SerializedName("food_pairing")
    val foodPairing: List<String>? = null,

    // dicas cervejeiros
    @SerializedName("brewers_tips")
    val brewersTips: String? = null,

    @Expose(serialize = false)
    var usuarioId: String? = null
)
