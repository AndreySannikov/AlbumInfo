package ru.degus.albuminfo.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import ru.degus.albuminfo.models.AlbumsInfo

interface ITunsApi {
    @GET("search?entity=album")
    fun getAlbumsInfo(@Query("term")name: String): Observable<AlbumsInfo?>? // get запрос на сервер ищущий альбомы по строке name

    @GET("lookup?entity=song")
    fun getAlbum(@Query("id")collectionId: String): Observable<AlbumsInfo?>? // get запрос на сервер ищущий альбом по его collectionId

    @GET("lookup?entity=song&id=1517894593") // get запрос на сервер ищущий альбом со установленным collectionId, нужен для проверки
    fun getSimple(): Observable<AlbumsInfo?>?
}