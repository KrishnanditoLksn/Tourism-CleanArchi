package com.dicoding.tourismapp.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import com.dicoding.tourismapp.core.domain.usecase.TourismUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(tourismRepository: TourismUseCase) : ViewModel() {

    val favoriteTourism = tourismRepository.getFavoriteTourism().toLiveData()

}

