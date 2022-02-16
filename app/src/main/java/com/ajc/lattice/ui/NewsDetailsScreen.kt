package com.ajc.lattice.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ajc.lattice.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.*
import kotlinx.android.synthetic.main.news_details.*

class NewsDetailsScreen : AppCompatActivity() {
    private var title: String = ""
    private var desc: String = ""
    private var date: String = ""
    private var source: String = ""
    private var url: String = ""
    private var name: String = ""
    private var lang: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_details)

        val intent = intent
        title = intent.getStringExtra("title").toString()
        desc = intent.getStringExtra("desc").toString()
        date = intent.getStringExtra("release").toString()
        source = intent.getStringExtra("source").toString()
        url = intent.getStringExtra("image").toString()
        name = intent.getStringExtra("name1").toString()
        lang = intent.getStringExtra("lang").toString()

        tvTitle.text = title
        tvLang.text = lang
        tvLang.text = date
        tvDesc.text = desc
        tvName1.text = name

        Glide.with(ivImageView).load(url).into(ivImageView)

    }
}