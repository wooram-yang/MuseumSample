package com.moreflow.museumsample.di

import com.moreflow.museumsample.repository.MuseumRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun museumRepository(): MuseumRepository = MuseumRepository()
}