package com.dicoding.tourismapp.detail

import androidx.lifecycle.ViewModel
import app.culturedev.core.domain.model.Tourism
import app.culturedev.core.domain.usecase.TourismUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailTourismViewModel @Inject constructor(private val tourismRepository: TourismUseCase) :
    ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus: Boolean) =
        tourismRepository.setFavoriteTourism(tourism, newStatus)
}

