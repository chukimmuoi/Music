package com.example.chukimmuoi.music.util.extension

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager


/**
 * @author : Hanet Electronics
 * @Skype  : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email  : muoick@hanet.com
 * @Website: http://hanet.com/
 * @Project: Music
 * Created by CHUKIMMUOI on 2/2/2018.
 */
@SuppressLint("MissingPermission")
/**
 * Kiểm tra kết nối internet.
 * */
fun Context.isNetworkConnected() : Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return cm.activeNetworkInfo?.isConnectedOrConnecting ?: false
}

/**
 * Tắt bật BroadcastReceiver.
 *
 * @param componentClass: Tên class: [com.example.chukimmuoi.music.data.MyService.SyncOnConnectionAvailable]
 * @param enable trạng thái on(true) hay off(false)
 * */
fun Context.toggleAndroidComponent(componentClass: Class<*>, enable: Boolean) {
    val componentName = ComponentName(this, componentClass)

    val newState = if (enable)
        PackageManager.COMPONENT_ENABLED_STATE_ENABLED
    else
        PackageManager.COMPONENT_ENABLED_STATE_DISABLED

    packageManager.setComponentEnabledSetting(componentName, newState, PackageManager.DONT_KILL_APP)
}