package com.example.chukimmuoi.music.ui.main

import android.os.Bundle
import com.example.chukimmuoi.music.R
import com.example.chukimmuoi.music.ui.basic.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        setContentView(R.layout.activity_main)
    }
}
