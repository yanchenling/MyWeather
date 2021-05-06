package com.ycl.weather.util

import android.util.Log

object LogUtil {

    private const val TAG="LogUtil"

    fun d(msg :String){
        Log.d(TAG,msg)
    }

    fun e(msg :String){
        Log.e(TAG,msg)
    }

}