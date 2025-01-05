package app.culturedev.core.domain.interactor

import app.culturedev.core.data.Resource
import app.culturedev.core.domain.model.Tourism
import app.culturedev.core.domain.repository.ITourismRepository
import app.culturedev.core.domain.usecase.TourismUseCase
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class TourismInteractor @Inject constructor(private val tourismRepository: ITourismRepository) :
    TourismUseCase {
    override fun getAllTourism(): Flowable<Resource<List<Tourism>>> {
        return tourismRepository.getAllTourism()
    }

    override fun getFavoriteTourism(): Flowable<List<Tourism>> {
        return tourismRepository.getFavoriteTourism()
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        return tourismRepository.setFavoriteTourism(tourism, state)
    }

}