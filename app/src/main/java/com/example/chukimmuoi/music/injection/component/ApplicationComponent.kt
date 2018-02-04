package com.example.chukimmuoi.music.injection.component

import android.app.Application
import android.content.Context
import com.example.chukimmuoi.music.data.DataManager
import com.example.chukimmuoi.music.data.MyService
import com.example.chukimmuoi.music.data.local.DatabaseHelper
import com.example.chukimmuoi.music.data.remote.RibotsService
import com.example.chukimmuoi.music.injection.ApplicationContext
import com.example.chukimmuoi.music.injection.modul.ApplicationModule
import com.example.chukimmuoi.music.injection.modul.DataModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author : Hanet Electronics
 * @Skype  : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email  : muoick@hanet.com
 * @Website: http://hanet.com/
 * @Project: Music
 * Created by CHUKIMMUOI on 1/31/2018.
 */
@Singleton
@Component(modules = [(ApplicationModule::class), (DataModule::class)])
interface ApplicationComponent {

    fun inject(myService: MyService)

    @ApplicationContext
    fun context(): Context
    fun application(): Application
    fun ribotsService(): RibotsService
    fun databaseHelper(): DatabaseHelper
    fun dataManager(): DataManager
}