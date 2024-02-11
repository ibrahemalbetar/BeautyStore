package com.ibrahimalbitar.beautystore

import android.app.Application
import com.ibrahimalbitar.beautystore.injection.DatabaseModule
import com.ibrahimalbitar.beautystore.injection.ViewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        setupKoin(this)
    }

    private fun setupKoin(app: Application) {
        startKoin {
            androidContext(app)
            modules(
                listOf(
                    DatabaseModule(),
                    ViewModelsModule()
                )
            )
        }
    }

}