package com.example.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface Items_Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun upsert(item: Items)

    @Delete
    suspend fun delete(item: Items)

    @Query("select * FROM Items")
    fun getAllItems():LiveData<List<Items>>


}