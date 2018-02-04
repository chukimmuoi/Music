package com.example.chukimmuoi.music.ui.main

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.chukimmuoi.music.R
import com.example.chukimmuoi.music.data.model.Ribot
import kotlinx.android.synthetic.main.item_ribot.view.*
import javax.inject.Inject

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : Music
 * Created by chukimmuoi on 04/02/2018.
 */
class RibotsAdapter
@Inject
constructor() : RecyclerView.Adapter<RibotsAdapter.RibotViewHolder>() {

    var ribots = emptyList<Ribot>()

    override fun onBindViewHolder(holder: RibotViewHolder, position: Int) {
        val ribot = ribots[position]

        holder.hexColorView.setBackgroundColor(Color.parseColor(ribot.profile.hexColor))
        holder.nameTextView.text = "%s %s".format(ribot.profile.name.first, ribot.profile.name.last)
        holder.emailTextView.text = ribot.profile.email
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RibotViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_ribot, parent, false)

        return RibotViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return ribots.size
    }

    inner class RibotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val hexColorView: View = itemView.card_view.view_hex_color

        val nameTextView: TextView = itemView.card_view.text_name

        val emailTextView: TextView = itemView.card_view.text_email
    }
}