package com.example.si_absen.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.Badge
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

@Composable
fun LoginScreen(
    navController: NavController
) {

    var nik by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
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
                                imageVector = Icons.AutoMirrored.Filled.Login,
                                contentDescription = "Login",
                                modifier = Modifier.size(38.dp),
                                tint = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(18.dp)
                    )

                    Text(
                        text = "SI ABSEN",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = "Sistem Informasi Absensi Pegawai",
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
                        modifier = Modifier.height(16.dp)
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

                   // LUPA PASSWORD
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {

                        TextButton(
                            onClick = {

                                navController.navigate(
                                    Screen.ForgotPassword.route
                                )
                            }
                        ) {

                            Text(
                                text = "Lupa Password?",
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }

                    // ERROR

                    if (errorMessage.isNotEmpty()) {

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

                        Spacer(
                            modifier = Modifier.height(16.dp)
                        )
                    }

                   // LOGIN BUTTON

                    Button(
                        onClick = {

                            errorMessage = ""

                            when {

                                nik.isBlank() -> {

                                    errorMessage =
                                        "NIK wajib diisi."
                                }

                                password.isBlank() -> {

                                    errorMessage =
                                        "Password wajib diisi."
                                }

                                else -> {

                                    isLoading = true

                                    /*
                                     * LOGIN SEMENTARA / DUMMY
                                     *
                                     * Nanti bagian ini diganti API login.
                                     */

                                    when {

                                        nik == "111" &&
                                                password == "admin" -> {

                                            isLoading = false

                                            navController.navigate(
                                                Screen.DashboardAdmin.route
                                            )
                                        }

                                        nik == "222" &&
                                                password == "pegawai" -> {

                                            isLoading = false

                                            navController.navigate(
                                                Screen.DashboardPegawai.route
                                            )
                                        }

                                        nik == "333" &&
                                                password == "dukuh" -> {

                                            isLoading = false

                                            navController.navigate(
                                                Screen.DashboardDukuh.route
                                            )
                                        }

                                        else -> {

                                            isLoading = false

                                            errorMessage =
                                                "NIK atau password salah."
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

                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Login,
                                contentDescription = null
                            )

                            Spacer(
                                modifier = Modifier.width(8.dp)
                            )

                            Text(
                                text = "MASUK SISTEM",
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    // REGISTER

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Belum punya akun?",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        TextButton(
                            onClick = {

                                navController.navigate(
                                    Screen.Register.route
                                )
                            }
                        ) {

                            Text(
                                text = "Buat Akun",
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(20.dp)
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