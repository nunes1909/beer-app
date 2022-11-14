package com.gabriel.domain.usuario.useCaseImpl

import com.gabriel.domain.usuario.model.Usuario
import com.gabriel.domain.usuario.repository.UpdateProfileRepository
import com.gabriel.domain.usuario.useCase.UpdateProfileUseCase

class UpdateProfileUseCaseImpl(private val repository: UpdateProfileRepository) :
    UpdateProfileUseCase {
    override suspend fun updateProfile(usuario: Usuario) {
        return repository.updateProfile(usuario)
    }
}