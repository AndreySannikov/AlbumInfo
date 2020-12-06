package ru.degus.albuminfo.repository.album


import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.degus.albuminfo.api.ApiFactory
import ru.degus.albuminfo.models.AlbumsInfo


class AlbumRepo(val apiFactory: ApiFactory) : IAlbumRepo {

    override fun downloadAlbumsInfo(name: String): Observable<AlbumsInfo?>? {       //получения списка альбомов по строке
        return apiFactory.getITUnsApi().getAlbumsInfo(name)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
    }

    override fun downloadAlbum(collectionId: String): Observable<AlbumsInfo?>? {
        return if (collectionId != null) {
            apiFactory.getITUnsApi().getAlbum(collectionId)         //получение альбома по идентификатору
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
        } else {
            apiFactory.getITUnsApi().getSimple()                    //если идентификатора нет, запрос альбома с уже установленным идентификатором
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
        }
    }
}