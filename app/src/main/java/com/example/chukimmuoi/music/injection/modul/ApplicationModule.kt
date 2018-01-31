package com.example.chukimmuoi.music.injection.modul

import android.app.Application
import android.content.Context
import com.example.chukimmuoi.music.injection.ApplicationContext
import dagger.Module
import dagger.Provides
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
/**
 * Cung cấp mức phụ thuộc cấp ứng dụng.
 * */
@Module
class ApplicationModule(private val aplication: Application) {

    @Provides
    @Singleton
    internal fun provideApplication() : Application = aplication

    @Provides
    @Singleton
    @ApplicationContext
    internal fun providesContext() : Context = aplication
}