package app.culturedev.core.di

import app.culturedev.core.domain.interactor.TourismInteractor
import app.culturedev.core.domain.usecase.TourismUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun provideTourismUseCase(tourismInteractor: TourismInteractor): TourismUseCase
}