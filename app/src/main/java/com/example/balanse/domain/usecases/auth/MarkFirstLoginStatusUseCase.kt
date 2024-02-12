package com.example.balanse.domain.usecases.auth

import com.example.balanse.domain.repositories.AuthRepository
import com.example.balanse.domain.usecases.BaseUseCase
import javax.inject.Inject

class MarkFirstLoginStatusUseCase @Inject constructor(
    private val repository: AuthRepository
) : BaseUseCase<Unit, Unit> {
    override suspend fun execute(request: Unit) {
        repository.saveFirstLoginStatus(false)
    }
}