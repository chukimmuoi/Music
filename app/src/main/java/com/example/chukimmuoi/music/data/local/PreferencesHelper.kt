package com.example.chukimmuoi.music.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.chukimmuoi.music.injection.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author : Hanet Electronics
 * @Skype  : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email  : muoick@hanet.com
 * @Website: http://hanet.com/
 * @Project: Music
 * Created by CHUKIMMUOI on 2/1/2018.
 */
@Singleton
class PreferencesHelper @Inject constructor(@ApplicationContext private val context: Context) {

    companion object {
        private const val PREF_FILE_NAME = "android_boilerplate_pref_file"
    }

    private val mPref: SharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)

    fun clear() {
        mPref.edit().clear().apply()
    }
}