package ru.degus.albuminfo.api

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

//класс фабрика для создания Retrofit
class ApiFactory(private val iTunsUrl: String, private val client: OkHttpClient) {

    private inline fun <reified T> getApi(baseUrl: String): T { //создание Retrofit cо стандартными параметрами
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(T::class.java)
    }

    fun getITUnsApi(): ITunsApi = getApi(iTunsUrl) // метод возвращающий Api с url "https://itunes.apple.com/"

}