package com.ibrahimalbitar.beautystore.injection

import com.ibrahimalbitar.beautystore.vvm.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object ViewModelsModule : () -> Module {
    override fun invoke(): Module = module {
        viewModel { MainViewModel(get()) }
    }

}