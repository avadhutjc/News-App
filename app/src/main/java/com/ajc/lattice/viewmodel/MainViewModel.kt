package com.ajc.lattice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.ajc.lattice.model.remote.Article
import com.ajc.lattice.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val movieRepository: DataRepository) :
    ViewModel() {

    fun searchNews(): LiveData<PagingData<Article>> {
        return movieRepository.getNewsResults()
    }
}