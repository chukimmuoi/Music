package com.example.chukimmuoi.music.data

import com.example.chukimmuoi.music.data.local.DatabaseHelper
import com.example.chukimmuoi.music.data.local.PreferencesHelper
import com.example.chukimmuoi.music.data.model.Ribot
import com.example.chukimmuoi.music.data.remote.RebotsService
import io.reactivex.Observable
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
class DataManager @Inject constructor(private val mRibotsService: RebotsService,
                                      private val mPreferencesHelper: PreferencesHelper,
                                      private val mDatabaseHelper: DatabaseHelper) {

    fun syncRibots(): Observable<Ribot> = mRibotsService.getRibots()
            .concatMap { mDatabaseHelper.setRebots(it) } // Biến đổi dữ liệu đầu vào

    fun getRibots(): Observable<List<Ribot>> = mDatabaseHelper.getRebots().distinct() // Lọc duy nhất.

}