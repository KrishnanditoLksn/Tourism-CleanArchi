package app.culturedev.core.data.source.local

import app.culturedev.core.data.source.local.entity.TourismEntity
import app.culturedev.core.data.source.local.room.TourismDao
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val tourismDao: TourismDao) {
    fun getAllTourism(): Flowable<List<TourismEntity>> = tourismDao.getAllTourism()

    fun getFavoriteTourism(): Flowable<List<TourismEntity>> = tourismDao.getFavoriteTourism()

    fun insertTourism(tourismList: List<TourismEntity>) = tourismDao.insertTourism(tourismList)

    fun setFavoriteTourism(tourism: TourismEntity, newState: Boolean) {
        tourism.isFavorite = newState
        tourismDao.updateFavoriteTourism(tourism)
    }
}