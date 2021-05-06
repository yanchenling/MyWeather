package com.ycl.weather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.ycl.weather.logic.Repository
import com.ycl.weather.logic.model.Location

class WeatherViewModel : ViewModel() {


    private val locationLiveData = MutableLiveData<Location>()

    var locationLng = ""
    var locationLat = ""
    var placeName = ""

    val weatherLiveData = Transformations.switchMap(locationLiveData) { location ->
        Repository.refreshWeather(location.lng, location.lat)
    }

    fun refreshWeather(lng: String, lat: String) {
        locationLiveData.value = Location(lng, lat)
    }

}