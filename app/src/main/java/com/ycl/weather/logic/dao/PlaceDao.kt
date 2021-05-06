package com.ycl.weather.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.ycl.weather.WeatherApplication
import com.ycl.weather.logic.model.Place

object PlaceDao {

    fun savePlace(place: Place) {
        sharedPreference().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavedPlace(): Place {
        val placeJson = sharedPreference().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun isPlaceSaved() = sharedPreference().contains("place")

    private fun sharedPreference() = WeatherApplication.context.getSharedPreferences(
        "my_weather",
        Context.MODE_PRIVATE
    )


}