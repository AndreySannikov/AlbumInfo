package ru.degus.albuminfo.fragments

import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakewharton.rxbinding4.widget.textChangeEvents
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import ru.degus.albuminfo.App
import ru.degus.albuminfo.R
import ru.degus.albuminfo.activities.Layout
import ru.degus.albuminfo.adapters.MainAdapter
import ru.degus.albuminfo.databinding.MainFragmentBinding
import ru.degus.albuminfo.models.Result
import ru.degus.albuminfo.viewmodels.MainViewModel
import javax.inject.Inject


class MainFragment : BaseFragment<MainFragmentBinding>(R.layout.main_fragment) {
    override fun injectDagger() {
        App.instance.getAppComponent()
            .activitySubComponentBuilder()
            .with(navigator as FragmentActivity)
            .build()
            .inject(this)

        App.instance.getViewModelSubComponent().inject(viewModel)
    }

    @Inject
    lateinit var viewModel: MainViewModel                                           //инъекция MainViewModel

    lateinit var adapter: MainAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewModel = viewModel

        createRecyclerView()                                                    //создания recyclerView с переферией

        observeViewModel()                                                      //подписка на изменения состаяния viewModel

        binding.etSearch.textChangeEvents()                                         //отслеживание изменения editText
            .debounce(700, java.util.concurrent.TimeUnit.MILLISECONDS)      //задержка запроса при быстром изменении текста
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                viewModel.downloadAlbums()                                      //вызов метода поиска новых альбомов
            }
    }

    private fun observeViewModel() {
        viewModel.errorData.observe(viewLifecycleOwner,
            Observer {
                showInformDialog("Error", it.message) {
                    navigator.closeApp()                                        //закрытия приложения при ошибке в получении запроса
                }
            }
        )

        viewModel.albumsData.observe(viewLifecycleOwner,
            Observer {
                if (it != null)
                setItems(it)                                //установка нового списка в recyclerView при удачной загрузке списка альбомов
            }
        )
    }

    private fun setItems(results: List<Result>) {
        if(results.isEmpty()) binding.tvNoFind.visibility = View.VISIBLE
        else binding.tvNoFind.visibility = View.INVISIBLE
        adapter.setItems(results)                               //установка нового списка
    }

    private fun createRecyclerView() {                                          //создание recyclerView
        val llm = LinearLayoutManager(navigator as Context)
        binding.rvDownloadAlbums.layoutManager = llm

        val onAlbumClickListener: MainAdapter.OnAlbumClickListener = object : MainAdapter.OnAlbumClickListener { // реализация интерфейса слушателя клика по элементу списка
            override fun onAlbumClick(id: Int) {
                Log.d("onClick", id.toString())
                navigator.navigateTo(Layout.ALBUM, "album" to id.toString())            //переход в AlbumFragment и передача в него индификатора альбома
            }

        }

        adapter = MainAdapter(onAlbumClickListener)
        binding.rvDownloadAlbums.adapter = adapter
        binding.rvDownloadAlbums.addItemDecoration(DividerItemDecoration(navigator as Context,LinearLayoutManager.VERTICAL))
    }
}