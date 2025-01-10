package app.culturedev.core.di

import app.culturedev.core.data.TourismRepository
import app.culturedev.core.data.source.local.LocalDataSource
import app.culturedev.core.data.source.remote.RemoteDataSource
import app.culturedev.core.domain.repository.ITourismRepository
import app.culturedev.core.utils.AppExecutors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(
        remote: RemoteDataSource,
        local: LocalDataSource,
        executors: AppExecutors
    ): ITourismRepository = TourismRepository(remote, local, executors)
}