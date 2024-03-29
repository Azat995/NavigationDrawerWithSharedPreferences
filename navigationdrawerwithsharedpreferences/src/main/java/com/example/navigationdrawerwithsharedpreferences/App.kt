package com.example.navigationdrawerwithsharedpreferences

import android.app.Application
import android.content.Context

class App : Application() {

    companion object {
        lateinit var instance: App
            private set

        fun applicationContext(): Context {
            return instance.applicationContext
        }
    }

    init {
        instance = this
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}