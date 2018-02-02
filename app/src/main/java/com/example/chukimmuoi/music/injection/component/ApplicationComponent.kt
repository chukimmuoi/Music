package com.example.chukimmuoi.music.injection.component

import com.example.chukimmuoi.music.data.MyService
import com.example.chukimmuoi.music.injection.modul.ApplicationModule
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
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {

    fun inject(myService: MyService)
}