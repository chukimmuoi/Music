package com.example.chukimmuoi.music.data

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.IBinder
import com.example.chukimmuoi.music.MusicApplication
import com.example.chukimmuoi.music.util.extension.isNetworkConnected
import com.example.chukimmuoi.music.util.extension.toggleAndroidComponent
import com.example.chukimmuoi.music.util.extension.unSubscribe
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MyService : Service() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, MyService::class.java)
        }
    }

    @Inject lateinit var dataManager: DataManager

    private var mDisposable: Disposable? = null

    override fun onCreate() {
        super.onCreate()
        (applicationContext as MusicApplication)
                .applicationComponent
                .inject(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Timber.i("Start sync ...")

        if (!isNetworkConnected()) { // Nếu không có kết nối mạng. Bật broadcast lắng nghe thay đổi kết nối mạng.
            Timber.i("Sync canceled, connection not available")

            toggleAndroidComponent(SyncOnConnectionAvailable::class.java, true)
            stopSelf(startId)

            return START_NOT_STICKY
        }

        mDisposable?.unSubscribe()
        mDisposable = dataManager.syncRibots()
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                        onComplete = {
                            Timber.i("Synced successfully!")

                            stopSelf(startId)
                        },
                        onError = {
                            Timber.w(it, "Error syncing.")

                            stopSelf(startId)
                        })

        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? = null

    override fun onDestroy() {
        mDisposable?.unSubscribe()
        super.onDestroy()
    }

    class SyncOnConnectionAvailable : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == ConnectivityManager.CONNECTIVITY_ACTION &&
                    context.isNetworkConnected()) { // Lắng nghe, khi có kết nối mạng start servicem tắt broadcastReceiver.
                Timber.i("Connection is now available, triggering sync...")

                context.toggleAndroidComponent(SyncOnConnectionAvailable::class.java, false)
                context.startService(getStartIntent(context))
            }
        }

    }
}
