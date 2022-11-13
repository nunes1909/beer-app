package com.gabriel.beerapp.ui.view.login.validaLogin

import com.gabriel.beerapp.ui.validaFormulario.ValidaFormularioStrategy
import com.gabriel.strategy.resource.ResourceState

class ValidaLogin : ValidaFormularioStrategy {
    override fun validaCamposFormulario(email: String, senha: String, confirmaSenha: String?):
            ResourceState<Boolean> {

        if (email.isBlank()) {
            return ResourceState.Error(data = false, message = "E-mail é necessário")
        }

        if (senha.isBlank()) {
            return ResourceState.Error(data = false, message = "Senha é necessária")
        }

        return ResourceState.Success(true)
    }
}