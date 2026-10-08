package com.example.si_absen.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    secondary = SecondaryBlue,

    background = BackgroundLight,
    surface = SurfaceLight,

    surfaceVariant = Color(0xFFEFF3F8),

    primaryContainer = Color(0xFFD6E7FF),
    onPrimaryContainer = Color(0xFF00315C),

    secondaryContainer = Color(0xFFD9E9FF),
    onSecondaryContainer = Color(0xFF003258),

    onPrimary = Color.White,
    onSecondary = Color.White,

    onBackground = TextPrimary,
    onSurface = TextPrimary,
    onSurfaceVariant = TextSecondary,

    outline = Color(0xFF9AA6B2),
    outlineVariant = Color(0xFFD9E0E7),

    error = ErrorRed,
    onError = Color.White
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF90CAF9),
    onPrimary = Color(0xFF003258),

    secondary = Color(0xFF90CAF9),
    onSecondary = Color(0xFF003258),

    background = Color(0xFF101418),
    onBackground = Color(0xFFE7EDF3),

    surface = Color(0xFF181D23),
    onSurface = Color(0xFFE7EDF3),

    surfaceVariant = Color(0xFF252C34),
    onSurfaceVariant = Color(0xFFB8C2CC),

    primaryContainer = Color(0xFF174A78),
    onPrimaryContainer = Color(0xFFD6E7FF),

    secondaryContainer = Color(0xFF21435F),
    onSecondaryContainer = Color(0xFFD9E9FF),

    outline = Color(0xFF87929D),
    outlineVariant = Color(0xFF3B444D),

    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005)
)

@Composable
fun SiabsenTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = androidx.compose.ui.platform.LocalContext.current

            if (darkTheme) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}