package com.example.chukimmuoi.music.data.local

import android.content.ContentValues
import android.database.Cursor
import com.example.chukimmuoi.music.data.model.Name
import com.example.chukimmuoi.music.data.model.Profile
import com.example.chukimmuoi.music.util.extension.getLong
import com.example.chukimmuoi.music.util.extension.getString
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
object Db {

    object RibotProfileTable {
        const val TABLE_NAME = "ribot_profile"

        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_FIRST_NAME = "first_name"
        private const val COLUMN_LAST_NAME = "last_name"
        private const val COLUMN_HEX_COLOR = "hex_color"
        private const val COLUMN_DATE_OF_BIRTH = "date_of_birth"
        private const val COLUMN_AVATAR = "avatar"
        private const val COLUMN_BIO = "bio"

        val CREATE = """
            CREATE TABLE $TABLE_NAME(
              $COLUMN_EMAIL         TEXT PRIMARY KEY,
              $COLUMN_FIRST_NAME    TEXT NOT NULL,
              $COLUMN_LAST_NAME     TEXT NOT NULL,
              $COLUMN_HEX_COLOR     TEXT NOT NULL,
              $COLUMN_DATE_OF_BIRTH INTEGER NOT NULL,
              $COLUMN_AVATAR        TEXT,
              $COLUMN_BIO           TEXT
            )
        """

        fun toContentValues(profile: Profile): ContentValues {
            val values = ContentValues()
            values.put(COLUMN_EMAIL, profile.email)
            values.put(COLUMN_FIRST_NAME, profile.name.first)
            values.put(COLUMN_LAST_NAME, profile.name.last)
            values.put(COLUMN_HEX_COLOR, profile.hexColor)
            values.put(COLUMN_DATE_OF_BIRTH, profile.dateOfBirth.time)
            values.put(COLUMN_AVATAR, profile.avatar)
            values.put(COLUMN_BIO, profile.bio ?: "")
            return values
        }

        fun parseCursor(cursor: Cursor): Profile {
            val name = Name(cursor.getString(COLUMN_FIRST_NAME), cursor.getString(COLUMN_LAST_NAME))

            return Profile(
                    email = cursor.getString(COLUMN_EMAIL),
                    name = name,
                    hexColor = cursor.getString(COLUMN_HEX_COLOR),
                    dateOfBirth = Date(cursor.getLong(COLUMN_DATE_OF_BIRTH)),
                    avatar = cursor.getString(COLUMN_AVATAR),
                    bio = cursor.getString(COLUMN_BIO))
        }
    }
}