package com.example.myweatherapp.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val backgroundLightBlue = Color(0xFF87CEFA)
val HeaderDarkBlue = Color(0xFF060414)
val BlurBlue32pre = Color(0x5200619D)
val IcondarkRed = Color(0xFF323232)
val boxBackgroundwhite70pre = Color(0xB3FFFFFF)

val contentDarkBlue60pre = Color(0x99060414)
val ButtonsdarkBlue8pre = Color(0x14060414)
val verticaldarkBlue24pre = Color(0x3D060414)
val header2darkBlue87pre = Color(0xDE060414)


data class ThemeColor(
    val backgroundLightBlue: Color,
    val background2: Color,
    val HeaderDarkBlue: Color,
    val BlurBlue32pre: Color,
    val IcondarkRed: Color,
    val boxBackgroundwhite70pre: Color,
    val contentDarkBlue60pre: Color,
    val ButtonsdarkBlue8pre: Color,
    val verticaldarkBlue24pre: Color,
    val header2darkBlue87pre: Color,
)

fun appTheme(isDay: Boolean): ThemeColor{
    if (isDay){
        return ThemeColor(
            backgroundLightBlue = Color(0xFF87CEFA),
            background2 = Color(0xFFFFFFFF),
            HeaderDarkBlue = Color(0xFF060414),
            BlurBlue32pre = Color(0x5200619D),
            IcondarkRed = Color(0xFF323232),
            boxBackgroundwhite70pre = Color(0xB3FFFFFF),
            contentDarkBlue60pre = Color(0x99060414),
            ButtonsdarkBlue8pre = Color(0x14060414),
            verticaldarkBlue24pre = Color(0x3D060414),
            header2darkBlue87pre = Color(0xDE060414)
        )
    }
    return ThemeColor(
        backgroundLightBlue = Color(0xFF1E1E1E),
        background2 = Color(0xFF0D0C19),
        HeaderDarkBlue = Color(0xFFFFFFFF),
        BlurBlue32pre = Color(0x80C0B7FF),
        IcondarkRed = Color(0xFFFFFFFF),
        boxBackgroundwhite70pre = Color(0xB3060414),
        contentDarkBlue60pre = Color(0x99FFFFFF),
        ButtonsdarkBlue8pre = Color(0x14FFFFFF),
        verticaldarkBlue24pre = Color(0x3DFFFFFF),
        header2darkBlue87pre = Color(0xDEFFFFFF)
    )
}