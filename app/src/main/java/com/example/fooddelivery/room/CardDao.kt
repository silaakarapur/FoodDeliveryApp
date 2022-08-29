package com.example.fooddelivery.room

import androidx.room.*
import com.example.fooddelivery.room.Card

@Dao
interface CardDao {

    @Insert
    fun addData(eat: Card)


    @Query("SELECT * FROM eat_card_table ORDER BY card_id DESC")
    fun getAllBook(): List<Card>

    @Update
    fun update(eat: Card)

    @Delete
    fun delete(eat: Card)
}