package com.example.firstandroidapp.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.io.Serial

@Serializable
enum class Category(
    val title: String,
    val aliases: Set<String>
) {
    APP("Приложения", setOf("приложения", "app", "apps")),
    GAME("Игры", setOf("игры", "game", "games")),
    PRODUCTIVITY("Производительность", setOf("производительность", "productivity")),
    SOCIAL("Социальные сети", setOf("социальные сети", "social")),
    EDUCATION("Образование", setOf("образование", "education")),
    ENTERTAINMENT("Развлечения", setOf("развлечения", "entertainment")),
    MUSIC("Музыка", setOf("музыка", "music")),
    HEALTH("Здоровье", setOf("здоровье", "health")),
    SPORTS("Спорт", setOf("спорт", "sports")),
    NEWS("Новости", setOf("новости", "news")),
    BOOKS("Книги", setOf("книги", "books")),
    BUSINESS("Бизнес", setOf("бизнес", "business")),
    FINANCE("Финансы", setOf("финансы", "finance")),
    TRAVEL("Путешествия", setOf("путешествия", "travel")),
    MAPS("Карты", setOf("карты", "maps")),
    SHOPPING("Покупки", setOf("покупки", "shopping")),
    UTILITIES("Утилиты", setOf("утилиты", "utilities")),
    INSTRUMENTS("Инструменты", setOf("инструменты", "tools", "instruments")),
    VIDEO_PHOTOGRAPHY("Фото и видео", setOf("фото и видео", "photo and video", "photo", "video")),
    HEALTH_FITNESS(
        "Здоровье и фитнес",
        setOf("здоровье и фитнес", "health and fitness", "fitness")
    ),
    FOOD_DRINK("Еда и напитки", setOf("еда и напитки", "food and drink", "food", "drink")),
    LIFE_STYLE("Образ жизни", setOf("образ жизни", "lifestyle", "life style")),
    WEATHER("Погода", setOf("погода", "weather")),
    COMMUNICATION("Общение", setOf("общение", "communication", "chat", "messaging")),
    NAVIGATION("Навигация", setOf("навигация", "navigation"));

    companion object {
        fun fromString(value: String): Category {
            val normalized = value.trim().lowercase()

            return entries.firstOrNull { category ->
                normalized == category.title.lowercase() || normalized in category.aliases
            } ?: APP
        }
    }
}