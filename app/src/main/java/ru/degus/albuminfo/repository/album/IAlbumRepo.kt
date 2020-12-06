package ru.degus.albuminfo.repository.album


import io.reactivex.Observable
import ru.degus.albuminfo.models.AlbumsInfo

interface IAlbumRepo {
    fun downloadAlbumsInfo(name: String): Observable<AlbumsInfo?>?  //загрузка списка альбомов по строке name
    fun downloadAlbum(collectionId: String): Observable<AlbumsInfo?>? //загрузка альбома по его идентификатору
}