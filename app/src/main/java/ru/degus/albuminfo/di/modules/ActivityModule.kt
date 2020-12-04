package ru.degus.albuminfo.di.modules

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import ru.degus.albuminfo.viewmodels.AlbumViewModel
import ru.degus.albuminfo.viewmodels.MainViewModel


@Module
class ActivityModule {

    @Provides       //Метод предоставляющий MainViewModel
    fun getMainViewModel(activity: FragmentActivity): MainViewModel {
        return ViewModelProvider(activity).get(MainViewModel::class.java)
    }

    @Provides      //Метод предоставляющий AlbumViewModel
    fun getAlbumViewModel(activity: FragmentActivity): AlbumViewModel {
        return ViewModelProvider(activity).get(AlbumViewModel::class.java)
    }
}