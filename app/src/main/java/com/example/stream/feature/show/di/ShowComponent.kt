package com.example.stream.feature.show.di

import com.example.stream.feature.show.ShowFragment
import dagger.Component

@Component(
    modules = [ShowModule::class],
)
interface ShowComponent {
    fun inject(showFragment: ShowFragment)

    @Component.Factory
    interface Factory {
        fun create(
        ): ShowComponent
    }
}