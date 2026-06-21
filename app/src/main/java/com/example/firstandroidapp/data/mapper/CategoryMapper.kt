package com.example.firstandroidapp.data.mapper

import com.example.firstandroidapp.domain.Category

class CategoryMapper {
    fun map(category: String): Category {
        return when (category.trim().lowercase()) {
            "приложения", "app", "apps" -> Category.APP
            "игры", "game", "games" -> Category.GAME
            "производительность", "productivity" -> Category.PRODUCTIVITY
            "социальные сети", "social" -> Category.SOCIAL
            "образование", "education" -> Category.EDUCATION
            "развлечения", "entertainment" -> Category.ENTERTAINMENT
            "музыка", "music" -> Category.MUSIC
            "видео", "video" -> Category.VIDEO
            "фотография", "photo", "photography" -> Category.PHOTOGRAPHY
            "здоровье", "health" -> Category.HEALTH
            "спорт", "sports" -> Category.SPORTS
            "новости", "news" -> Category.NEWS
            "книги", "books" -> Category.BOOKS
            "бизнес", "business" -> Category.BUSINESS
            "финансы", "finance" -> Category.FINANCE
            "путешествия", "travel" -> Category.TRAVEL
            "карты", "maps" -> Category.MAPS
            "еда", "food" -> Category.FOOD
            "покупки", "shopping" -> Category.SHOPPING
            "утилиты", "utilities" -> Category.UTILITIES
            "инструменты", "tools", "instruments" -> Category.INSTRUMENTS
            else -> Category.APP
        }
    }
}