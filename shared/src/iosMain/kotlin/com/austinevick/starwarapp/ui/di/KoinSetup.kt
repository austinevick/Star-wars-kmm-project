package com.austinevick.starwarapp.ui.di

import com.austinevick.starwarapp.data.di.dataModule
import com.austinevick.starwarapp.domain.di.domainModule
import org.koin.core.context.startKoin

fun initKoin (){
    startKoin {
        modules(dataModule + domainModule + sharedViewModelModule())
    }
}