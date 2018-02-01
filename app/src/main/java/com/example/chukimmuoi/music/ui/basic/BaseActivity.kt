package com.example.chukimmuoi.music.ui.basic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chukimmuoi.music.MusicApplication
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
open class BaseActivity : AppCompatActivity() {

    companion object {
        private const val KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID"
        private val NEXT_ID               = AtomicLong(0) // Default = 0

        private val sComponentsMap = HashMap<Long, ConfigPersistentComponent>()
    }

    private var mActivityId: Long = 0L

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Tạo ActivityComponent và sử dụng lại cache ConfigPersistentComponent
        // nếu điều này đang được gọi sau khi một sự thay đổi cấu hình.
        mActivityId = savedInstanceState?.getLong(KEY_ACTIVITY_ID) ?: NEXT_ID.getAndIncrement()

        val configPersistentComponent: ConfigPersistentComponent
        if (sComponentsMap.getValue(mActivityId) == null) {
            Timber.i("Creating new ConfigPersistentComponent id=%d", mActivityId)

            val component = MusicApplication.get(this).applicationComponent
            configPersistentComponent = DaggerConfigPersistentComponent.builder().applicationComponent(component).build()
            sComponentsMap[mActivityId] = configPersistentComponent
        } else {
            Timber.i("Reusing ConfigPersistentComponent id=%d", mActivityId)

            configPersistentComponent = sComponentsMap.getValue(mActivityId)
        }

        activityComponent = configPersistentComponent.activityComponent(activityModule = ActivityModule(this))
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putLong(KEY_ACTIVITY_ID, mActivityId)
    }

    override fun onDestroy() {
        if (!isChangingConfigurations) {
            Timber.i("Clearing ConfigPersistentComponent id=%d", mActivityId)

            sComponentsMap.remove(mActivityId)
        }

        super.onDestroy()
    }
}