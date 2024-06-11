package com.example.myapplication.network

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(
    name = "data"
)
class DataStoreManager(val context: Context) {

    val EMAIL = stringPreferencesKey("EMAIL")
    val emailflow: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[EMAIL] ?: ""
        }
    val PASSW = stringPreferencesKey("PASSW")
    val passwflow: Flow<String> = context.dataStore.data
        .map{ preferences ->
            preferences[PASSW] ?: ""
        }
    val ID = stringPreferencesKey("ID")
    val idflow: Flow<String> = context.dataStore.data
        .map{preferences ->
            preferences[ID] ?: ""
        }
    val AVATAR = stringPreferencesKey("AVATAR")
    val avatarflow: Flow<String> = context.dataStore.data
        .map{ preferences ->
            preferences[AVATAR] ?: ""
        }
    val TOKEN = stringPreferencesKey("TOKEN")
    val tokenflow: Flow<String> = context.dataStore.data
        .map{ preferences ->
            preferences[TOKEN] ?: ""
        }

    suspend fun saveEmail(email: String) {
        context.dataStore.edit { settings ->

            settings[EMAIL] = email
        }
    }
    suspend fun savePassw(passw: String) {
        context.dataStore.edit { settings ->

            settings[PASSW] = passw
        }
    }
    suspend fun saveId(id: String) {
        context.dataStore.edit { settings ->

            settings[ID] = id
        }
    }
    suspend fun saveAvatar(avatar: String) {
        context.dataStore.edit { settings ->

            settings[AVATAR] = avatar
        }
    }
    suspend fun saveToken(token: String) {
        context.dataStore.edit { settings ->

            settings[TOKEN] = token
        }
    }


}
