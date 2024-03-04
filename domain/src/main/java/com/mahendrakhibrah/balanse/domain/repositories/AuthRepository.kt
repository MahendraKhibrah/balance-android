package com.mahendrakhibrah.balanse.domain.repositories

import com.mahendrakhibrah.balanse.common.utils.Resource

interface AuthRepository {
    suspend fun getFirstLoginStatus(): Resource<Boolean>
    suspend fun saveFirstLoginStatus(isFirstLogin : Boolean)
}