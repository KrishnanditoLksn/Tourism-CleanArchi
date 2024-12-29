package com.dicoding.tourismapp.home

import androidx.lifecycle.ViewModel
import com.dicoding.tourismapp.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismRepository: TourismUseCase) : ViewModel() {

    val tourism = tourismRepository.getAllTourism()

}

