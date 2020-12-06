package ru.degus.albuminfo.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import ru.degus.albuminfo.models.Result
import ru.degus.albuminfo.repository.album.IAlbumRepo
import javax.inject.Inject

class AlbumViewModel: AbstractViewModel() {

    lateinit var collectionId: String  //поле для идентификатора альбома

    @Inject
    lateinit var albumRepo: IAlbumRepo

    val albumData: MutableLiveData<MutableList<Result?>?> by lazy { MutableLiveData<MutableList<Result?>?>() }
    val errorData: MutableLiveData<Throwable> by lazy { MutableLiveData<Throwable>() }

    fun loadAlbum() {                                                           //загрузка альбома по идентификатору
        Log.d("AlbumViewModel", "" + collectionId.toString())
        addDisposable(
            albumRepo.downloadAlbum(collectionId)
                ?.subscribe({
                    Log.d("AlbumViewModel", "size " + it?.results?.size.toString())
                    if (it != null) {
                        albumData.value = it.results
                    }                               //установка списка в значения LiveData
                }, {
                    errorData.value = it
                    Log.d("LoadAlbum", it.toString())
                })
        )
    }
}