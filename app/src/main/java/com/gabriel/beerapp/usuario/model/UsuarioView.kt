package com.gabriel.beerapp.usuario.model

import java.io.Serializable

data class UsuarioView(
    val email: String? = null,
    val senha: String? = null
) : Serializable
