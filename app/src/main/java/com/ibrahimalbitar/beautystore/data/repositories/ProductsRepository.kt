package com.ibrahimalbitar.beautystore.data.repositories

import androidx.room.withTransaction
import com.ibrahimalbitar.beautystore.data.dao.ProductsDao
import com.ibrahimalbitar.beautystore.data.db.AppDatabase
import com.ibrahimalbitar.beautystore.data.services.ApiService
import com.ibrahimalbitar.beautystore.utils.dataSourceSelector

class ProductsRepository constructor(private val apiServices: ApiService, private val database: AppDatabase, private val dao : ProductsDao) {

    fun getAllProducts() = dataSourceSelector(
        query = {
            dao.getAllProducts()
        },
        fetch = {
            apiServices.getAllProducts()
        },
        saveFetchResult = { product ->
            database.withTransaction {
                dao.deleteAllProducts()
                product.let { dao.insertProducts(it) }
            }
        }
    )
}