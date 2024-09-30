package com.bye.ane.shared.store.sp

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.bye.ane.shared.store.ILocalStore


class SPStore : ILocalStore {
    private var editor: SharedPreferences.Editor? = null
    private var sharedPreferences: SharedPreferences? = null
    override fun globalInitialize(ctx: Context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx)
        editor = sharedPreferences?.edit()
    }

    override fun saveString(key: String, value: String) {
        editor?.putString(key, value)?.apply()
    }

    override fun getString(key: String): String? {
        return sharedPreferences?.getString(key, "")
    }

    override fun saveInt(key: String, value: Int) {
        editor?.putInt(key, value)?.apply()
    }

    override fun getInt(key: String): Int? {
        return sharedPreferences?.getInt(key, 0)
    }

    override fun saveLong(key: String, value: Long) {
        editor?.putLong(key, value)?.apply()
    }

    override fun getLong(key: String): Long? {
        return sharedPreferences?.getLong(key, 0)
    }

    override fun saveDouble(key: String, value: Double) {
        editor?.putFloat(key, value.toFloat())?.apply()
    }

    override fun getDouble(key: String): Double? {
        return sharedPreferences?.getFloat(key, 0.0F)?.toDouble()
    }

    override fun saveBoolean(key: String, value: Boolean) {
        editor?.putBoolean(key, value)?.apply()
    }

    override fun getBoolean(key: String): Boolean? {
        return sharedPreferences?.getBoolean(key, false).apply {

        }
    }

    override fun remove(key: String) {
        editor?.remove(key)?.apply()
    }


}