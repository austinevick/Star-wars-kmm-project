package com.austinevick.starwarapp.ui.di

import androidx.room.RoomDatabase
import com.austinevick.starwarapp.ui.MainViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.dsl.module

private val viewModelModule = module {
   single { MainViewModel(get()) }
}

actual fun sharedViewModelModule(): Module = viewModelModule

object ProvideViewModule: KoinComponent{
    fun getFilmViewModel(): MainViewModel = get()
}