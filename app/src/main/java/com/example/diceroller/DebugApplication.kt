package com.example.diceroller

import android.app.Application
import timber.log.Timber

class DebugApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}