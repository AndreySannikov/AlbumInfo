package ru.degus.albuminfo.di.modules

import dagger.Module
import dagger.Provides
import ru.degus.albuminfo.api.ApiFactory
import ru.degus.albuminfo.components.I_TUNS_URL
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiFactoryModule {

    @Singleton              //метод предоставляющий Api с базовым url
    @Provides
    fun apiFactory(@Named("iTunsUrl") iTunsUrl: String): ApiFactory {
        return ApiFactory(iTunsUrl)
    }

    @Provides
    @Named("iTunsUrl")      //метод предоставляющий базовый url
    fun iTunsUrl() = I_TUNS_URL
}