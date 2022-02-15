package com.ajc.lattice.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addDataFromAPI(result: NewsEntity)

    @Query("select * from news_db")
    fun getResponseFromDb(): LiveData<List<NewsEntity>>

    @Query("delete from news_db")
    fun deleteAllDataFromDB()
}