package com.example.chukimmuoi.music.util.extension

import io.reactivex.disposables.Disposable

/**
 * @author : Hanet Electronics
 * @Skype  : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email  : muoick@hanet.com
 * @Website: http://hanet.com/
 * @Project: Music
 * Created by CHUKIMMUOI on 2/2/2018.
 */
fun Disposable.unSubscribe() {

    if (!this?.isDisposed) {
        this?.dispose()
    }
}