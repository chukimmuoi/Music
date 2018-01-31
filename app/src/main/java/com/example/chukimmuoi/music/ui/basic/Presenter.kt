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
/**
 * Interface cơ sở
 * Bất kỳ class nào đóng vai trò là Presenter trong mô hình MVP phải implement interface này
 * đồng thời cho biết loại (class implement MvpView) view muốn được gắn kèm
 * ở đây là: [BasePresenter].
 * */
interface Presenter<in V : MvpView> {
    fun attachView(view : V)
    fun detachView()
}