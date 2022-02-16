package com.ajc.lattice.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajc.lattice.R
import com.ajc.lattice.model.remote.Article
import com.ajc.lattice.ui.adapter.Adapter
import com.ajc.lattice.ui.adapter.OnClick
import com.ajc.lattice.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HeadlinesScreen : AppCompatActivity(), OnClick {

    private val movieViewModel by viewModels<MainViewModel>()
    private lateinit var movieAdapterRecycler: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerview()

        movieViewModel.searchNews().observe(this, {
            lifecycleScope.launch {
                it?.let {
                    movieAdapterRecycler.submitData(lifecycle, it)
                }
            }
        })
    }

    private fun setRecyclerview() {
        movieAdapterRecycler = Adapter(this )
        val linearLayoutManager = LinearLayoutManager(this)
        recycle1.apply {
            layoutManager = linearLayoutManager
            this.adapter = movieAdapterRecycler
        }
    }

    override fun setOnClick(result: Article) {
        val intent = Intent(this, NewsDetailsScreen::class.java)
        intent.putExtra("title", result.title)
        intent.putExtra("desc", result.description)
        intent.putExtra("release", result.publishedAt)
        intent.putExtra("language", result.content)
        intent.putExtra("image", result.urlToImage)
        intent.putExtra("vote", result.author)
        startActivity(intent)
    }
}