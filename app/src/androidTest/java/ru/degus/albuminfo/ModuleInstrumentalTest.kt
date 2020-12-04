package ru.degus.albuminfo

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.assertEquals
import okhttp3.mockwebserver.MockWebServer
import org.junit.*
import org.junit.runner.RunWith
import ru.degus.albuminfo.api.ApiFactory
import ru.degus.albuminfo.di.DaggerTestComponent
import ru.degus.albuminfo.di.TestComponent
import ru.degus.albuminfo.models.AlbumsInfo
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class ModuleInstrumentalTest {

    companion object {

        private lateinit var webServer: MockWebServer
        const val TAG = "ModuleInstrumentalTest"

        @BeforeClass
        @JvmStatic
        fun setup() {
            Log.d(TAG, "start setup")
            webServer = MockWebServer()
            webServer.start()
        }

        @AfterClass
        @JvmStatic
        fun tearDown() {
            webServer.shutdown()
        }
    }

    @Inject
    lateinit var app: App

    @Inject
    lateinit var apiFactory: ApiFactory

    @Before
    fun before() {
        val testComponent: TestComponent = DaggerTestComponent.builder()
            .appModule(AppModule(App.instance))
            .build()
        testComponent.inject(this)
    }

    @After
    fun after() {

    }

    @Test
    fun appName() {
        assertEquals(app.name, "AlbumInfo")
    }

    @Test
    fun  iTunsRepositoryTest() {
        val observer = TestObserver<AlbumsInfo>()
        apiFactory.getITUnsApi().getAlbumsInfo("Recovery")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
        observer.awaitTerminalEvent()
        observer.assertValueCount(1)
    }
}