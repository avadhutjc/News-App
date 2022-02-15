package com.ajc.lattice.ui

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajc.lattice.R
import com.ajc.lattice.model.local.Dao
import com.ajc.lattice.model.local.NewsEntity
import com.ajc.lattice.model.local.Newsdatabase
import com.ajc.lattice.model.remote.Article
import com.ajc.lattice.model.remote.api.ApiService
import com.ajc.lattice.model.remote.api.Network
import com.ajc.lattice.repository.DataRepository
import com.ajc.lattice.ui.adapter.Adapter
import com.ajc.lattice.ui.adapter.OnClick
import com.ajc.lattice.viewmodel.MainViewModel
import com.ajc.lattice.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeadlinesScreen : AppCompatActivity(), OnClick {
    private lateinit var adapterjoin: Adapter
    lateinit var viewModel2: MainViewModel
    lateinit var repository: DataRepository
    private var list = mutableListOf<Article>()
    private var newsList = mutableListOf<NewsEntity>()
    lateinit var dao: Dao

    var manager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = LinearLayoutManager(this)
        dao = Newsdatabase.getNewsDatabase(this).getNews()

        val userApi = Network.getInstance().create(ApiService::class.java)
        repository = DataRepository(userApi, dao)
        val factory = ViewModelFactory(repository)
        viewModel2 = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

        if (isNetworkAvailable()) {
            loadApi()
        }

        viewModel2.getData().observe(this, Observer {
            newsList.addAll(it)
            setRecycle()
        })
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    private fun insertDataToDb(resultModels: List<Article>) {
        viewModel2.deleteDataFromDb()
        resultModels.forEach {
            val newsDb =
                NewsEntity(it.title, it.urlToImage, it.description, it.publishedAt, it.source.name)
            viewModel2.insertDataInDb(newsDb)
        }
    }

    private fun loadApi() {
        viewModel2.createTransaction()
        viewModel2.user.observe(this, Observer {
            list.clear()
            if (it != null) {
                CoroutineScope(Dispatchers.IO).launch {
                    insertDataToDb(it.articles)
                }
            }
            list.addAll(it.articles as MutableList<Article>)
        })
    }

    private fun setRecycle() {
        adapterjoin = Adapter(newsList, this, this)
        recycle.adapter = adapterjoin
        recycle.layoutManager = LinearLayoutManager(this)
    }

    override fun setOnClick(result: NewsEntity) {
        val url = result.ImageUrl
        val intent = Intent(this, NewsDetailsScreen::class.java)
        intent.putExtra("name", result.Name)
        intent.putExtra("desc", result.desc)
        intent.putExtra("date", result.date)
        intent.putExtra("source", result.source)
        intent.putExtra("url", url)
        startActivity(intent)
    }
}