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
        in 3601..86400 -> "${secondsByHours(time)} назад"
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

    return if (minutes % 10 == 1 && minutes % 100 != 11) {
        "$minutes минуту"
    } else if (minutes % 10 in 2..4) {
        "$minutes минуты"
    } else {
        "$minutes минут"
    }
}

fun secondsByHours(time: Int): String {

    var hours: Int = 0
    if (time % 3600 == 0) {
        hours = time / 3600
    } else {
        hours = (time / 3600).toInt() + 1
    }

    return if (hours % 10 == 1 && hours % 100 != 11) {
        "$hours час"
    } else if (hours % 10 in 2..4) {
        "$hours часа"
    } else {
        "$hours часов"
    }
}