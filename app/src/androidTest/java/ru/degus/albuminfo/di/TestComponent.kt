package ru.degus.albuminfo.di

import dagger.Component
import ru.degus.albuminfo.ModuleTest
import ru.degus.albuminfo.di.modules.AppModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface TestComponent {

    fun inject(test: ModuleTest)

}