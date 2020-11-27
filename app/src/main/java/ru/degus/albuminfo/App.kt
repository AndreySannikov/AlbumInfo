package ru.degus.albuminfo

import android.app.Application
import ru.degus.albuminfo.di.AppComponent
import ru.degus.albuminfo.di.DaggerAppComponent
import ru.degus.albuminfo.di.modules.AppModule

class App : Application() {

    var name: String? = null
        get() = resources.getString(R.string.app_name)
        private set

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        lateinit var instance: App
            private set

    }
}