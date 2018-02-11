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
 * Bất kỳ class nào muốn đóng vai trò là View trong mô hình MVP phải implement interface này
 * */
interface MvpView {

    /**
     * Hien thi dialog len man hinh thiet bi. Voi cac tham so truyen vao la string.
     *
     * @param title thong tin ngan gon (loi, canh bao, ...)
     * @param content mo ta chi tiet
     * @param positive dong y (ok)
     * @param positiveCallback action khi dong y
     * @param negative huy bo (cancel)
     * @param negativeCallback action khi huy bo
     * @param neutral trung lap (bo qua)
     * @param neutralCallback action khi bo qua
     * */
    fun showDialogBasic(title: String, content: String,
                        positive: String = "", positiveCallback: BaseContract.Callback? = null,
                        negative: String = "", negativeCallback: BaseContract.Callback? = null,
                        neutral: String = "", neutralCallback: BaseContract.Callback? = null
    )

    /**
     * Hien thi dialog len man hinh thiet bi. Voi cac tham so truyen vao la int.
     *
     * @param title thong tin ngan gon (loi, canh bao, ...)
     * @param content mo ta chi tiet
     * @param positive dong y (ok)
     * @param positiveCallback action khi dong y
     * @param negative huy bo (cancel)
     * @param negativeCallback action khi huy bo
     * @param neutral trung lap (bo qua)
     * @param neutralCallback action khi bo qua
     * */
    fun showDialogBasic(title: Int, content: Int,
                        positive: Int = -1, positiveCallback: BaseContract.Callback? = null,
                        negative: Int = -1, negativeCallback: BaseContract.Callback? = null,
                        neutral: Int = -1, neutralCallback: BaseContract.Callback? = null
    )

    /**
     * Hien thi dialog progress cho muc dich cho doi. Bao gom hinh tron va thanh ngang
     *
     * @param title tieu de ngan gon
     * @param content noi dung chi tiet
     * @param isHorizontal tron (false) hoac ngang (true)
     * */
    fun showDialogProgress(title: String, content: String, isHorizontal: Boolean = false)

    /**
     * Hien thi dialog progress tron
     *
     * @param title tieu de ngan gon
     * @param content noi dung
     * */
    fun showDialogProgressCircle(title: String, content: String)

    /**
     * Hien thi dialog progress thanh ngang
     *
     * @param title tieu de
     * @param content noi dung
     * */
    fun showDialogProgressHorizontal(title: String, content: String)

    /**
     * Hien thi dialog progress tron
     *
     * @param title tieu de
     * @param content noi dung
     * */
    fun showDialogProgressCircle(title: Int, content: Int)

    /**
     * Hien thi dialog progress thanh ngang
     *
     * @param title tieu de
     * @param content noi dung
     * */
    fun showDialogProgressHorizontal(title: Int, content: Int)

    /**
     *
     * */
    fun dismissDialog()

    /**
     *
     * */
    fun hideDialog()

    /**
     * @param content
     * @param isLongTime
     * */
    fun showToast(content: String, isLongTime: Boolean = false)

    /**
     * @param content
     * @param isLongTime
     * */
    fun showToast(content: Int, isLongTime: Boolean = false)

    /**
     *
     * */
    fun dismissToast()
}