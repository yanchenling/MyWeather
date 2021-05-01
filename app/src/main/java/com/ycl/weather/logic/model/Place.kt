package com.ycl.weather.logic.model

import com.google.gson.annotations.SerializedName

data class Place(val name: String,val location: Location,@SerializedName("formatted_address") val address: String)