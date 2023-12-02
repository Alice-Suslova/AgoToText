package ru.netology

fun main() {
    val time = 18001
    println(agoToText(time))
}

fun agoToText(time: Int): String {
    val firstPartOfResult = "был(а)"
    var secondPartOfResult = when (time) {

        in 0..60 -> "только что"
        in 61..3600 -> "${secondsByMinutes(time)} назад"
        in 3601..86400 -> "${minutesByHours(time)} назад"
        in 86401..172800 -> "вчера"
        in 172801..259200 -> "позавчера"
        else -> "давно"
    }

    return "$firstPartOfResult $secondPartOfResult"
}


fun secondsByMinutes(time: Int): String {

    var minutes: Int = 0
    if (time % 60 == 0) {
        minutes = time / 60
    } else {
        minutes = (time / 60).toInt() + 1
    }

    var result = when (minutes) {
        1 -> "минут"
        2 -> "минуты"
        3 -> "минуты"
        4 -> "минуты"
        else -> "минут"
    }
    return "$minutes $result"
}

fun minutesByHours(time: Int): String {

    var hours: Int = 0
    if (time % 3600 == 0) {
        hours = time / 3600
    } else {
        hours = (time / 3600).toInt() + 1
    }

    var result = when (hours) {
        1 -> "час"
        2 -> "часа"
        3 -> "часа"
        4 -> "часа"
        else -> "часов"
    }
    return "$hours $result"
}