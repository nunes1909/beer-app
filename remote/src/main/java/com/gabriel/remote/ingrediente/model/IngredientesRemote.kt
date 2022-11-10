package com.gabriel.remote.ingrediente.model

import com.google.gson.annotations.SerializedName

data class IngredientesRemote(
    @SerializedName("malt")
    val malt: List<TipoRemote>? = null,

    @SerializedName("hops")
    val hops: List<TipoRemote>? = null,
)
