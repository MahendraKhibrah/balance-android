package com.mahendrakhibrah.balanse.domain.usecases.auth

import com.mahendrakhibrah.balanse.domain.repositories.AuthRepository
import com.mahendrakhibrah.balanse.domain.usecases.BaseUseCase
import javax.inject.Inject

class MarkFirstLoginStatusUseCase @Inject constructor(
    private val repository: AuthRepository
) : BaseUseCase<Unit, Unit> {
    override suspend fun execute(request: Unit) {
        repository.saveFirstLoginStatus(false)
    }
}