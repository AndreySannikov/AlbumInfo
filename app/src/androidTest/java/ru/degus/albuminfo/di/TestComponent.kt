package ru.degus.albuminfo.di

import dagger.Component
import ru.degus.albuminfo.ModuleInstrumentalTest
import ru.degus.albuminfo.di.modules.ApiFactoryModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiFactoryModule::class
    ]
)
interface TestComponent {

    fun inject(instrumentalTest: ModuleInstrumentalTest)

}