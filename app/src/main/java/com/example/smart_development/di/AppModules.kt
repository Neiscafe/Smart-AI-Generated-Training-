package com.example.smart_development.di

import com.example.smart_development.network.RetrofitInit
import com.example.smart_development.repository.Repository
import com.example.smart_development.repository.RepositoryImpl
import com.example.smart_development.viewmodel.MainScreenViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val retrofitModule = module{
    single { RetrofitInit.create(androidContext())}
}

val repositoryModule = module {
    single<Repository> { RepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModel { MainScreenViewModel(get()) }
}

val appModules = listOf(viewModelModule, repositoryModule, retrofitModule)