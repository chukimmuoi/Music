package com.example.chukimmuoi.music.injection.component

import com.example.chukimmuoi.music.injection.PerActivity
import com.example.chukimmuoi.music.injection.modul.ActivityModule
import com.example.chukimmuoi.music.ui.main.MainActivity
import dagger.Subcomponent

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
 * Component này sẽ inject vào tất cả các hoạt động trên toàn bộ ứng dụng.
 * */
@PerActivity
@Subcomponent(modules = [(ActivityModule::class)])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}