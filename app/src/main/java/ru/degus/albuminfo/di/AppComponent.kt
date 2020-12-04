package ru.degus.albuminfo.di

import androidx.fragment.app.FragmentActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import ru.degus.albuminfo.App
import ru.degus.albuminfo.di.modules.ActivityModule
import ru.degus.albuminfo.di.modules.AlbumRepoModule
import ru.degus.albuminfo.di.modules.ApiFactoryModule
import ru.degus.albuminfo.fragments.AlbumFragment
import ru.degus.albuminfo.fragments.MainFragment
import ru.degus.albuminfo.viewmodels.AlbumViewModel
import ru.degus.albuminfo.viewmodels.MainViewModel
import javax.inject.Singleton

@Component(
    modules = [
        ApiFactoryModule::class,
        AlbumRepoModule::class
    ]
)
@Singleton
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance
        fun application(appModule: App): Builder
    }

    fun viewModelSubComponentBuilder(): ViewModelSubComponent.Builder                   //методы создания sub компонентов
    fun activitySubComponentBuilder(): ActivitySubComponent.Builder
}

@Subcomponent
interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelSubComponent
    }

    fun inject(vModel: MainViewModel)                                                   //методы инъекции зависимостей во viewModel
    fun inject(vModel: AlbumViewModel)

}

@Subcomponent(modules = [ActivityModule::class])
interface ActivitySubComponent {
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun with(activity: FragmentActivity): Builder

        fun build(): ActivitySubComponent
    }

    fun inject(mainFragment: MainFragment)                                              //методы инъекции зависимостей во фрагменты
    fun inject(albumFragment: AlbumFragment)
}

