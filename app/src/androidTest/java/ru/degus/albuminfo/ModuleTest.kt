package ru.degus.albuminfo

import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.Assert.assertEquals
import org.junit.*
import org.junit.runner.RunWith
import ru.degus.albuminfo.di.DaggerTestComponent
import ru.degus.albuminfo.di.TestComponent
import ru.degus.albuminfo.di.modules.AppModule
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class ModuleTest {

    companion object {
        @BeforeClass
        @JvmStatic
        fun setup() {

        }

        @AfterClass
        @JvmStatic
        fun tearDown() {

        }
    }

    @Inject
    lateinit var app: App

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

}