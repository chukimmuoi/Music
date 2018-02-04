package com.example.chukimmuoi.music.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.chukimmuoi.music.R
import com.example.chukimmuoi.music.data.MyService
import com.example.chukimmuoi.music.data.model.Ribot
import com.example.chukimmuoi.music.ui.basic.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    companion object {
        val EXTRA_TRIGGER_SYNC_FLAG =
                "com.example.chukimmuoi.music.ui.main.MainActivity.EXTRA_TRIGGER_SYNC_FLAG"
    }

    @Inject lateinit var presenter: MainPresenter
    @Inject lateinit var ribotsAdapter: RibotsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        setContentView(R.layout.activity_main)

        recycler_view.adapter = ribotsAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        presenter.attachView(this)
        presenter.loadRibots()

        if (intent.getBooleanExtra(EXTRA_TRIGGER_SYNC_FLAG, true)) {
            startService(MyService.getStartIntent(this))
        }
    }

    override fun showRibots(ribots: List<Ribot>) {
        ribotsAdapter.ribots = ribots
        ribotsAdapter.notifyDataSetChanged()
    }

    override fun showRibotsEmpty() {
        ribotsAdapter.ribots = emptyList()
        ribotsAdapter.notifyDataSetChanged()
        Toast.makeText(this, R.string.empty_ribots, Toast.LENGTH_LONG).show()
    }

    override fun showError() {
        Toast.makeText(this, R.string.error_loading_ribots, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }
}
