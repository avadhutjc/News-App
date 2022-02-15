package com.ajc.lattice.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ajc.lattice.model.local.NewsEntity
import com.ajc.lattice.model.local.Dao
import com.ajc.lattice.model.remote.ResponseDTO
import com.ajc.lattice.model.remote.api.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataRepository(private val userApi: ApiService, private val dao: Dao) {

    private val userLiveData = MutableLiveData<ResponseDTO>()

    val user: LiveData<ResponseDTO> get() = userLiveData

    suspend fun getData() {
        val result = userApi.getData("usa", "b5becfb5a3d34c7991cb1af2c22c0d57")
        if (result?.body() != null) {
            userLiveData.postValue(result.body())
        }
    }

    fun insertDataInDb(newsTable: NewsEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllDataFromDB()
            dao.addDataFromAPI(newsTable)
        }
    }

    fun getDataFromDb(): LiveData<List<NewsEntity>> {
        return dao.getResponseFromDb()
    }

    fun deleteDataFromDb() {
        dao.deleteAllDataFromDB()
    }

}