package com.example.fooddelivery

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "eat_card_table")
data class Card(
    @ColumnInfo(name = "eat_name")
    val eatName: String,

    @ColumnInfo(name = "eat_count")
    val eatCount: Int,

    @ColumnInfo(name = "eat_price")
    val price: Double,

    @ColumnInfo(name = "eat_image")
    val eatimage: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "card_id")
    var eatId: Int = 0
}