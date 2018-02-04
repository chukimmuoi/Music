package com.example.chukimmuoi.music.ui.main

import com.example.chukimmuoi.music.data.model.Ribot
import com.example.chukimmuoi.music.ui.basic.BasePresenter
import com.example.chukimmuoi.music.ui.basic.MvpView

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : Music
 * Created by chukimmuoi on 04/02/2018.
 */
object MainContract {

    interface View : MvpView {
        fun showRibots(ribots: List<Ribot>)
        fun showRibotsEmpty()
        fun showError()
    }

    abstract class Presenter : BasePresenter<View>() {
        abstract fun loadRibots()
    }
}