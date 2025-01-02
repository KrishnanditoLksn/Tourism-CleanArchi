package com.dicoding.tourismapp.core.di.module

import com.dicoding.tourismapp.core.domain.interactor.TourismInteractor
import com.dicoding.tourismapp.core.domain.usecase.TourismUseCase
import com.dicoding.tourismapp.detail.DetailTourismViewModel
import com.dicoding.tourismapp.favorite.FavoriteViewModel
import com.dicoding.tourismapp.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {
    val useCaseModule = module {
        factory<TourismUseCase> {
            TourismInteractor(get())
        }
    }
    val viewModelModule = module {
        viewModel { HomeViewModel(get()) }
        viewModel { FavoriteViewModel(get()) }
        viewModel { DetailTourismViewModel(get()) }
    }
}