package com.ajc.lattice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajc.lattice.model.local.NewsEntity
import com.ajc.lattice.model.remote.ResponseDTO
import com.ajc.lattice.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val dataRepository: DataRepository) : ViewModel() {

    fun createTransaction() {
        viewModelScope.launch(Dispatchers.IO) {
            dataRepository.getData()
        }
    }

    val user: LiveData<ResponseDTO> get() = dataRepository.user

    fun insertDataInDb(itunesDbTable: NewsEntity) {
        dataRepository.insertDataInDb(itunesDbTable)
    }

    fun deleteDataFromDb() {
        dataRepository.deleteDataFromDb()
    }

    fun getDataFromDb() {
        dataRepository.getDataFromDb()
    }

    fun getData(): LiveData<List<NewsEntity>> {
        return dataRepository.getDataFromDb()
    }
}
