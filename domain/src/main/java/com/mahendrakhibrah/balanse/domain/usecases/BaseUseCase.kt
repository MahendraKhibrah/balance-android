package com.mahendrakhibrah.balanse.domain.usecases

interface BaseUseCase<RES, REQ>{
    suspend fun execute(request: REQ): RES
}