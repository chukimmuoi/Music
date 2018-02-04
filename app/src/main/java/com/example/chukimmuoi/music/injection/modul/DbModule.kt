package com.example.chukimmuoi.music.injection.modul

import android.app.Application
import com.example.chukimmuoi.music.data.local.DbOpenHelper
import com.squareup.sqlbrite2.BriteDatabase
import com.squareup.sqlbrite2.SqlBrite
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import timber.log.BuildConfig
import timber.log.Timber
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
class DbModule {

    @Provides
    @Singleton
    fun provideOpenHelper(application: Application): DbOpenHelper {
        return DbOpenHelper(application)
    }

    @Provides
    @Singleton
    fun provideSqlBrite(): SqlBrite {
        return SqlBrite.Builder()
                .logger({Timber.tag("Database").v(it)})
                .build()
    }

    @Provides
    @Singleton
    fun provideDatabase(sqlBrite: SqlBrite, dbOpenHelper: DbOpenHelper): BriteDatabase {
        val db = sqlBrite.wrapDatabaseHelper(dbOpenHelper, Schedulers.io())
        db.setLoggingEnabled(BuildConfig.DEBUG)
        return db
    }
}