package com.example.si_absen.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {

    LaunchedEffect(Unit) {
        delay(2500)

        navController.navigate(
            Screen.Login.route
        ) {
            popUpTo(0)
        }
    }

    val colorScheme = MaterialTheme.colorScheme

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorScheme.primary,
                        colorScheme.secondary
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            // APP ICON


            Box(
                modifier = Modifier
                    .size(92.dp)
                    .clip(RoundedCornerShape(26.dp))
                    .background(
                        color = colorScheme.surface.copy(alpha = 0.16f)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(
                            color = colorScheme.surface
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.Badge,
                        contentDescription = "SI ABSEN",
                        tint = colorScheme.primary,
                        modifier = Modifier.size(36.dp)
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            // APP NAME

            Text(
                text = "SI ABSEN",
                color = colorScheme.onPrimary,
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Sistem Informasi Absensi Pegawai",
                color = colorScheme.onPrimary.copy(alpha = 0.9f),
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = "Kalurahan Purwobinangun",
                color = colorScheme.onPrimary.copy(alpha = 0.75f),
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(
                modifier = Modifier.height(36.dp)
            )

           // LOADING

            CircularProgressIndicator(
                modifier = Modifier.size(32.dp),
                color = colorScheme.onPrimary,
                strokeWidth = 3.dp
            )

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            Text(
                text = "Memuat aplikasi...",
                color = colorScheme.onPrimary.copy(alpha = 0.8f),
                style = MaterialTheme.typography.bodySmall
            )
        }

       // COPYRIGHT

        Text(
            text = "© Kalurahan Purwobinangun",
            color = colorScheme.onPrimary.copy(alpha = 0.7f),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )
    }
}