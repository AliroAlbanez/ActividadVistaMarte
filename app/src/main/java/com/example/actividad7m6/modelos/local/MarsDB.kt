package com.example.actividad7m6.modelos.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MarsEntity::class], version = 1,
    exportSchema = false)
abstract class MarsDB : RoomDatabase(){

    abstract fun getMarsDao() : MarsDAO

    companion object{

        @Volatile
        private var
                INSTANCE : MarsDB? = null
        fun getDataBase(context: Context) : MarsDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MarsDB::class.java, "mars_db")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}