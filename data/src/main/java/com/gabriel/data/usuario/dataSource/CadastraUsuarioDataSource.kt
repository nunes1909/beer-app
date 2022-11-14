package com.gabriel.data.usuario.dataSource

import com.gabriel.data.usuario.model.UsuarioData
import com.gabriel.strategy.resource.ResourceState

interface CadastraUsuarioDataSource {
    suspend fun cadastraUsuario(usuario: UsuarioData): ResourceState<Boolean>
}