package com.example.fooddelivery

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Card::class],
    version = 1,
    exportSchema = false
)
abstract class CardDatabase: RoomDatabase() {
    abstract fun getCardDao(): CardDao

    companion object{
        private var instance: CardDatabase? = null

        fun getCardDatabase(context: Context): CardDatabase?{
            if (instance == null){
                instance = Room.databaseBuilder(context,
                    CardDatabase::class.java,
                    "card.db").allowMainThreadQueries().build()

            }
            return instance
        }
    }
}