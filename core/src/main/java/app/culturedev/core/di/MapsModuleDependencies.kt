package app.culturedev.core.di

import app.culturedev.core.domain.usecase.TourismUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface MapsModuleDependencies {
    fun tourismUseCase(): TourismUseCase
}