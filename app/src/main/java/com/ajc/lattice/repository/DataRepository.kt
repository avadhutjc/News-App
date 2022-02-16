package com.ajc.lattice.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.ajc.lattice.model.remote.api.ApiService
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: ApiService) {
    fun getNewsResults() =
        Pager(config = PagingConfig(pageSize = 100), pagingSourceFactory = {
            NewsSourceRecycler(apiService) }
        ).liveData
}