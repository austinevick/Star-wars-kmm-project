package com.austinevick.starwarapp

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import com.austinevick.starwarapp.data.local.DATA_STORE_FILE_NAME
import com.austinevick.starwarapp.data.local.createDataStore

fun createDataStore(context: Context): DataStore<Preferences> {
    return createDataStore {
        context.filesDir.resolve(DATA_STORE_FILE_NAME).absolutePath
    }
}
val preferencesKey = booleanPreferencesKey("IS_DARK_MODE")