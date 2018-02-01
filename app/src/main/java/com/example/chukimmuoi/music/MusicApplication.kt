package com.example.chukimmuoi.music

import android.app.Application
import android.content.Context
import com.example.chukimmuoi.music.injection.component.ApplicationComponent
import com.example.chukimmuoi.music.injection.component.DaggerApplicationComponent
import com.example.chukimmuoi.music.injection.modul.ApplicationModule
import timber.log.Timber

/**
 * @author : Hanet Electronics
 * @Skype  : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email  : muoick@hanet.com
 * @Website: http://hanet.com/
 * @Project: Music
 * Created by CHUKIMMUOI on 1/31/2018.
 */
class MusicApplication : Application() {

    val applicationComponent: ApplicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()

    companion object {
        fun get(context: Context) : MusicApplication = context.applicationContext as MusicApplication
    }

    override fun onCreate() {
        super.onCreate()

        // Setup log.
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}