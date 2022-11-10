package com.gabriel.remote.usuario.mapper

import com.gabriel.data.usuario.model.UsuarioData
import com.gabriel.remote.usuario.model.UsuarioRemote
import com.gabriel.remote.util.base.RemoteMapper

class UsuarioRemoteMapper : RemoteMapper<UsuarioRemote, UsuarioData> {
    override fun mapToData(type: UsuarioRemote): UsuarioData {
        return UsuarioData(
            email = type.email,
            senha = type.email
        )
    }

    override fun mapToRemote(type: UsuarioData): UsuarioRemote {
        return UsuarioRemote(
            email = type.email,
            senha = type.email
        )
    }
}
