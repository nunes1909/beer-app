package com.gabriel.beerapp.ui.validaFormulario

import com.gabriel.strategy.resource.ResourceState


interface ValidaFormularioStrategy {
    fun validaCamposFormulario(email: String, senha: String, confirmaSenha: String? = null):
            ResourceState<Boolean>
}
