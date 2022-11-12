package com.gabriel.data.usuario.dataSource

import com.gabriel.data.usuario.model.UsuarioData
import com.gabriel.strategy.resource.ResourceState

interface AutenticaUsuarioDataSource {
    suspend fun autenticaUsuario(usuario: UsuarioData): ResourceState<Boolean>
}