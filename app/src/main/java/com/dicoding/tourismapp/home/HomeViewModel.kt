package com.dicoding.tourismapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import app.culturedev.core.domain.usecase.TourismUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(tourismRepository: TourismUseCase) : ViewModel() {

    val tourism = tourismRepository.getAllTourism().toLiveData()

}

