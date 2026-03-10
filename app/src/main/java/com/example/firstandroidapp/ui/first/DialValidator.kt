package com.example.firstandroidapp.ui.first

//Смотрим есть ли в строке ввода хотя бы одна цифры
fun phoneNumberValidation(number: String): Boolean {
    val value = number.trim()
    if (value.isEmpty()) return false

    return value.any { it.isDigit() }
}

//Убираем все лишнее из строки ввода, оставляя только символы часто используемые в номере
fun correctPhoneNumberInput(number: String): String {
    val trimmed = number.trim()

    val result = StringBuilder()

    trimmed.forEachIndexed { index, ch ->
        when {
            ch.isDigit() -> result.append(ch)
            ch == '+' && index == 0 -> result.append(ch)
            ch == '#' || ch == '*' -> result.append(ch)
        }
    }

    return result.toString()
}