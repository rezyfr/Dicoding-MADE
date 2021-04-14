package com.rezyfr.dicoding.core.base

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {
    @Delete
    fun delete(obj: T)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg objects: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<T>)

    @Update
    fun update(obj: T)
}