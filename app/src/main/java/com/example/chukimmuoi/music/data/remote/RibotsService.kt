package com.example.chukimmuoi.music.data.remote

import com.example.chukimmuoi.music.data.model.Ribot
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @author : Hanet Electronics
 * @Skype  : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email  : muoick@hanet.com
 * @Website: http://hanet.com/
 * @Project: Music
 * Created by CHUKIMMUOI on 2/1/2018.
 */
interface RibotsService {

    @GET("ribots")
    fun getRibots() : Observable<List<Ribot>>
}