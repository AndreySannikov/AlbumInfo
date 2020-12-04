package ru.degus.albuminfo.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import ru.degus.albuminfo.models.Result
import ru.degus.albuminfo.repository.album.IAlbumRepo
import javax.inject.Inject

class MainViewModel : AbstractViewModel() {
    @Inject
    lateinit var albumRepo: IAlbumRepo

    var requestText = ""  //поле для строки запроса из editText

    val albumsData: MutableLiveData<List<Result>?> by lazy { MutableLiveData<List<Result>?>() }
    val errorData: MutableLiveData<Throwable> by lazy { MutableLiveData<Throwable>() }


    fun downloadAlbums() {                                   //загрузка списка альбомов по строке из editText
        addDisposable(
            albumRepo.downloadAlbumsInfo(requestText)
                ?.subscribe({
                    Log.d("LoadAlbum", it?.results?.size.toString())
                    albumsData.value = sort(it?.results)         //установка списка альбомов в значение LiveData
                }, {
                    errorData.value = it
                    Log.d("LoadAlbum", it.toString())
                })
        )
    }

    private fun sort(list: MutableList<Result>?): List<Result>? {        //проверка списка альбомов на соответсвие поиска по названию альбома
        list?.removeAll { x -> !x.collectionCensoredName.contains(requestText, ignoreCase = true) }  //так как Api не предусматривает такого поиска
        return list?.sortedBy { it.collectionCensoredName }              //сортировка списка альбомов по алфавиту
    }
}