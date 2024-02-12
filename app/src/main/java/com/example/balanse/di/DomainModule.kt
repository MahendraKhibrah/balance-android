package com.example.balanse.di

import com.example.balanse.domain.repositories.AuthRepository
import com.example.balanse.domain.usecases.auth.GetFirstLoginStatusUseCase
import com.example.balanse.domain.usecases.auth.MarkFirstLoginStatusUseCase
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