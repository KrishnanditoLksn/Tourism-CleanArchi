package app.culturedev.core.domain.usecase

import app.culturedev.core.data.Resource
import app.culturedev.core.domain.model.Tourism
import io.reactivex.rxjava3.core.Flowable

interface TourismUseCase {
    fun getAllTourism(): Flowable<Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flowable<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}