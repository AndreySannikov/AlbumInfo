package ru.degus.albuminfo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.degus.albuminfo.App
import ru.degus.albuminfo.R
import ru.degus.albuminfo.components.DiffCallback
import ru.degus.albuminfo.databinding.AlbumItemViewBinding
import ru.degus.albuminfo.models.Result


class MainAdapter(var onAlbumClickListener: OnAlbumClickListener) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var items: List<Result> = ArrayList()


    interface OnAlbumClickListener {   //интерфейс слушатель для клика по элементу
        fun onAlbumClick(id: Int)
    }

    fun setItems(newItems: List<Result>?) {   // установка нового списка в Adapter
        if (newItems != null) {
            val diffResult = DiffUtil.calculateDiff(DiffCallback(items, newItems), false)
            items = newItems
            diffResult.dispatchUpdatesTo(this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {  // создание ViewHolder
        val li = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<AlbumItemViewBinding>(
            li,
            R.layout.album_item_view,
            parent,
            false
        )

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.itemView.setOnClickListener {                                        //обработка клика на элемент списка
            items[position].collectionId?.let { it1 -> onAlbumClickListener.onAlbumClick(it1) }
        }
        holder.bind(items[position])

    }

    override fun getItemCount(): Int = items.size

    class MainViewHolder(private val binding: AlbumItemViewBinding) : RecyclerView.ViewHolder(binding.root){
        var id: Int? = null
        fun bind(item: Result){
            binding.tvName.text = item.collectionCensoredName                   //установка названия альбома
            binding.tvArtist.text = item.artistName                             //установка имени исполнителя

            id = item.collectionId                                              // загрузка изображения альбома
            Glide.with(App.instance)
                .load(item.artworkUrl100)
                .centerCrop()
                .placeholder(R.color.colorImplicitText)
                .into(binding.ivDog)
        }
    }
}