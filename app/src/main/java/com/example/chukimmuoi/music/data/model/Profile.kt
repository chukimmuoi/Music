package com.example.chukimmuoi.music.data.model

import java.util.*

/**
 * @author : Hanet Electronics
 * @Skype  : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email  : muoick@hanet.com
 * @Website: http://hanet.com/
 * @Project: Music
 * Created by CHUKIMMUOI on 2/1/2018.
 */
data class Profile(
        val name: Name,
        val email: String,
        val hexColor: String,
        val dateOfBirth: Date,
        val bio: String?,
        val avatar: String?)