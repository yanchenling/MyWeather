package com.ycl.weather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class WeatherApplication : Application() {


    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        const val TOKEN = "pEKpALR0zMiTku0l"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}