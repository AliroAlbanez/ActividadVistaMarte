package com.example.actividad7m6.modelos.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MarsDAO {
    @Query("SELECT * FROM TABLE_MARS ORDER BY id ASC")
    fun getAllDatos(): LiveData<List<MarsEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(listCourses: List<MarsEntity>)

}