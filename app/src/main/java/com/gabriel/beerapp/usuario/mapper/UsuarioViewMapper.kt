package com.gabriel.beerapp.usuario.mapper

import com.gabriel.beerapp.usuario.model.UsuarioView
import com.gabriel.beerapp.util.base.ViewMapper
import com.gabriel.domain.usuario.model.Usuario

class UsuarioViewMapper : ViewMapper<UsuarioView, Usuario> {
    override fun mapToDomain(type: UsuarioView): Usuario {
        return Usuario(
            nome = type.nome,
            email = type.email,
            senha = type.senha
        )
    }

    override fun mapToView(type: Usuario): UsuarioView {
        return UsuarioView(
            nome = type.nome,
            email = type.email,
            senha = type.senha
        )
    }
}
