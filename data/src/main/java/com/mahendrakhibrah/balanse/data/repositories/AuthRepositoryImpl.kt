package com.mahendrakhibrah.balanse.data.repositories

import com.mahendrakhibrah.balanse.common.utils.Resource
import com.mahendrakhibrah.balanse.data.sharedPreferences.AuthSharedPreference
import com.mahendrakhibrah.balanse.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl  @Inject constructor(
    private val authSharedPref : AuthSharedPreference
) : AuthRepository {
    override suspend fun getFirstLoginStatus(): com.mahendrakhibrah.balanse.common.utils.Resource<Boolean> {
        authSharedPref.getFirstOpenAppStatus().let {
            return com.mahendrakhibrah.balanse.common.utils.Resource.Success(it)
        }
    }

    override suspend fun saveFirstLoginStatus(isFirstLogin : Boolean){
        authSharedPref.saveFirstOpenAppStatus(isFirstLogin)
    }
}