package com.example.chukimmuoi.music.injection

import javax.inject.Scope

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
 * Phạm vi phụ thuộc phù hợp với vòng đời của [com.example.chukimmuoi.music.injection.component.ConfigPersistentComponent]
 * */
@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ConfigPersistent