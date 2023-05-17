package com.example.smart_development.di

import com.example.smart_development.feature_training_session.data.network.RetrofitInit
import com.example.smart_development.feature_training_session.data.repository.Repository
import com.example.smart_development.feature_training_session.data.repository.RepositoryImpl
import com.example.smart_development.feature_training_session.domain.repository.CreateTraining
import com.example.smart_development.feature_training_session.domain.repository.GetTraining
import com.example.smart_development.feature_training_session.presentation.new_training_session.NewTrainingSessionViewModel
import com.example.smart_development.feature_training_session.presentation.training_sessions.TrainingSessionsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val retrofitModule = module {
    single { RetrofitInit.create(androidContext()) }
}

val repositoryModule = module {
    single<Repository> { RepositoryImpl(get()) }
    single { GetTraining(get()) }
    single { CreateTraining(get()) }
}

val viewModelModule = module {
    viewModel { TrainingSessionsViewModel(get()) }
    viewModel { NewTrainingSessionViewModel(get()) }
}

val appModules = listOf(viewModelModule, repositoryModule, retrofitModule)