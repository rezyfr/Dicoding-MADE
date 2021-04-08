package com.rezyfr.submission3.utils

import android.content.SharedPreferences
import com.google.gson.Gson


object SharedPrefUtils {
    fun SharedPreferences.getStringUtils(key: String, outputPrefix: String = ""): String =
        if (this.contains(key))
            outputPrefix + this.getString(key, "")
        else
            ""

    fun SharedPreferences.saveString(key: String, value: String?) {
        val editor = this.edit()
        if (value == null)
            editor.remove(key)
        else
            editor.putString(key, value)
        editor.apply()
    }

    fun SharedPreferences.getInt(key: String): Int = this.getInt(key, 0)

    fun SharedPreferences.saveInt(key: String, value: Int?) {
        val editor = this.edit()
        if (value == null)
            editor.remove(key)
        else
            editor.putInt(key, value)
        editor.apply()
    }

    fun SharedPreferences.getBoolean(key: String): Boolean = this.getBoolean(key, false)

    fun SharedPreferences.saveBoolean(key: String, value: Boolean?) {
        val editor = this.edit()
        if (value == null)
            editor.remove(key)
        else
            editor.putBoolean(key, value)
        editor.apply()
    }

    fun <T> SharedPreferences.getJsonObject(jsonParser: Gson, key: String, classOfT: Class<T>): T? =
        if (this.contains(key))
            jsonParser.fromJson(this.getString(key, ""), classOfT)
        else
            null

    fun <T> SharedPreferences.saveJsonObject(jsonParser: Gson, key: String, obj: T?) {
        val editor = this.edit()
        if (obj == null)
            editor.remove(key)
        else
            editor.putString(key, jsonParser.toJson(obj))
        editor.apply()
    }

    fun SharedPreferences.clearSharedPreferences() {
        this.edit().clear().apply()
    }

}