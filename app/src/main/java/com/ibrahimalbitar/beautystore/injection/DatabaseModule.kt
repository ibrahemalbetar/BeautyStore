package com.ibrahimalbitar.beautystore.injection

import androidx.room.Room
import com.ibrahimalbitar.beautystore.data.db.AppDatabase
import com.ibrahimalbitar.beautystore.data.repositories.ProductsRepository
import com.ibrahimalbitar.beautystore.data.services.ApiService
import com.ibrahimalbitar.beautystore.data.services.RetrofitClientService
import org.koin.core.module.Module
import org.koin.dsl.module

object DatabaseModule : () -> Module {
    override fun invoke(): Module= module  {
        single {
            Room.databaseBuilder(get(), AppDatabase::class.java, AppDatabase.DATABASE_NAME).build()
        }
        single { get<AppDatabase>().dao() }
        single { RetrofitClientService.createService(ApiService::class.java) }
        factory { ProductsRepository(get(), get(), get())}


    }
}