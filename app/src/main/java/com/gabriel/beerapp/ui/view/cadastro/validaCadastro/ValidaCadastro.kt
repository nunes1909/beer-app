package com.gabriel.beerapp.ui.view.cadastro.validaCadastro

import com.gabriel.strategy.resource.ResourceState


interface ValidaCadastro {
    fun validaCamposCadastro(email: String, senha: String, confirmaSenha: String):
            ResourceState<Boolean>
}
