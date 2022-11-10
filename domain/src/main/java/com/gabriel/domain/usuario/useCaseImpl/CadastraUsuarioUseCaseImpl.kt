package com.gabriel.domain.usuario.useCaseImpl

import com.gabriel.domain.usuario.model.Usuario
import com.gabriel.domain.usuario.repository.CadastraUsuarioRepository
import com.gabriel.domain.usuario.useCase.CadastraUsuarioUseCase

class CadastraUsuarioUseCaseImpl(private val repository: CadastraUsuarioRepository) :
    CadastraUsuarioUseCase {
    override suspend fun cadastraUsuario(usuario: Usuario): Boolean {
        return repository.cadastraUsuario(usuario)
    }
}
