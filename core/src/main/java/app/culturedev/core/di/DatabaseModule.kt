package app.culturedev.core.di

import android.content.Context
import androidx.room.Room
import app.culturedev.core.data.source.local.room.TourismDao
import app.culturedev.core.data.source.local.room.TourismDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TourismDatabase =
        Room.databaseBuilder(
            context,
            TourismDatabase::class.java, "Tourism_db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun providesDatabase(database: TourismDatabase): TourismDao = database.tourismDao()

}