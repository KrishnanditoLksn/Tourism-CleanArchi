package app.culturedev.maps.di

import android.content.Context
import app.culturedev.core.di.MapsModuleDependencies
import app.culturedev.maps.MapsActivity
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [MapsModuleDependencies::class])
interface MapsComponent {
    fun inject(activity: MapsActivity)


    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(mapsModuleDependencies: MapsModuleDependencies): Builder
        fun build(): MapsComponent
    }
}