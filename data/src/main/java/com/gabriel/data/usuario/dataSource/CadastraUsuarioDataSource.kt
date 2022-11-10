package com.gabriel.data.usuario.dataSource

import com.gabriel.data.usuario.model.UsuarioData

interface CadastraUsuarioDataSource {
    suspend fun cadastraUsuario(usuario: UsuarioData): Boolean
}