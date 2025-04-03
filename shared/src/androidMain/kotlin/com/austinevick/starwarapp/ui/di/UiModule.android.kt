package com.austinevick.starwarapp.ui.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.austinevick.starwarapp.createDataStore
import com.austinevick.starwarapp.theme.ThemeViewModel
import com.austinevick.starwarapp.ui.MainViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


fun provideDataStore(context: Context): DataStore<Preferences> {
    return createDataStore(context)
}

val viewModelModule = module {
    viewModel { MainViewModel(get(),get()) }
    viewModel { ThemeViewModel(get()) }
    single { provideDataStore(get()) }
}

actual fun sharedViewModelModule(): Module = viewModelModule

