package ru.degus.albuminfo.components

fun String.releaseYear(): String {                                      //метод обрезки строки для получения года релиза "2010-01-01T08:00:00Z"
    return this.substringBefore("-")
}

fun String.releaseMonth(): String {
    return this.substringAfter("-").substringBefore("-")  //метод обрезки строки для получения месяца "2010-01-01T08:00:00Z"
}

fun String.releaseDay(): String {
    return this.substringAfterLast("-").substringBefore("T") //метод получения строки для получения дня "2010-01-01T08:00:00Z"
}

fun String.presentationMonth(): String {            //метод представляющий число месяца словом
    return when (this.releaseMonth()) {
        "01" -> "January"
        "02" -> "February"
        "03" -> "March"
        "04" -> "April"
        "05" -> "May"
        "06" -> "June"
        "07" -> "July"
        "08" -> "August"
        "09" -> "September"
        "10" -> "October"
        "11" -> "November"
        "12" -> "December"
        else -> "incorrect date"
    }
}

fun timeToString(ms: Long): String {                            //метод для перевода милисекунд в формат минута:секунда
    val secs = ms / 1000
//    val hour = secs / 3600
    val min = secs / 60 % 60
    val sec = secs / 1 % 60
    return String.format("%02d:%02d", min, sec)
}

