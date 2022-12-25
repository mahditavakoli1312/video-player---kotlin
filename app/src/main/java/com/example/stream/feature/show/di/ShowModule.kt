package com.example.stream.feature.show.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stream.core.common.CustomViewModelFactory
import com.example.stream.core.di.ViewModelKey
import com.example.stream.feature.show.data.datasource.local.ShowLocalDataSource
import com.example.stream.feature.show.data.datasource.local.ShowLocalDataSourceImpl
import com.example.stream.feature.show.data.repository.ShowRepository
import com.example.stream.feature.show.data.repository.ShowRepositoryImpl
import com.example.stream.feature.show.ui.ShowViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ShowModule {
    @Binds
    abstract fun bindShowLocalDataSource(impl: ShowLocalDataSourceImpl): ShowLocalDataSource

    @Binds
    abstract fun bindShowRepository(impl: ShowRepositoryImpl): ShowRepository

    @Binds
    abstract fun bindCustomViewModelFactory(customViewModelFactory: CustomViewModelFactory)
            : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ShowViewModel::class)
    internal abstract fun bindAddReportViewModel(viewModel: ShowViewModel): ViewModel

}