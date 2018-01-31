package com.example.chukimmuoi.music.injection.component

import com.example.chukimmuoi.music.injection.ConfigPersistent
import com.example.chukimmuoi.music.injection.modul.ActivityModule
import dagger.Component

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
 * Component sẽ sống trong vòng đời của activity.
 * Tuy nhiên nó sẽ không bị hủy khi xoay màn hình (configuration changes).
 * Xem [com.example.chukimmuoi.music.ui.basic.BaseActivity]
 * Sử dụng [ConfigPersistent] để chú thích phụ thuộc cần tồn tại khi thay đổi cấu hình.
 * */
@ConfigPersistent
@Component(dependencies = [(ApplicationComponent::class)])
interface ConfigPersistentComponent {
    fun activityComponent(activityModule: ActivityModule) : ActivityComponent
}