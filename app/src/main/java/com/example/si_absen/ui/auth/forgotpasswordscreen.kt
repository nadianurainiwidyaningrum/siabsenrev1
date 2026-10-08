package com.example.si_absen.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.LockReset
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(
    navController: NavController
) {

    var nik by remember {
        mutableStateOf("")
    }

    var pesan by remember {
        mutableStateOf("")
    }

    var isLoading by remember {
        mutableStateOf(false)
    }

    var isSuccess by remember {
        mutableStateOf(false)
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,

        topBar = {

            TopAppBar(
                title = {
                    Column {

                        Text(
                            text = "Lupa Password",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold
                        )

                        Text(
                            text = "Pemulihan akun",
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
                    vertical = 16.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            // =================================================
            // ICON RESET PASSWORD
            // =================================================

            Surface(
                modifier = Modifier.size(82.dp),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {

                Box(
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.LockReset,
                        contentDescription = "Reset Password",
                        modifier = Modifier.size(44.dp),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            // =================================================
            // TITLE
            // =================================================

            Text(
                text = "Lupa Password?",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Jangan khawatir, kami akan membantu Anda mengatur ulang password.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(horizontal = 12.dp)
            )

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            // =================================================
            // CARD PEMULIHAN AKUN
            // =================================================

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
                        .padding(22.dp)
                ) {

                    // =================================================
                    // HEADER VERIFIKASI
                    // =================================================

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Surface(
                            modifier = Modifier.size(44.dp),
                            shape = RoundedCornerShape(14.dp),
                            color = MaterialTheme.colorScheme.primaryContainer
                        ) {

                            Box(
                                contentAlignment = Alignment.Center
                            ) {

                                Icon(
                                    imageVector = Icons.Default.Phone,
                                    contentDescription = "Nomor WhatsApp",
                                    modifier = Modifier.size(25.dp),
                                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        }

                        Spacer(
                            modifier = Modifier.width(12.dp)
                        )

                        Column {

                            Text(
                                text = "Verifikasi melalui WhatsApp",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Text(
                                text = "Kode OTP dikirim ke nomor terdaftar",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    // =================================================
                    // DESKRIPSI
                    // =================================================

                    Text(
                        text = "Masukkan NIK yang terdaftar. Kode OTP akan dikirim ke nomor WhatsApp yang terhubung dengan akun Anda.",

                        style = MaterialTheme.typography.bodyMedium,

                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    // =================================================
                    // INPUT NIK
                    // =================================================

                    OutlinedTextField(
                        value = nik,

                        onValueChange = {

                            nik = it
                                .filter { char -> char.isDigit() }
                                .take(20)

                            pesan = ""
                            isSuccess = false
                        },

                        modifier = Modifier.fillMaxWidth(),

                        label = {
                            Text("NIK Pegawai")
                        },

                        placeholder = {
                            Text("Masukkan NIK")
                        },

                        leadingIcon = {

                            Icon(
                                imageVector = Icons.Default.Badge,
                                contentDescription = null
                            )
                        },

                        singleLine = true,

                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),

                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Pastikan NIK sesuai dengan data akun Anda.",

                        style = MaterialTheme.typography.bodySmall,

                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    // =================================================
                    // BUTTON KIRIM OTP
                    // =================================================

                    Button(
                        onClick = {

                            if (nik.isBlank()) {

                                pesan = "NIK wajib diisi."

                                isSuccess = false

                            } else if (nik.length < 6) {

                                pesan = "NIK tidak valid."

                                isSuccess = false

                            } else {

                                isLoading = true

                                /*
                                 * =================================================
                                 * TODO BACKEND
                                 * =================================================
                                 *
                                 * 1. Cari akun berdasarkan NIK.
                                 *
                                 * 2. Ambil nomor WhatsApp yang terdaftar.
                                 *
                                 * 3. Generate OTP 6 digit.
                                 *
                                 * 4. Simpan OTP beserta waktu expired.
                                 *
                                 * 5. Kirim OTP melalui WhatsApp.
                                 *
                                 * 6. Jika API berhasil, pindah ke halaman OTP.
                                 *
                                 * Contoh:
                                 *
                                 * navController.navigate(
                                 *     Screen.VerifikasiOtp.createRoute(nik)
                                 * )
                                 *
                                 * =================================================
                                 * DUMMY
                                 * =================================================
                                 */

                                isLoading = false

                                isSuccess = true

                                pesan =
                                    "Kode OTP telah dikirim ke WhatsApp yang terdaftar."

                                navController.navigate(
                                    Screen.VerifikasiOtp.createRoute(nik)
                                )
                            }
                        },

                        enabled = !isLoading,

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

                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = "Kirim OTP",
                                modifier = Modifier.size(22.dp)
                            )

                            Spacer(
                                modifier = Modifier.width(8.dp)
                            )

                            Text(
                                text = "KIRIM OTP",

                                style = MaterialTheme.typography.labelLarge,

                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    // PESAN HASIL
                    if (pesan.isNotEmpty()) {

                        Spacer(
                            modifier = Modifier.height(16.dp)
                        )

                        Surface(
                            modifier = Modifier.fillMaxWidth(),

                            shape = RoundedCornerShape(12.dp),

                            color = if (isSuccess) {
                                MaterialTheme.colorScheme.primaryContainer
                            } else {
                                MaterialTheme.colorScheme.errorContainer
                            }
                        ) {

                            Text(
                                text = pesan,

                                modifier = Modifier.padding(12.dp),

                                style = MaterialTheme.typography.bodySmall,

                                color = if (isSuccess) {
                                    MaterialTheme.colorScheme.onPrimaryContainer
                                } else {
                                    MaterialTheme.colorScheme.onErrorContainer
                                }
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    // KEMBALI LOGIN
                    TextButton(
                        onClick = {
                            navController.popBackStack()
                        },

                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )

                        Spacer(
                            modifier = Modifier.width(6.dp)
                        )

                        Text(
                            text = "Kembali ke Login",

                            style = MaterialTheme.typography.labelLarge
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