package com.mahendrakhibrah.balanse.domain.usecases.auth

import com.mahendrakhibrah.balanse.common.utils.Resource
import com.mahendrakhibrah.balanse.domain.repositories.AuthRepository
import com.mahendrakhibrah.balanse.domain.usecases.BaseUseCase
import javax.inject.Inject


class GetFirstLoginStatusUseCase @Inject constructor(
    private val repository: AuthRepository
) : BaseUseCase<Resource<Boolean>, Unit> {
    override suspend fun execute(request: Unit): com.mahendrakhibrah.balanse.common.utils.Resource<Boolean> {
        return repository.getFirstLoginStatus()
    }
}