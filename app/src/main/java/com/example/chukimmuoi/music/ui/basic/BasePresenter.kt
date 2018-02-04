package com.example.chukimmuoi.music.ui.basic

/**
 * @author : Hanet Electronics
 * @Skype  : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email  : muoick@hanet.com
 * @Website: http://hanet.com/
 * @Project: Music
 * Created by CHUKIMMUOI on 1/31/2018.
 */

open class BasePresenter<T : MvpView> : Presenter<T> {

    private var mvpView: T? = null
    val view: T
        get() {
            return mvpView ?: throw MvpViewNotAttachedException()
        }

    override fun attachView(view: T) {
        mvpView = view
    }

    override fun detachView() {
        mvpView = null
    }

    class MvpViewNotAttachedException : RuntimeException(
            "Please call Presenter.attachView(MvpView) before requesting data to the Presenter")
}