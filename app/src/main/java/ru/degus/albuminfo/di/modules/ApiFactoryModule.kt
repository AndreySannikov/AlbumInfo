package ru.degus.albuminfo.di.modules

import android.util.Log
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import ru.degus.albuminfo.api.ApiFactory
import ru.degus.albuminfo.components.I_TUNS_URL
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiFactoryModule {

    @Singleton              //метод предоставляющий Api с базовым url
    @Provides
    fun apiFactory(@Named("iTunsUrl") iTunsUrl: String, @Named("okhhtp_logging")client: OkHttpClient): ApiFactory {
        return ApiFactory(iTunsUrl, client)
    }

    @Provides
    @Named("iTunsUrl")      //метод предоставляющий базовый url
    fun iTunsUrl() = I_TUNS_URL

    @Provides
    @Named("okhhtp_logging")
    fun getOkHttpClient(): OkHttpClient{
        val c = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            Log.d("OkHttpLogger", it)
        })

        logging.level = HttpLoggingInterceptor.Level.BASIC
        c.addInterceptor(logging)
        return c.build()
    }
}