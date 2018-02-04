package com.example.chukimmuoi.music.injection.modul

import com.example.chukimmuoi.music.data.remote.RibotsService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
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
@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideGson() : Gson {
        return GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient {
        return OkHttpClient()
    }

    @Provides
    @Singleton
    fun provideRibotsService(okHttpClient: OkHttpClient, gson: Gson) : RibotsService {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.ribot.io/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(RibotsService::class.java)
    }
}