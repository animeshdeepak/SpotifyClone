package com.example.domain.repository

import android.content.SharedPreferences

interface PrefRepository {
    fun save(key: String, value: Any?)
    fun getString(key: String): String?
    fun getInt(key: String): Int?
    fun getFloat(key: String): Float?
    fun getBoolean(key: String): Boolean?

    fun removeFromPref(key: String): SharedPreferences.Editor
    fun clearPref(): SharedPreferences.Editor
}