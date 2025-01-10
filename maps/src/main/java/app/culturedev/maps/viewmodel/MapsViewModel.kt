package app.culturedev.maps.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import app.culturedev.core.domain.usecase.TourismUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourismUseCase = tourismUseCase.getAllTourism().toLiveData()
}