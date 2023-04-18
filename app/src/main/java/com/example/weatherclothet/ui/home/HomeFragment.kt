package com.example.weatherclothet.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherclothet.R
import com.example.weatherclothet.data.models.response.WeatherData
import com.example.weatherclothet.data.models.response.WeatherResponse
import com.example.weatherclothet.data.services.apiManager.WeatherApi
import com.example.weatherclothet.databinding.FragmentHomeBinding
import com.example.weatherclothet.presenter.homePresenter.HomePresenter
import com.example.weatherclothet.presenter.homePresenter.IHomeContract
import com.example.weatherclothet.ui.base.BaseFragment
import com.example.weatherclothet.util.SharedPrefsUtils
import com.example.weatherclothet.util.WeatherUtils.getDayNameFromTimestamp
import com.example.weatherclothet.util.WeatherUtils.updateClothImage
import com.example.weatherclothet.util.WeatherUtils.updateWeatherInfo
import com.example.weatherclothet.util.showToast
import com.google.android.material.chip.Chip
import java.io.IOException

class HomeFragment : BaseFragment<FragmentHomeBinding, HomePresenter>(), IHomeContract.IView {
    override val bindingInflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate
    override val presenter: HomePresenter
        get() = HomePresenter(this, WeatherApi())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPrefs()
        presenter.fetchWeatherData("egypt")
        setupNextSuggestClickListener()
    }

    private fun initPrefs() = SharedPrefsUtils.initPrefUtil(requireContext())

    override fun showWeatherData(weatherResponse: WeatherResponse) {
        updateChipGroup(weatherResponse.list)
    }

    override fun showError(error: IOException) {
        Log.i("t", error.toString())
    }

    private fun setupNextSuggestClickListener() {
        binding.nextSuggest.setOnClickListener {
            val currentTemperature =
                binding.weatherDegree.text?.toString()?.replace("°C", "")?.toDoubleOrNull()
            if (currentTemperature != null) {
                updateClothImage(binding, currentTemperature, SharedPrefsUtils)
            }
        }
    }

    private fun updateChipGroup(days: List<WeatherData>) {
        val chipGroup = binding.chipGroup
        chipGroup.removeAllViews()
        chipGroup.isSingleSelection = true

        days.forEachIndexed { index, day ->
            createChip(index, day).let { chip ->
                chipGroup.addView(chip)
            }
        }
    }

    private fun createChip(index: Int, day: WeatherData): Chip {
        return Chip(context).apply {
            text = getDayNameFromTimestamp(day.timestamp)
            isCheckable = true
            setChipBackgroundColorResource(R.color.chip_background_color)
            isChecked = index == 0
            if (index == 0) {
                updateWeatherInfo(context, day, binding.weatherDegree, binding.WeatherIcon)
            }
            setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    updateWeatherInfo(context, day, binding.weatherDegree, binding.WeatherIcon)
                    updateClothImage(binding, day.temperature.day, SharedPrefsUtils)
                }
            }
        }
    }
}