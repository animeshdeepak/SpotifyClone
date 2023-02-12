package com.example.data.repositoryImpl

import android.content.SharedPreferences
import com.example.domain.repository.PrefRepository

class SharedPrefRepositoryImpl(
    private val pref: SharedPreferences,
    private val editor: SharedPreferences.Editor
) : PrefRepository {
    companion object {
        private const val STRING_DEFAULT_VALUE: String = ""
        private const val INT_DEFAULT_VALUE = -1
        private const val FLOAT_DEFAULT_VALUE = 0.0F
        private const val BOOLEAN_DEFAULT_VALUE = false
    }

    override fun save(key: String, value: Any?) {
        with(editor) {
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Float -> putFloat(key, value)
                is Boolean -> putBoolean(key, value)
            }
            apply()
        }
    }

    override fun getString(key: String): String? {
        return pref.getString(key, STRING_DEFAULT_VALUE)
    }

    override fun getInt(key: String): Int = pref.getInt(key, INT_DEFAULT_VALUE)
    override fun getFloat(key: String): Float = pref.getFloat(key, FLOAT_DEFAULT_VALUE)
    override fun getBoolean(key: String): Boolean = pref.getBoolean(key, BOOLEAN_DEFAULT_VALUE)
    override fun removeFromPref(key: String): SharedPreferences.Editor = editor.remove(key)
    override fun clearPref(): SharedPreferences.Editor = editor.clear()
}