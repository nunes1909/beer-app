package com.gabriel.beerapp.view.ui.login.validaLogin

import com.gabriel.beerapp.view.validaFormulario.ValidaFormularioStrategy
import com.gabriel.strategy.resource.ResourceState

class ValidaLogin : ValidaFormularioStrategy {
    override fun validaCamposFormulario(
        nome: String?,
        email: String?,
        senha: String?,
        confirmaSenha: String?
    ): ResourceState<Boolean> {

        if (email!!.isBlank()) {
            return ResourceState.Error(data = false, message = "E-mail é necessário")
        }

        if (senha!!.isBlank()) {
            return ResourceState.Error(data = false, message = "Senha é necessária")
        }

        return ResourceState.Success(true)
    }
}