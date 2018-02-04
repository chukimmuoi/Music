package com.example.chukimmuoi.music.injection.modul

import android.app.Application
import com.example.chukimmuoi.music.data.remote.RibotsService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
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

    companion object {
        private val VALUES_READ_TIMEOUT    = 60L
        private val VALUES_CONNECT_TIMEOUT = 60L
    }

    @Provides
    @Singleton
    fun provideGson() : Gson {
        return GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") // millis
                //.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
    }

    @Provides
    @Singleton
    fun provideOkHttpCache(application: Application): Cache {
        val cacheSize: Long = 10 * 1024 * 1024 // 10 MB.
        return Cache(application.cacheDir, cacheSize)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache) : OkHttpClient {
        return OkHttpClient.Builder()
                .readTimeout(VALUES_READ_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(VALUES_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .cache(cache)
                .build()
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