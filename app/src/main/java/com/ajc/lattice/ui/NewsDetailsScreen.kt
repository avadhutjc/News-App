package com.ajc.lattice.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ajc.lattice.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_details.*

class NewsDetailsScreen : AppCompatActivity() {
    private var title: String = ""
    private var desc: String = ""
    private var date: String = ""
    private var source: String = ""
    private var url: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_details)

        val intent = intent
        title = intent.getStringExtra("title").toString()
        desc = intent.getStringExtra("desc").toString()
        date = intent.getStringExtra("release").toString()
        source = intent.getStringExtra("source").toString()
        url = intent.getStringExtra("image").toString()

        tvTitle.text = title
        tvDetail.text = source
        tvDate.text = date
        tvDesc.text = desc

        Glide.with(ivImageView).load(url).into(ivImageView)

    }
}