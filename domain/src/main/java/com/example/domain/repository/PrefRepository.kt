package com.example.domain.repository

interface PrefRepository {
    fun save(key: String, value: String?)
    fun get(key: String): String?
}