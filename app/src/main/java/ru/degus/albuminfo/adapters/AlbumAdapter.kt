package ru.degus.albuminfo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.degus.albuminfo.App
import ru.degus.albuminfo.R
import ru.degus.albuminfo.components.timeToString
import ru.degus.albuminfo.databinding.TrackItemViewBinding
import ru.degus.albuminfo.models.Result

class AlbumAdapter : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    private var items: List<Result> = ArrayList()


    fun setItems(items:List<Result>) { // установка нового списка в Adapter
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder { // создание ViewHolder
        val li = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<TrackItemViewBinding>(li, R.layout.track_item_view, parent, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class AlbumViewHolder(private val binding: TrackItemViewBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: Result){
            binding.tvName.text = item.trackCensoredName                        //установка названия трека
            binding.tvTime.text = timeToString(item.trackTimeMillis.toLong())   //установка продлжительности трека

            Glide.with(App.instance)                                            //загрузка изображения трека
                .load(item.artworkUrl100)
                .centerCrop()
                .placeholder(R.color.colorPrimaryDark)
                .into(binding.ivDog)
        }
    }
}