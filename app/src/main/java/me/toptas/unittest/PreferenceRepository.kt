package me.toptas.unittest

import android.content.Context
import android.content.SharedPreferences

class PreferenceRepositoryImpl(context: Context) : PreferenceRepository {

    private val sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
    private val KEY_SEEN = "seen"
    private val KEY_TOKEN = "token"

    override fun isBoardingSeen(): Boolean {
        return sharedPreferences.getBoolean(KEY_SEEN, false)
    }

    override fun setOnBoardingSeen() {
        sharedPreferences.edit().apply {
            putBoolean(KEY_SEEN, true)
            apply()
        }
    }

    override fun setToken(token: String) {
        sharedPreferences.edit().apply {
            putString(KEY_TOKEN, token)
            apply()
        }
    }
}


interface PreferenceRepository {
    fun isBoardingSeen(): Boolean
    fun setOnBoardingSeen()
    fun setToken(token: String)
}