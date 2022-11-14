package com.gabriel.beerapp.view.validaFormulario

import com.gabriel.strategy.resource.ResourceState


interface ValidaFormularioStrategy {
    fun validaCamposFormulario(
        nome: String? = null,
        email: String? = null,
        senha: String? = null,
        confirmaSenha: String? = null
    ): ResourceState<Boolean>
}
