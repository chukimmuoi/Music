package com.example.chukimmuoi.music.injection.modul

import android.app.Application
import com.example.chukimmuoi.music.BuildConfig
import com.example.chukimmuoi.music.data.remote.RibotsService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
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
        private const val VALUES_READ_TIMEOUT    = 60L
        private const val VALUES_CONNECT_TIMEOUT = 60L

        private const val VALUES_ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    }

    /**
     * Setup gson object.
     * */
    @Provides @Singleton fun provideGson() : Gson {
        return GsonBuilder()
                .setDateFormat(VALUES_ISO_FORMAT) // millis seconds.
                //.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
    }

    /**
     * Retrofit and Authentication.
     * */
    @Provides @Singleton fun provideInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request().newBuilder()
                    .header("Cache-Control", "max-age=60") //cho phép truy cập bộ nhớ cache khi offline.
                    .addHeader("User-Agent", BuildConfig.APPLICATION_ID)
                    .build()

            val response = chain.proceed(request)
            if (BuildConfig.DEBUG) showInformationService(chain, request, response)

            response
        }
    }

    private fun showInformationService(chain: Interceptor.Chain,
                                       request: Request,
                                       response: Response) {
        val timeStart = System.nanoTime()
        Timber.i(String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers()))

        val timeEnd = System.nanoTime()
        Timber.i(String.format("Received response for %s in %.1fms%n%s",
                response.request().url(), (timeEnd - timeStart) / 1e6, response.headers()))
    }

    @Provides
    @Singleton
    fun provideOkHttpCache(application: Application): Cache {
        val cacheSize: Long = 10 * 1024 * 1024 // 10 MB.
        return Cache(application.cacheDir, cacheSize)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: Interceptor, cache: Cache) : OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(interceptor) // or addNetworkInterceptor(interceptor)
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
                .addConverterFactory(GsonConverterFactory.create(gson))    // Gson.
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // RxJava.
                .build()
                .create(RibotsService::class.java)
    }
}