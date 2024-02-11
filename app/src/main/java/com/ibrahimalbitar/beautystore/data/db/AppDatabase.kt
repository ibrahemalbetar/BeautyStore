package com.ibrahimalbitar.beautystore.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ibrahimalbitar.beautystore.data.dao.ProductsDao
import com.ibrahimalbitar.beautystore.data.model.ProductsResp.Product
import com.ibrahimalbitar.beautystore.utils.Converters

@Database(
    entities = [Product::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun dao(): ProductsDao

    companion object {

        const val DATABASE_NAME = "mini-market-app-db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, DATABASE_NAME
            )
                .build()
    }
}