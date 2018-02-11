package com.example.chukimmuoi.music.ui.basic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.example.chukimmuoi.music.MusicApplication
import com.example.chukimmuoi.music.R
import com.example.chukimmuoi.music.injection.component.ActivityComponent
import com.example.chukimmuoi.music.injection.component.ConfigPersistentComponent
import com.example.chukimmuoi.music.injection.component.DaggerConfigPersistentComponent
import com.example.chukimmuoi.music.injection.modul.ActivityModule
import timber.log.Timber
import java.util.concurrent.atomic.AtomicLong

/**
 * @author : Hanet Electronics
 * @Skype  : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email  : muoick@hanet.com
 * @Website: http://hanet.com/
 * @Project: Music
 * Created by CHUKIMMUOI on 1/31/2018.
 */
open class BaseActivity : AppCompatActivity(), MvpView {

    companion object {
        private const val KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID"
        private val NEXT_ID               = AtomicLong(0) // Default = 0

        private val sComponentsMap = HashMap<Long, ConfigPersistentComponent>()
    }

    private var mActivityId: Long = 0L

    lateinit var activityComponent: ActivityComponent

    private var mMaterialDialog: MaterialDialog? = null
    private var mToast: Toast? = null

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Tạo ActivityComponent và sử dụng lại cache ConfigPersistentComponent
        // nếu điều này đang được gọi sau khi một sự thay đổi cấu hình.
        mActivityId = savedInstanceState?.getLong(KEY_ACTIVITY_ID) ?: NEXT_ID.getAndIncrement()

        if (sComponentsMap[mActivityId] != null) {
            Timber.i("Reusing ConfigPersistentComponent id = %d", mActivityId)
        }

        val configPersistentComponent = sComponentsMap.getOrPut(mActivityId, {// Default value.
            Timber.i("Creating new ConfigPersistentComponent id = %d", mActivityId)

            val component = (applicationContext as MusicApplication).applicationComponent

            DaggerConfigPersistentComponent.builder()
                    .applicationComponent(component)
                    .build()
        })

        activityComponent = configPersistentComponent.activityComponent(ActivityModule(this))
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        if (!isChangingConfigurations) {
            Timber.i("Clearing ConfigPersistentComponent id=%d", mActivityId)

            sComponentsMap.remove(mActivityId)
        }

        dismissDialog()
        dismissToast()

        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putLong(KEY_ACTIVITY_ID, mActivityId)
    }

    override fun showDialogBasic(title: String, content: String,
                                 positive: String, positiveCallback: BaseContract.Callback?,
                                 negative: String, negativeCallback: BaseContract.Callback?,
                                 neutral: String, neutralCallback: BaseContract.Callback?) {
        dismissDialog()

        val builder = MaterialDialog.Builder(applicationContext)
                .backgroundColorRes(R.color.colorDialogBackground)
                .title(title).titleColorRes(R.color.colorDialogTitle)
                .content(content).contentColorRes(R.color.colorDialogContent)

        if (positive?.isEmpty()) {
            builder.positiveText(positive).positiveColorRes(R.color.colorDialogPositive)
                    .onPositive { dialog, which -> positiveCallback?.onAction(null) }
        }

        if (negative?.isEmpty()) {
            builder.negativeText(negative).negativeColorRes(R.color.colorDialogNegative)
                    .onNegative { dialog, which -> negativeCallback?.onAction(null) }
        }

        if (neutral?.isEmpty()) {
            builder.neutralText(neutral).neutralColorRes(R.color.colorDialogNeutral)
                    .onNeutral { dialog, which -> negativeCallback?.onAction(null) }
        }

        mMaterialDialog = builder.show()

    }

    //============================================DIALOG==========================================//
    override fun showDialogBasic(title: Int, content: Int,
                                 positive: Int, positiveCallback: BaseContract.Callback?,
                                 negative: Int, negativeCallback: BaseContract.Callback?,
                                 neutral: Int, neutralCallback: BaseContract.Callback?) {
        showDialogBasic(getString(title), getString(content),
                getString(positive), positiveCallback,
                getString(negative), negativeCallback,
                getString(neutral), neutralCallback)
    }

    override fun showDialogProgress(title: String, content: String, isHorizontal: Boolean) {
        dismissDialog()

        val builder = MaterialDialog.Builder(this)
                .backgroundColorRes(R.color.colorDialogBackground)
                .title(title).titleColorRes(R.color.colorDialogTitle)
                .content(content).contentColorRes(R.color.colorDialogContent)
                .progress(true, 0)
                .progressIndeterminateStyle(isHorizontal)
                .widgetColorRes(R.color.colorDialogProgress)

        mMaterialDialog = builder.show()
    }

    override fun showDialogProgressCircle(title: String, content: String) {
        showDialogProgress(title, content, false)
    }

    override fun showDialogProgressHorizontal(title: String, content: String) {
        showDialogProgress(title, content, true)
    }

    override fun showDialogProgressCircle(title: Int, content: Int) {
        showDialogProgressCircle(getString(title), getString(content))
    }

    override fun showDialogProgressHorizontal(title: Int, content: Int) {
        showDialogProgressHorizontal(getString(title), getString(content))
    }

    override fun dismissDialog() {
        mMaterialDialog?.dismiss()
        mMaterialDialog = null
    }

    override fun hideDialog() {
        mMaterialDialog?.hide()
    }
    //============================================DIALOG==========================================//

    //=============================================TOAST==========================================//
    override fun showToast(content: String, isLongTime: Boolean) {
        dismissToast()

        mToast = Toast.makeText(applicationContext, content,
                if (isLongTime) Toast.LENGTH_LONG else Toast.LENGTH_SHORT)
        mToast?.setGravity(Gravity.CENTER, 0, 0)

        mToast?.show()
    }

    override fun showToast(content: Int, isLongTime: Boolean) {
        showToast(getString(content), isLongTime)
    }

    override fun dismissToast() {
        mToast?.cancel()
        mToast = null
    }
    //=============================================TOAST==========================================//
}