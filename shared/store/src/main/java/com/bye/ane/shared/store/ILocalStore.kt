package com.bye.ane.shared.store

import android.content.Context

interface ILocalStore {
    fun globalInitialize(ctx: Context)
    fun saveString(key: String, value: String)
    fun getString(key: String): String?
    fun saveInt(key: String, value: Int)
    fun getInt(key: String): Int?
    fun saveLong(key: String, value: Long)
    fun getLong(key: String): Long?
    fun saveDouble(key: String, value: Double)
    fun getDouble(key: String): Double?
    fun saveBoolean(key: String, value: Boolean)
    fun getBoolean(key: String): Boolean?
    fun remove(key: String)
}