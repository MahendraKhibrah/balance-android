package com.example.balanse.data.repositories

import com.example.balanse.common.utils.Resource
import com.example.balanse.data.sharedPreferences.AuthSharedPreference
import com.example.balanse.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl  @Inject constructor(
    private val authSharedPref : AuthSharedPreference
) : AuthRepository {
    override suspend fun getFirstLoginStatus(): Resource<Boolean> {
        authSharedPref.getFirstOpenAppStatus().let {
            return Resource.Success(it)
        }
    }

    override suspend fun saveFirstLoginStatus(isFirstLogin : Boolean){
        authSharedPref.saveFirstOpenAppStatus(isFirstLogin)
    }
}