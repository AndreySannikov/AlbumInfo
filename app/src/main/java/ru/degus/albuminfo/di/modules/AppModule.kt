package ru.degus.albuminfo.di.modules

import dagger.Module
import dagger.Provides
import ru.degus.albuminfo.App

@Module
class AppModule(private val app: App) {

    @Provides
    internal fun app(): App {
        return app
    }

}