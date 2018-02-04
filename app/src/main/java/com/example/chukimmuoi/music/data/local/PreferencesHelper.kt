package com.example.chukimmuoi.music.data.local

import android.content.SharedPreferences
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
class PreferencesHelper
@Inject
constructor() {

    companion object {
        const val PREF_FILE_NAME = "android_boilerplate_pref_file"
    }

    @Inject lateinit var mPref: SharedPreferences

    fun clear() {
        mPref.edit().clear().apply()
    }
}