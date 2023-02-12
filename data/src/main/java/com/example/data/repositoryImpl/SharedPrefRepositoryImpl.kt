package com.example.data.repositoryImpl

import android.content.SharedPreferences
import com.example.domain.repository.PrefRepository

class SharedPrefRepositoryImpl(
    private val pref: SharedPreferences,
    private val editor: SharedPreferences.Editor
) : PrefRepository {
    companion object {
        private val someStringDefaultValue = null
    }

    override fun save(key: String, value: String?) {
        with(editor) {
            putString(key, value)
            apply()
        }
    }

    override fun get(key: String): String? {
        return pref.getString(key, someStringDefaultValue)
    }
}