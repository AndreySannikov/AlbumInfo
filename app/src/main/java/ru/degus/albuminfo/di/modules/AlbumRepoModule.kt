package ru.degus.albuminfo.di.modules

import dagger.Module
import dagger.Provides
import ru.degus.albuminfo.api.ApiFactory
import ru.degus.albuminfo.repository.album.IAlbumRepo
import ru.degus.albuminfo.repository.album.AlbumRepo
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [ApiFactoryModule::class])
class AlbumRepoModule {

    @Singleton //метод предоставляющий AlbumRepo
    @Provides
    fun getAlbumRepo(apiFactory: ApiFactory): IAlbumRepo {
        return AlbumRepo(apiFactory)
    }

}