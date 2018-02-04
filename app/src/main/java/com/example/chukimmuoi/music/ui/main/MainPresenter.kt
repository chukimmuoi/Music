package com.example.chukimmuoi.music.ui.main

import com.example.chukimmuoi.music.data.DataManager
import com.example.chukimmuoi.music.injection.ConfigPersistent
import com.example.chukimmuoi.music.util.extension.unSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber
import javax.inject.Inject

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : Music
 * Created by chukimmuoi on 04/02/2018.
 */
@ConfigPersistent
class MainPresenter
@Inject
constructor(private val dataManager: DataManager) : MainContract.Presenter() {

    private var mDisposable: Disposable? = null

    override fun attachView(view: MainContract.View) {
        super.attachView(view)
    }

    override fun detachView() {
        super.detachView()
        mDisposable?.unSubscribe()
    }

    override fun loadRibots() {
        mDisposable?.unSubscribe()
        mDisposable = dataManager.getRibots()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .subscribeBy(
                        onNext = {
                            if (it.isEmpty()) view.showRibotsEmpty() else view.showRibots(it)
                        },
                        onComplete = {

                        },
                        onError = {
                            Timber.e(it, "There was an error loading the ribots.")
                            view.showError()
                        })
    }
}