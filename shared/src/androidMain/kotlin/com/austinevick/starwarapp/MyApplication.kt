package com.austinevick.starwarapp

import android.app.Application
import com.austinevick.starwarapp.data.di.dataModule
import com.austinevick.starwarapp.domain.di.domainModule
import com.austinevick.starwarapp.ui.di.sharedViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(dataModule + domainModule + sharedViewModelModule())
        }
    }
}