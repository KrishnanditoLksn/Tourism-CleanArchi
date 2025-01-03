package com.dicoding.tourismapp

import android.app.Application
import com.dicoding.tourismapp.core.di.module.AppModule.useCaseModule
import com.dicoding.tourismapp.core.di.module.AppModule.viewModelModule
import com.dicoding.tourismapp.core.di.module.CoreModule.databaseModule
import com.dicoding.tourismapp.core.di.module.CoreModule.networkModule
import com.dicoding.tourismapp.core.di.module.CoreModule.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}