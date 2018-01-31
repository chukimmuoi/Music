package com.example.chukimmuoi.music.injection.modul

import android.app.Activity
import android.content.Context
import com.example.chukimmuoi.music.injection.ActivityContext
import com.example.chukimmuoi.music.injection.PerActivity
import dagger.Module
import dagger.Provides

/**
 * @author : Hanet Electronics
 * @Skype  : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email  : muoick@hanet.com
 * @Website: http://hanet.com/
 * @Project: Music
 * Created by CHUKIMMUOI on 1/31/2018.
 */
@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @PerActivity
    internal fun provideActivity(): Activity = activity

    @Provides
    @PerActivity
    @ActivityContext
    internal fun providesContext(): Context = activity
}