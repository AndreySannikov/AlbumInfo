package ru.degus.albuminfo.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import ru.degus.albuminfo.App
import ru.degus.albuminfo.R
import ru.degus.albuminfo.adapters.AlbumAdapter
import ru.degus.albuminfo.databinding.AlbumFragmentBinding
import ru.degus.albuminfo.models.Result
import ru.degus.albuminfo.viewmodels.AlbumViewModel
import javax.inject.Inject
import ru.degus.albuminfo.components.*

class AlbumFragment : BaseFragment<AlbumFragmentBinding>(R.layout.album_fragment) {
    override fun injectDagger() {
        App.instance.getAppComponent()
            .activitySubComponentBuilder()
            .with(navigator as FragmentActivity)
            .build()
            .inject(this)

        App.instance.getViewModelSubComponent().inject(viewModel)
    }

    @Inject
    lateinit var viewModel: AlbumViewModel                                          //инъекция AlbumViewModel

    lateinit var adapter: AlbumAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        createRecyclerView()                                                        //создания recyclerView с переферией
        binding.viewModel = viewModel                                               //привязка viewModel

        viewModel.errorData.observe(viewLifecycleOwner,                             //подписка на изменение errorData
            Observer {
                showInformDialog("Error", it.message) {
                    navigator.closeApp()                                            //закрытия приложения, если возникает ошибка в получении запроса
                }
            }
        )

        viewModel.albumData.observe(viewLifecycleOwner,                   //подписка на изменение albumData
            Observer {
                if (it != null)                                           //получение нового списка
                setItems(it)
            }
        )

        val album = arguments?.getString("album")                      //получение строки из MainFragmenta
        Log.d("onArgument", album.toString())
        if (album != null) {
            viewModel.collectionId = album                          //установка нового id альбома для поиска
            binding.viewModel?.loadAlbum()                                  //вызов поиска альбома
        }

    }

    @SuppressLint("SetTextI18n")
    private fun setItems(results: MutableList<Result?>?) {                                    //метод в котором осуществляется привязка
        if (results != null) {                                                               //данных первого элемента списка, являющегося альбомом,
            binding.tvAlbumName.text = results[0]?.collectionCensoredName                      //к элементам View фрагмента
            binding.tvArtistName.text = results[0]?.artistName
            binding.tvGenre.text = "${results[0]?.primaryGenreName?.toUpperCase()} • ${results[0]?.releaseDate?.releaseYear()}"
            binding.tvLink.text = results[0]?.collectionViewUrl
                                                                                              //создание строки описания альбома через конкатенацию
            binding.tvDescription.text = """${results[0]?.trackCount} SONGS                     
            |RELEASED ${
                results[0]?.releaseDate?.releaseMonth()?.presentationMonth()?.toUpperCase()
            } ${results[0]?.releaseDate?.releaseDay()}, ${results[0]?.releaseDate?.releaseYear()}
            |RIAA ${if(results[0]?.contentAdvisoryRating != null) results[0]?.contentAdvisoryRating else "not"}
            |${results[0]?.copyright?.toUpperCase()}""".trimMargin()


            Glide.with(App.instance)                                                        //загрузка изображения альбома
                .load(results[0]?.artworkUrl100)
                .centerCrop()
                .placeholder(R.color.colorPrimaryDark)
                .into(binding.ivAlbum)

            adapter.setItems(sort(results))                                                 //сортировка списка
        }
    }

    private fun createRecyclerView() {                                      //создание recyclerView
        val llm = LinearLayoutManager(navigator as Context)
        binding.rvCurrentAlbum.layoutManager = llm

        adapter = AlbumAdapter()
        binding.rvCurrentAlbum.adapter = adapter
        binding.rvCurrentAlbum.addItemDecoration(DividerItemDecoration(navigator as Context,LinearLayoutManager.VERTICAL))
    }

    private fun sort(list: MutableList<Result?>?): List<Result?> {             //удаление из списка первого элемента являющегося альбомом,
        list?.removeAll { x -> x?.wrapperType == "collection" }               //так как при поиске по id альбома, приходит список первым элементом которого является сам альбом
        if (list != null) {
            return list.sortedBy { it?.collectionCensoredName }
        }
        return arrayListOf() //сортировка списка по алфавиту
    }
}