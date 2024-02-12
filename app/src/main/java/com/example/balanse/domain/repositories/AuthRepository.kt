package com.example.balanse.domain.repositories

import com.example.balanse.common.utils.Resource

interface AuthRepository {
    suspend fun getFirstLoginStatus(): Resource<Boolean>
    suspend fun saveFirstLoginStatus(isFirstLogin : Boolean)
}