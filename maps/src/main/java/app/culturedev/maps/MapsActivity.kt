package app.culturedev.maps

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import app.culturedev.core.data.Resource
import app.culturedev.core.di.MapsModuleDependencies
import app.culturedev.maps.databinding.ActivityMapsBinding
import app.culturedev.maps.di.DaggerMapsComponent
import app.culturedev.maps.viewmodel.MapsViewModel
import app.culturedev.maps.viewmodel.ViewModelFactory
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject


class MapsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory

    private val mapsViewModel: MapsViewModel by viewModels {
        factory
    }
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerMapsComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    MapsModuleDependencies::class.java
                )
            ).build()
            .inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getTourism()
    }

    @SuppressLint("SetTextI18n")
    private fun getTourism() {
        mapsViewModel.tourismUseCase.observe(this) {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE

                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvMaps.text = "Disini ${it.data?.get(0)?.name}"
                    }

                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvError.visibility = View.VISIBLE
                        binding.tvError.text = it.message
                    }
                }
            }
        }
    }
}