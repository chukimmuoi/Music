package com.example.chukimmuoi.music.data.local

import android.database.sqlite.SQLiteDatabase
import com.example.chukimmuoi.music.data.model.Ribot
import com.squareup.sqlbrite3.BriteDatabase
import io.reactivex.Observable
import timber.log.Timber
import java.sql.SQLException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author : Hanet Electronics
 * @Skype  : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email  : muoick@hanet.com
 * @Website: http://hanet.com/
 * @Project: Music
 * Created by CHUKIMMUOI on 2/1/2018.
 */
@Singleton
class DatabaseHelper @Inject constructor(private val db: BriteDatabase) {

    fun setRebots(newRibots: Collection<Ribot>): Observable<Ribot> = Observable.create<Ribot>({ emitter ->
        val transaction = db.newTransaction()

        try {
            db.delete(Db.RibotProfileTable.TABLE_NAME, null)

            newRibots.forEach {
                val result = db.insert(Db.RibotProfileTable.TABLE_NAME,
                        SQLiteDatabase.CONFLICT_REPLACE,
                        Db.RibotProfileTable.toContentValues(it.profile))
                if (result >= 0) emitter.onNext(it)
            }

            transaction.markSuccessful()
            emitter.onComplete()
        } catch (e: SQLException) {
            Timber.e(e)
            emitter.onError(e)
        }

        transaction.end()
    })

    fun getRebots(): Observable<List<Ribot>> {
        return db.createQuery(Db.RibotProfileTable.TABLE_NAME,
                "SELECT * FROM ${Db.RibotProfileTable.TABLE_NAME}")
                .mapToList { Ribot(Db.RibotProfileTable.parseCursor(it)) }
    }
}