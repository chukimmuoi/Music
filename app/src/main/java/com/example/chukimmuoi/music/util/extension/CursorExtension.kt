package com.example.chukimmuoi.music.util.extension

import android.database.Cursor

/**
 * @author : Hanet Electronics
 * @Skype  : chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email  : muoick@hanet.com
 * @Website: http://hanet.com/
 * @Project: Music
 * Created by CHUKIMMUOI on 2/1/2018.
 */

fun Cursor.getString(columnName: String, defaultValue: String = "") : String{
    val index = getColumnIndex(columnName)
    return getString(index) ?: defaultValue
}

fun Cursor.getInt(columnName: String, defaultValue: Int = 0) : Int{
    val index = getColumnIndex(columnName)
    return if (index >= 0) getInt(index) else defaultValue
}

fun Cursor.getLong(columnName: String, defaultValue: Long = 0L) : Long{
    val index = getColumnIndex(columnName)
    return if (index >= 0) getLong(index) else defaultValue
}

fun Cursor.getBoolean(columnName: String, defaultValue: Boolean = false) : Boolean{
    val index = getColumnIndex(columnName)
    return if(index >= 0) getInt(index) == 1 else defaultValue
}