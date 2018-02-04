package com.example.chukimmuoi.music.injection.modul

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.chukimmuoi.music.data.local.PreferencesHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : Music
 * Created by chukimmuoi on 03/02/2018.
 */
@Module(includes = [(ApiModule::class), (DbModule::class)])
class DataModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences(PreferencesHelper.PREF_FILE_NAME, Context.MODE_PRIVATE)
    }
}