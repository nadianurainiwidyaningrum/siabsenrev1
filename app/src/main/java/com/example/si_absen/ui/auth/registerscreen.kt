package com.example.si_absen.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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

@Composable
fun RegisterScreen(
    navController: NavController
) {

    var nik by remember {
        mutableStateOf("")
    }

    var nama by remember {
        mutableStateOf("")
    }

    var password by remember {
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

    var errorMessage by remember {
        mutableStateOf("")
    }

    var isLoading by remember {
        mutableStateOf(false)
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.Center
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(28.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                   // HEADER

                    Surface(
                        modifier = Modifier.size(76.dp),
                        shape = RoundedCornerShape(22.dp),
                        color = MaterialTheme.colorScheme.primaryContainer
                    ) {

                        Box(
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Registrasi",
                                modifier = Modifier.size(38.dp),
                                tint = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(18.dp)
                    )

                    Text(
                        text = "Buat Akun",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "Registrasi akun pegawai SI ABSEN",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Text(
                        text = "Kalurahan Purwobinangun",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(
                        modifier = Modifier.height(28.dp)
                    )

                  // NIK

                    OutlinedTextField(
                        value = nik,
                        onValueChange = {

                            nik = it.filter { char ->
                                char.isDigit()
                            }

                            errorMessage = ""
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text("NIK")
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
                        isError = errorMessage.isNotEmpty(),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )
                    // NAMA

                    OutlinedTextField(
                        value = nama,
                        onValueChange = {

                            nama = it
                            errorMessage = ""
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text("Nama Lengkap")
                        },
                        placeholder = {
                            Text("Masukkan nama lengkap")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null
                            )
                        },
                        singleLine = true,
                        isError = errorMessage.isNotEmpty(),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                   // PASSWORD

                    OutlinedTextField(
                        value = password,
                        onValueChange = {

                            password = it
                            errorMessage = ""
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text("Password")
                        },
                        placeholder = {
                            Text("Masukkan password")
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
                        isError = errorMessage.isNotEmpty(),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(7.dp)
                    )

                    Text(
                        text = "Minimal 8 karakter dan mengandung angka.",
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                   // KONFIRMASI PASSWORD

                    OutlinedTextField(
                        value = konfirmasiPassword,
                        onValueChange = {

                            konfirmasiPassword = it
                            errorMessage = ""
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
                                    konfirmasiVisible =
                                        !konfirmasiVisible
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
                        isError = errorMessage.isNotEmpty(),
                        shape = RoundedCornerShape(12.dp)
                    )

                   // ERROR

                    if (errorMessage.isNotEmpty()) {

                        Spacer(
                            modifier = Modifier.height(14.dp)
                        )

                        Surface(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colorScheme.errorContainer
                        ) {

                            Text(
                                text = errorMessage,
                                modifier = Modifier.padding(12.dp),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onErrorContainer
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(22.dp)
                    )

                    // DAFTAR

                    Button(
                        onClick = {

                            errorMessage = ""

                            when {

                                nik.isBlank() -> {

                                    errorMessage =
                                        "NIK wajib diisi."
                                }

                                nik.length < 6 -> {

                                    errorMessage =
                                        "NIK tidak valid."
                                }

                                nama.isBlank() -> {

                                    errorMessage =
                                        "Nama lengkap wajib diisi."
                                }

                                password.isBlank() -> {

                                    errorMessage =
                                        "Password wajib diisi."
                                }

                                password.length < 8 -> {

                                    errorMessage =
                                        "Password minimal terdiri dari 8 karakter."
                                }

                                !password.any { it.isDigit() } -> {

                                    errorMessage =
                                        "Password harus mengandung minimal 1 angka."
                                }

                                konfirmasiPassword.isBlank() -> {

                                    errorMessage =
                                        "Konfirmasi password wajib diisi."
                                }

                                password != konfirmasiPassword -> {

                                    errorMessage =
                                        "Konfirmasi password tidak sama."
                                }

                                else -> {

                                    isLoading = true

                                    /*
                                     * TODO:
                                     *
                                     * Panggil API registrasi.
                                     *
                                     * Data yang dikirim:
                                     * - NIK
                                     * - Nama
                                     * - Password
                                     *
                                     * Backend:
                                     * 1. Cek NIK sudah terdaftar atau belum.
                                     * 2. Validasi data pegawai.
                                     * 3. Hash password.
                                     * 4. Simpan akun.
                                     * 5. Response berhasil.
                                     *
                                     * Untuk sementara dummy.
                                     */

                                    isLoading = false

                                    navController.popBackStack()
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

                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null
                            )

                            Spacer(
                                modifier = Modifier.width(8.dp)
                            )

                            Text(
                                text = "DAFTARKAN AKUN",
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                  // KEMBALI LOGIN

                    TextButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {

                        Text(
                            text = "Sudah punya akun? Masuk",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    Text(
                        text = "© 2026 Kalurahan Purwobinangun",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}