package com.ajc.lattice.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_db")
data class NewsEntity(
    @ColumnInfo(name = "Title") val Name: String,
    @ColumnInfo(name = "ImageUrl") val ImageUrl: String,
    @ColumnInfo(name = "desc") val desc: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "source") val source: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}