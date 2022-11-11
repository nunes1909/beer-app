package com.gabriel.beerapp.ui.view.cadastro.validaCadastro

import com.gabriel.domain.util.resource.ResourceState

class ValidaCadastroImpl : ValidaCadastro {
    override fun validaCamposCadastro(email: String, senha: String, confirmaSenha: String):
            ResourceState<Boolean> {

        if (email.isBlank()) {
            return ResourceState.Error(data = false, message = "E-mail é necessário")
        }

        if (senha.isBlank()) {
            return ResourceState.Error(data = false, message = "Senha é necessária")
        }

        if (senha != confirmaSenha) {
            return ResourceState.Error(data = false, message = "Senhas diferentes")
        }

        return ResourceState.Success(true)
    }
}
