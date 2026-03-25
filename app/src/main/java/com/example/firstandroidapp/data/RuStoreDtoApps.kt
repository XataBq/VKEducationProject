package com.example.firstandroidapp.data

import com.example.firstandroidapp.data.remote.dto.AppShortDetailsDto

//val appsDto = listOf(
//    AppShortDetailsDto(
//        id = "1",
//        name = "СберБанк Онлайн",
//        category = "finance",
//        iconUri = "https://static.rustore.ru/imgproxy/qriFjN8OV6VBF4CCbWcxPm7SL0Y0YtMfxTeJSzWZ1Rc/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png@webp",
//        description = "Больше чем банк"
//    ),
//    AppShortDetailsDto(
//        id = "2",
//        name = "Яндекс - с Алисой AI",
//        category = "instruments",
//        iconUri = "https://static.rustore.ru/imgproxy/R_tObRV6q3c-MKTKMVlJu88Iio7UFjrtOC3GQuSJMrE/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/1/20/f1/apk/313257919/content/SCREENSHOT/cb6a4a05-0905-4b97-b182-20eab3274d00.jpg@webp",
//        description = "Быстрый и безопасный браузер"
//    ),
//    AppShortDetailsDto(
//        id = "3",
//        name = "Почта Mail.ru",
//        category = "instruments",
//        iconUri = "https://static.rustore.ru/imgproxy/PwdwPJeeTFjJa8qBiPIwerw43wiL94clWY4A_4oxt48/preset:web_app_icon_62/plain/https://static.rustore.ru/2026/3/11/7c/apk/332223/content/ICON/2ea61211-2ee2-469b-a08e-acc8a9f3b4c6.png@webp",
//        description = "Почтовый клиент для любых ящиков"
//    ),
//    AppShortDetailsDto(
//        id = "4",
//        name = "Яндекс Навигатор",
//        category = "maps",
//        iconUri = "https://static.rustore.ru/imgproxy/P0Em8fwcZIhhOo3WQzCBmTlyT2Q9Xw1FJtx0nEwuEoU/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/595135/content/ICON/32cb5e63-9c59-4280-9a6a-c808113be88f.png@webp",
//        description = "Парковки и заправки по пути"
//    ),
//    AppShortDetailsDto(
//        id = "5",
//        name = "Мой МТС",
//        category = "instruments",
//        iconUri = "https://static.rustore.ru/imgproxy/ycc_vNBYtD70IPhATGiRARVzqBTQHzHlJK5fgR6DCPQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/336831/content/ICON/ea6c9e63-bd7f-486f-ac3f-3e9069ecf018.png@webp",
//        description = "Мой МТС - центр экосистемы МТС"
//    ),
//    AppShortDetailsDto(
//        id = "6",
//        name = "WILDBERRIES",
//        category = "shopping",
//        iconUri = "https://static.rustore.ru/imgproxy/y2kv8VNSzBtyFdyK1Utr4iVkeHOYCLIS2nXAwP4kq4Y/preset:web_app_icon_62/plain/https://static.rustore.ru/2026/2/11/07/apk/234943/content/ICON/b7e12348-1345-45fb-9755-2cf7a866f16f.png@webp",
//        description = "Скидки каждый день"
//    ),
//    AppShortDetailsDto(
//        id = "7",
//        name = "Авито - услуги, работа ,авто",
//        category = "instruments",
//        iconUri = "https://static.rustore.ru/imgproxy/3kyIsz8dzMkXjvQ-DkJXUukrAs81NYxPcIDeymxEqtE/preset:web_app_icon_62/plain/https://static.rustore.ru/2026/1/27/d8/apk/2688703/content/ICON/ea0c42d8-934f-41a6-a3da-89798736f888.png@webp",
//        description = "Услуги, товары, недвижимость, отели"
//    ),
//    AppShortDetailsDto(
//        id = "8",
//        name = "Т-Банк",
//        category = "finance",
//        iconUri = "https://static.rustore.ru/imgproxy/jinnNvWDiuYKlR6rYbP9DedPzELHgbe8opPzXh8k8FE/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/220863/content/ICON/2238e3ca-e3e7-41d0-b037-777ddc637a5b.png@webp",
//        description = "Управляйте финансами онлайн"
//    ),
//    AppShortDetailsDto(
//        id = "9",
//        name = "Газпромбанк",
//        category = "finance",
//        iconUri = "https://static.rustore.ru/imgproxy/NmE_UyxplejCP2ACbDyV10m2c8m_d2K3HU0rfc0lHIo/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/811199/content/ICON/b75f0527-1296-45d0-9735-a2f30de0e17d.png@webp",
//        description = "Все банковские сервисыу вас"
//    ),
//    AppShortDetailsDto(
//        id = "10",
//        name = "ПСБ",
//        category = "finance",
//        iconUri = "https://static.rustore.ru/imgproxy/XthKBKRRdC4evAOTtPOQTqe3CBmPTGR4Ea6UGNtjVnE/preset:web_app_icon_62/plain/https://static.rustore.ru/c4197aa4-c4ef-4097-8732-a81ac74071d6@webp",
//        description = "Мобильный. Удобный. Сделан с любовью"
//    ),
//    AppShortDetailsDto(
//        id = "11",
//        name = "СберБанк Онлайн",
//        category = "finance",
//        iconUri = "https://static.rustore.ru/imgproxy/qriFjN8OV6VBF4CCbWcxPm7SL0Y0YtMfxTeJSzWZ1Rc/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png@webp",
//        description = "Больше чем банк"
//    ),
//    AppShortDetailsDto(
//        id = "12",
//        name = "Яндекс - с Алисой AI",
//        category = "instruments",
//        iconUri = "https://static.rustore.ru/imgproxy/R_tObRV6q3c-MKTKMVlJu88Iio7UFjrtOC3GQuSJMrE/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/1/20/f1/apk/313257919/content/SCREENSHOT/cb6a4a05-0905-4b97-b182-20eab3274d00.jpg@webp",
//        description = "Быстрый и безопасный браузер"
//    ),
//    AppShortDetailsDto(
//        id = "13",
//        name = "Почта Mail.ru",
//        category = "instruments",
//        iconUri = "https://static.rustore.ru/imgproxy/PwdwPJeeTFjJa8qBiPIwerw43wiL94clWY4A_4oxt48/preset:web_app_icon_62/plain/https://static.rustore.ru/2026/3/11/7c/apk/332223/content/ICON/2ea61211-2ee2-469b-a08e-acc8a9f3b4c6.png@webp",
//        description = "Почтовый клиент для любых ящиков"
//    ),
//    AppShortDetailsDto(
//        id = "14",
//        name = "Яндекс Навигатор",
//        category = "maps",
//        iconUri = "https://static.rustore.ru/imgproxy/P0Em8fwcZIhhOo3WQzCBmTlyT2Q9Xw1FJtx0nEwuEoU/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/595135/content/ICON/32cb5e63-9c59-4280-9a6a-c808113be88f.png@webp",
//        description = "Парковки и заправки по пути"
//    ),
//    AppShortDetailsDto(
//        id = "15",
//        name = "Мой МТС",
//        category = "instruments",
//        iconUri = "https://static.rustore.ru/imgproxy/ycc_vNBYtD70IPhATGiRARVzqBTQHzHlJK5fgR6DCPQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/336831/content/ICON/ea6c9e63-bd7f-486f-ac3f-3e9069ecf018.png@webp",
//        description = "Мой МТС - центр экосистемы МТС"
//    ),
//    AppShortDetailsDto(
//        id = "16",
//        name = "WILDBERRIES",
//        category = "shopping",
//        iconUri = "https://static.rustore.ru/imgproxy/y2kv8VNSzBtyFdyK1Utr4iVkeHOYCLIS2nXAwP4kq4Y/preset:web_app_icon_62/plain/https://static.rustore.ru/2026/2/11/07/apk/234943/content/ICON/b7e12348-1345-45fb-9755-2cf7a866f16f.png@webp",
//        description = "Скидки каждый день"
//    ),
//    AppShortDetailsDto(
//        id = "17",
//        name = "Авито - услуги, работа ,авто",
//        category = "instruments",
//        iconUri = "https://static.rustore.ru/imgproxy/3kyIsz8dzMkXjvQ-DkJXUukrAs81NYxPcIDeymxEqtE/preset:web_app_icon_62/plain/https://static.rustore.ru/2026/1/27/d8/apk/2688703/content/ICON/ea0c42d8-934f-41a6-a3da-89798736f888.png@webp",
//        description = "Услуги, товары, недвижимость, отели"
//    ),
//    AppShortDetailsDto(
//        id = "18",
//        name = "Т-Банк",
//        category = "finance",
//        iconUri = "https://static.rustore.ru/imgproxy/jinnNvWDiuYKlR6rYbP9DedPzELHgbe8opPzXh8k8FE/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/220863/content/ICON/2238e3ca-e3e7-41d0-b037-777ddc637a5b.png@webp",
//        description = "Управляйте финансами онлайн"
//    ),
//    AppShortDetailsDto(
//        id = "19",
//        name = "Газпромбанк",
//        category = "finance",
//        iconUri = "https://static.rustore.ru/imgproxy/NmE_UyxplejCP2ACbDyV10m2c8m_d2K3HU0rfc0lHIo/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/811199/content/ICON/b75f0527-1296-45d0-9735-a2f30de0e17d.png@webp",
//        description = "Все банковские сервисыу вас"
//    ),
//    AppShortDetailsDto(
//        id = "20",
//        name = "ПСБ",
//        category = "finance",
//        iconUri = "https://static.rustore.ru/imgproxy/XthKBKRRdC4evAOTtPOQTqe3CBmPTGR4Ea6UGNtjVnE/preset:web_app_icon_62/plain/https://static.rustore.ru/c4197aa4-c4ef-4097-8732-a81ac74071d6@webp",
//        description = "Мобильный. Удобный. Сделан с любовью"
//    ),
//    AppShortDetailsDto(
//        id = "21",
//        name = "СберБанк Онлайн",
//        category = "finance",
//        iconUri = "https://static.rustore.ru/imgproxy/qriFjN8OV6VBF4CCbWcxPm7SL0Y0YtMfxTeJSzWZ1Rc/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png@webp",
//        description = "Больше чем банк"
//    ),
//    AppShortDetailsDto(
//        id = "22",
//        name = "Яндекс - с Алисой AI",
//        category = "instruments",
//        iconUri = "https://static.rustore.ru/imgproxy/R_tObRV6q3c-MKTKMVlJu88Iio7UFjrtOC3GQuSJMrE/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/1/20/f1/apk/313257919/content/SCREENSHOT/cb6a4a05-0905-4b97-b182-20eab3274d00.jpg@webp",
//        description = "Быстрый и безопасный браузер"
//    ),
//    AppShortDetailsDto(
//        id = "23",
//        name = "Почта Mail.ru",
//        category = "instruments",
//        iconUri = "https://static.rustore.ru/imgproxy/PwdwPJeeTFjJa8qBiPIwerw43wiL94clWY4A_4oxt48/preset:web_app_icon_62/plain/https://static.rustore.ru/2026/3/11/7c/apk/332223/content/ICON/2ea61211-2ee2-469b-a08e-acc8a9f3b4c6.png@webp",
//        description = "Почтовый клиент для любых ящиков"
//    ),
//    AppShortDetailsDto(
//        id = "24",
//        name = "Яндекс Навигатор",
//        category = "maps",
//        iconUri = "https://static.rustore.ru/imgproxy/P0Em8fwcZIhhOo3WQzCBmTlyT2Q9Xw1FJtx0nEwuEoU/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/595135/content/ICON/32cb5e63-9c59-4280-9a6a-c808113be88f.png@webp",
//        description = "Парковки и заправки по пути"
//    ),
//    AppShortDetailsDto(
//        id = "25",
//        name = "Мой МТС",
//        category = "instruments",
//        iconUri = "https://static.rustore.ru/imgproxy/ycc_vNBYtD70IPhATGiRARVzqBTQHzHlJK5fgR6DCPQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/336831/content/ICON/ea6c9e63-bd7f-486f-ac3f-3e9069ecf018.png@webp",
//        description = "Мой МТС - центр экосистемы МТС"
//    ),
//    AppShortDetailsDto(
//        id = "26",
//        name = "WILDBERRIES",
//        category = "shopping",
//        iconUri = "https://static.rustore.ru/imgproxy/y2kv8VNSzBtyFdyK1Utr4iVkeHOYCLIS2nXAwP4kq4Y/preset:web_app_icon_62/plain/https://static.rustore.ru/2026/2/11/07/apk/234943/content/ICON/b7e12348-1345-45fb-9755-2cf7a866f16f.png@webp",
//        description = "Скидки каждый день"
//    ),
//    AppShortDetailsDto(
//        id = "27",
//        name = "Авито - услуги, работа ,авто",
//        category = "instruments",
//        iconUri = "https://static.rustore.ru/imgproxy/3kyIsz8dzMkXjvQ-DkJXUukrAs81NYxPcIDeymxEqtE/preset:web_app_icon_62/plain/https://static.rustore.ru/2026/1/27/d8/apk/2688703/content/ICON/ea0c42d8-934f-41a6-a3da-89798736f888.png@webp",
//        description = "Услуги, товары, недвижимость, отели"
//    ),
//    AppShortDetailsDto(
//        id = "28",
//        name = "Т-Банк",
//        category = "finance",
//        iconUri = "https://static.rustore.ru/imgproxy/jinnNvWDiuYKlR6rYbP9DedPzELHgbe8opPzXh8k8FE/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/220863/content/ICON/2238e3ca-e3e7-41d0-b037-777ddc637a5b.png@webp",
//        description = "Управляйте финансами онлайн"
//    ),
//    AppShortDetailsDto(
//        id = "29",
//        name = "Газпромбанк",
//        category = "finance",
//        iconUri = "https://static.rustore.ru/imgproxy/NmE_UyxplejCP2ACbDyV10m2c8m_d2K3HU0rfc0lHIo/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/811199/content/ICON/b75f0527-1296-45d0-9735-a2f30de0e17d.png@webp",
//        description = "Все банковские сервисыу вас"
//    ),
//    AppShortDetailsDto(
//        id = "30",
//        name = "ПСБ",
//        category = "finance",
//        iconUri = "https://static.rustore.ru/imgproxy/XthKBKRRdC4evAOTtPOQTqe3CBmPTGR4Ea6UGNtjVnE/preset:web_app_icon_62/plain/https://static.rustore.ru/c4197aa4-c4ef-4097-8732-a81ac74071d6@webp",
//        description = "Мобильный. Удобный. Сделан с любовью"
//    )
//)