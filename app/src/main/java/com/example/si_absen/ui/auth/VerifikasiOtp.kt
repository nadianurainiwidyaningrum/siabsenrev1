package com.example.si_absen.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.navigation.Screen
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerifikasiOtpScreen(
    navController: NavController,
    nik: String
) {

    var otp by remember {
        mutableStateOf("")
    }

    var pesan by remember {
        mutableStateOf("")
    }

    var isError by remember {
        mutableStateOf(false)
    }

    var isLoading by remember {
        mutableStateOf(false)
    }

    var countdown by remember {
        mutableIntStateOf(60)
    }

    var canResend by remember {
        mutableStateOf(false)
    }

   // COUNTDOWN OTP

    LaunchedEffect(Unit) {

        while (countdown > 0) {

            delay(1000)

            countdown--
        }

        canResend = true
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,

        topBar = {

            TopAppBar(
                title = {
                    Column {

                        Text(
                            text = "Verifikasi OTP",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold
                        )

                        Text(
                            text = "Verifikasi keamanan akun",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },

                navigationIcon = {

                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Kembali"
                        )
                    }
                }
            )
        }

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(
                    horizontal = 24.dp,
                    vertical = 20.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

           // ICON

            Surface(
                modifier = Modifier.size(82.dp),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {

                Box(
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.VerifiedUser,
                        contentDescription = "Verifikasi OTP",
                        modifier = Modifier.size(44.dp),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            // TITLE

            Text(
                text = "Verifikasi OTP",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Masukkan kode OTP yang telah dikirim ke WhatsApp Anda.",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

           // NIK

            Surface(
                shape = RoundedCornerShape(50.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {

                Text(
                    text = "NIK: ${maskNik(nik)}",
                    modifier = Modifier.padding(
                        horizontal = 14.dp,
                        vertical = 7.dp
                    ),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            // OTP CARD

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(22.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Masukkan Kode OTP",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "Kode terdiri dari 6 digit angka.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                   // INPUT OTP

                    OutlinedTextField(
                        value = otp,

                        onValueChange = { value ->

                            val filteredValue = value
                                .filter { it.isDigit() }
                                .take(6)

                            otp = filteredValue

                            pesan = ""
                            isError = false
                        },

                        modifier = Modifier.fillMaxWidth(),

                        label = {
                            Text("Kode OTP")
                        },

                        placeholder = {
                            Text("Masukkan 6 digit OTP")
                        },

                        leadingIcon = {

                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        },

                        singleLine = true,

                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),

                        isError = isError,

                        supportingText = {

                            if (isError) {

                                Text(
                                    text = pesan,
                                    color = MaterialTheme.colorScheme.error
                                )
                            }
                        },

                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    // BUTTON VERIFIKASI

                    Button(
                        onClick = {

                            if (otp.length != 6) {

                                pesan = "Masukkan 6 digit kode OTP."
                                isError = true

                            } else {

                                isLoading = true

                                /*
                                 * TODO BACKEND
                                 *
                                 * Verifikasi OTP melalui API.
                                 *
                                 * Backend:
                                 * 1. Cari OTP berdasarkan NIK.
                                 * 2. Cocokkan kode OTP.
                                 * 3. Cek masa berlaku OTP.
                                 * 4. Tandai OTP sudah digunakan.
                                 * 5. Izinkan user mengganti password.
                                 *
                                 * DUMMY:
                                 * OTP benar = 123456
                                 */

                                if (otp == "123456") {

                                    isLoading = false

                                    pesan = ""
                                    isError = false

                                    navController.navigate(
                                        Screen.UbahPassword.createRoute(nik)
                                    )

                                } else {

                                    isLoading = false

                                    pesan =
                                        "Kode OTP salah. Silakan periksa kembali."

                                    isError = true
                                }
                            }
                        },

                        enabled = otp.length == 6 && !isLoading,

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),

                        shape = RoundedCornerShape(12.dp)
                    ) {

                        if (isLoading) {

                            CircularProgressIndicator(
                                modifier = Modifier.size(22.dp),
                                strokeWidth = 2.dp,
                                color = MaterialTheme.colorScheme.onPrimary
                            )

                        } else {

                            Text(
                                text = "VERIFIKASI OTP",
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(18.dp)
                    )

                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant
                    )

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                   // KIRIM ULANG

                    if (canResend) {

                        TextButton(
                            onClick = {

                                /*
                                 * TODO BACKEND
                                 *
                                 * Panggil API untuk:
                                 * - membuat OTP baru
                                 * - menyimpan OTP baru
                                 * - mengatur masa berlaku
                                 * - mengirim OTP ke WhatsApp
                                 */

                                otp = ""
                                pesan = ""
                                isError = false

                                countdown = 60
                                canResend = false
                            }
                        ) {

                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = null
                            )

                            Spacer(
                                modifier = Modifier.width(6.dp)
                            )

                            Text(
                                text = "Kirim Ulang OTP"
                            )
                        }

                    } else {

                        Text(
                            text = "Kirim ulang OTP dalam $countdown detik",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.weight(1f)
            )

            // FOOTER

            Text(
                text = "SI ABSEN",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "Kalurahan Purwobinangun",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = "© 2026 Kalurahan Purwobinangun",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}


// MASK NIK
private fun maskNik(nik: String): String {

    if (nik.length <= 6) {
        return nik
    }

    val depan = nik.take(6)
    val belakang = nik.takeLast(3)

    return "$depan******$belakang"
}