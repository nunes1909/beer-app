package com.gabriel.data.usuario.mapper

import com.gabriel.data.usuario.model.UsuarioData
import com.gabriel.data.util.base.DataMapper
import com.gabriel.domain.usuario.model.Usuario

class UsuarioDataMapper : DataMapper<UsuarioData, Usuario> {
    override fun mapToDomain(type: UsuarioData): Usuario {
        return Usuario(
            email = type.email,
            senha = type.email
        )
    }

    override fun mapToData(type: Usuario): UsuarioData {
        return UsuarioData(
            email = type.email,
            senha = type.email
        )
    }
}
