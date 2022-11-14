package com.gabriel.beerapp.view.ui.conta.validaConta

import com.gabriel.beerapp.view.validaFormulario.ValidaFormularioStrategy
import com.gabriel.strategy.resource.ResourceState

class ValidaConta : ValidaFormularioStrategy {
    override fun validaCamposFormulario(
        nome: String?,
        email: String?,
        senha: String?,
        confirmaSenha: String?
    ): ResourceState<Boolean> {

        if (nome!!.isBlank()) {
            return ResourceState.Error(data = false, message = "Nome é obrigatório")
        }

        if (email!!.isBlank()) {
            return ResourceState.Error(data = false, message = "E-mail é obrigatório")
        }

        return ResourceState.Success(true)
    }
}