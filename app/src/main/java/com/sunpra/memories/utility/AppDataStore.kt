package com.sunpra.memories.utility

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// At the top level of your kotlin file:
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "app_data_store")

class AppDataStore(context: Context) {

    private val dataStore = context.dataStore

    private val tokenKey = stringPreferencesKey("token")

    suspend fun saveUserToken(token: String) {
        dataStore.updateData {
            it.toMutablePreferences().also { preferences ->
                preferences[tokenKey] = token
            }
        }
    }

    fun getUserToken(): Flow<String?> = dataStore.data.map { it[tokenKey] }

}