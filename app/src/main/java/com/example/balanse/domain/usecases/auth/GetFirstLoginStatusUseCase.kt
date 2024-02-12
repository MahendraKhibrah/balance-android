package com.example.balanse.domain.usecases.auth

import com.example.balanse.common.utils.Resource
import com.example.balanse.domain.repositories.AuthRepository
import com.example.balanse.domain.usecases.BaseUseCase
import javax.inject.Inject

class GetFirstLoginStatusUseCase @Inject constructor(
    private val repository: AuthRepository
) : BaseUseCase<Resource<Boolean>, Unit> {
    override suspend fun execute(request: Unit): Resource<Boolean> {
        return repository.getFirstLoginStatus()
    }
}