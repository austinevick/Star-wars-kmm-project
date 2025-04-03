package com.austinevick.starwarapp.theme

import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.austinevick.starwarapp.preferencesKey
import kotlinx.coroutines.launch

class ThemeViewModel(private val dataStore: DataStore<Preferences>): ViewModel() {

    private val _isDarkMode = mutableStateOf(false)
    val isDarkMode = _isDarkMode

    fun toggleDarkMode() {
        _isDarkMode.value = !_isDarkMode.value
        saveThemePreference(_isDarkMode.value)
    }

    init {
        loadThemePreference()
    }

    fun saveThemePreference(isDarkMode: Boolean) {
        viewModelScope.launch {
            dataStore.edit { preferences ->
                preferences[preferencesKey] = isDarkMode
            }
        }
    }
    fun loadThemePreference() {
        viewModelScope.launch {
            dataStore.data.collect { preferences ->
                _isDarkMode.value = preferences[preferencesKey] == true
            }
        }
    }

}