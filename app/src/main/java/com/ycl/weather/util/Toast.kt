package com.ycl.weather.util

import android.widget.Toast
import com.ycl.weather.WeatherApplication

fun String.showToast(duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(WeatherApplication.context,this,duration).show()
}
fun Int.showToast(duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(WeatherApplication.context,this,duration).show()
}
