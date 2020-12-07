package ru.degus.albuminfo.components

import androidx.recyclerview.widget.DiffUtil
import ru.degus.albuminfo.models.Result

class DiffCallback(private val oldList: List<Result>, private val newList: List<Result>) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].collectionId == newList[newItemPosition].collectionId
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}