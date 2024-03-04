package com.mahendrakhibrah.balanse.data.di

import android.content.Context
import com.mahendrakhibrah.balanse.data.repositories.AuthRepositoryImpl
import com.mahendrakhibrah.balanse.data.sharedPreferences.AuthSharedPreference
import com.mahendrakhibrah.balanse.domain.repositories.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideAuthSharedPreference(@ApplicationContext appContext : Context) : AuthSharedPreference =
        AuthSharedPreference(appContext)

    @Provides
    @Singleton
    fun bindAuthRepository(sharedPreference : AuthSharedPreference) : AuthRepository =
        AuthRepositoryImpl(sharedPreference)
}