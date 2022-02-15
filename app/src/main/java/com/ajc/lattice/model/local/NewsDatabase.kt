package com.ajc.lattice.model.local


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NewsEntity::class], version = 1)

abstract class Newsdatabase : RoomDatabase() {
    abstract fun getNews(): Dao

    companion object {
        private var instance: Newsdatabase? = null
        fun getNewsDatabase(context: Context): Newsdatabase {
            if (instance != null) {
                return instance!!
            } else {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    Newsdatabase::class.java,
                    "music_db"
                )
                builder.fallbackToDestructiveMigration()
                instance = builder.build()
                return instance!!
            }
        }
    }
}