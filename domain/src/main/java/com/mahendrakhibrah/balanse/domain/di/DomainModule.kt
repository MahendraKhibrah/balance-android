package com.mahendrakhibrah.balanse.domain.di

import com.mahendrakhibrah.balanse.domain.repositories.AuthRepository
import com.mahendrakhibrah.balanse.domain.usecases.auth.GetFirstLoginStatusUseCase
import com.mahendrakhibrah.balanse.domain.usecases.auth.MarkFirstLoginStatusUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideGetFirstLoginStatusUseCase(repository: AuthRepository): GetFirstLoginStatusUseCase = GetFirstLoginStatusUseCase(repository)

    @Provides
    @Singleton
    fun provideMarkFirstLoginStatusUseCase(repository: AuthRepository): MarkFirstLoginStatusUseCase = MarkFirstLoginStatusUseCase(repository)
}