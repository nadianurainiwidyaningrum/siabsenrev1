package com.example.si_absen.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UbahPasswordScreen(
    navController: NavController,
    nik: String
) {

    var passwordBaru by remember {
        mutableStateOf("")
    }

    var konfirmasiPassword by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    var konfirmasiVisible by remember {
        mutableStateOf(false)
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

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {

            TopAppBar(
                title = {
                    Text(
                        text = "Ubah Password",
                        style = MaterialTheme.typography.titleLarge
                    )
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
                .padding(horizontal = 24.dp)
                .padding(top = 20.dp, bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier.size(82.dp),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {

                Box(
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Verifikasi berhasil",
                        modifier = Modifier.size(44.dp),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "Buat Password Baru",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Verifikasi berhasil. Silakan buat password baru untuk akun Anda.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(28.dp)
            )

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

                    Text(
                        text = "Password Baru",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "Gunakan password yang mudah Anda ingat tetapi sulit ditebak orang lain.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    //PASSWORD BARU

                    OutlinedTextField(
                        value = passwordBaru,
                        onValueChange = {

                            passwordBaru = it
                            pesan = ""
                            isError = false
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text("Password Baru")
                        },
                        placeholder = {
                            Text("Masukkan password baru")
                        },
                        leadingIcon = {

                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        },
                        trailingIcon = {

                            IconButton(
                                onClick = {
                                    passwordVisible = !passwordVisible
                                }
                            ) {

                                Icon(
                                    imageVector = if (passwordVisible) {
                                        Icons.Default.VisibilityOff
                                    } else {
                                        Icons.Default.Visibility
                                    },
                                    contentDescription = if (passwordVisible) {
                                        "Sembunyikan password"
                                    } else {
                                        "Tampilkan password"
                                    }
                                )
                            }
                        },
                        visualTransformation = if (passwordVisible) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Minimal 8 karakter dan mengandung angka.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(
                        modifier = Modifier.height(18.dp)
                    )

                    //KONFIRMASI PASSWORD
                    OutlinedTextField(
                        value = konfirmasiPassword,
                        onValueChange = {

                            konfirmasiPassword = it
                            pesan = ""
                            isError = false
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text("Konfirmasi Password")
                        },
                        placeholder = {
                            Text("Masukkan ulang password")
                        },
                        leadingIcon = {

                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        },
                        trailingIcon = {

                            IconButton(
                                onClick = {
                                    konfirmasiVisible = !konfirmasiVisible
                                }
                            ) {

                                Icon(
                                    imageVector = if (konfirmasiVisible) {
                                        Icons.Default.VisibilityOff
                                    } else {
                                        Icons.Default.Visibility
                                    },
                                    contentDescription = if (konfirmasiVisible) {
                                        "Sembunyikan password"
                                    } else {
                                        "Tampilkan password"
                                    }
                                )
                            }
                        },
                        visualTransformation = if (konfirmasiVisible) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                        singleLine = true,
                        isError = isError,
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    // PESAN ERROR

                    if (pesan.isNotEmpty()) {

                        Surface(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            color = if (isError) {
                                MaterialTheme.colorScheme.errorContainer
                            } else {
                                MaterialTheme.colorScheme.primaryContainer
                            }
                        ) {

                            Text(
                                text = pesan,
                                modifier = Modifier.padding(12.dp),
                                style = MaterialTheme.typography.bodySmall,
                                color = if (isError) {
                                    MaterialTheme.colorScheme.onErrorContainer
                                } else {
                                    MaterialTheme.colorScheme.onPrimaryContainer
                                }
                            )
                        }

                        Spacer(
                            modifier = Modifier.height(16.dp)
                        )
                    }

                    //SIMPAN PASSWOR

                    Button(
                        onClick = {

                            when {

                                passwordBaru.isBlank() -> {

                                    pesan = "Password baru wajib diisi."
                                    isError = true
                                }

                                passwordBaru.length < 8 -> {

                                    pesan =
                                        "Password minimal terdiri dari 8 karakter."
                                    isError = true
                                }

                                !passwordBaru.any { it.isDigit() } -> {

                                    pesan =
                                        "Password harus mengandung minimal 1 angka."
                                    isError = true
                                }

                                konfirmasiPassword.isBlank() -> {

                                    pesan =
                                        "Konfirmasi password wajib diisi."
                                    isError = true
                                }

                                passwordBaru != konfirmasiPassword -> {

                                    pesan =
                                        "Konfirmasi password tidak sama."
                                    isError = true
                                }

                                else -> {

                                    isLoading = true

                                    /*
                                     * TODO:
                                     *
                                     * Panggil API ubah password.
                                     *
                                     * Kirim:
                                     * - NIK
                                     * - password baru
                                     *
                                     * Backend:
                                     * 1. Cari akun berdasarkan NIK.
                                     * 2. Hash password baru.
                                     * 3. Update password di database.
                                     * 4. Response berhasil.
                                     *
                                     * Sementara menggunakan dummy.
                                     */

                                    isLoading = false

                                    pesan =
                                        "Password berhasil diubah."
                                    isError = false

                                    /*
                                     * Setelah berhasil,
                                     * kembali ke halaman login
                                     * popUpTo digunakan supaya user tidak bisa kembali ke halaman reset password dengan tombol back.
                                     */

                                    navController.navigate(
                                        Screen.Login.route
                                    ) {

                                        popUpTo(
                                            Screen.ForgotPassword.route
                                        ) {
                                            inclusive = true
                                        }
                                    }
                                }
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

                            Text(
                                text = "SIMPAN PASSWORD",
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier.weight(1f)
            )

            Text(
                text = "SI ABSEN",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary
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