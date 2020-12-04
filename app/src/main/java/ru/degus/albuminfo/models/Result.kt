package ru.degus.albuminfo.models

import java.io.Serializable
//объект списка, получаемый из сети
data class Result(
    val amgArtistId: Int,
    val artistId: Int,
    val artistName: String,
    val artistViewUrl: String,
    val artworkUrl100: String,
    val artworkUrl60: String,
    val collectionCensoredName: String,
    val collectionExplicitness: String,
    val collectionId: Int,
    val collectionName: String,
    val collectionPrice: Double,
    val collectionType: String,
    val collectionViewUrl: String,
    val contentAdvisoryRating: String,
    val copyright: String,
    val country: String,
    val currency: String,
    val primaryGenreName: String,
    val releaseDate: String,
    val trackCount: Int,
    val trackCensoredName: String,
    val trackTimeMillis: Int,
    val wrapperType: String
) : Serializable