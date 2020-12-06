package ru.degus.albuminfo.models

import java.io.Serializable
//класс запроса получаемый из сети
data class AlbumsInfo(
    val resultCount: Int?,
    val results: MutableList<Result?>?
) : Serializable