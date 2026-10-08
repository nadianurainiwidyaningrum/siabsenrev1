@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.si_absen.ui.pegawai

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun EditProfilScreen(
    navController: NavController? = null
) {

    var nama by remember {
        mutableStateOf("Nadia Nuraini")
    }

    var noHp by remember {
        mutableStateOf("081234567890")
    }

    var email by remember {
        mutableStateOf("nadia@gmail.com")
    }

    val nik = "340101"

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,

        topBar = {

            TopAppBar(

                navigationIcon = {

                    IconButton(
                        onClick = {
                            navController?.popBackStack()
                        }
                    ) {

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Kembali"
                        )
                    }
                },

                title = {

                    Column {

                        Text(
                            text = "Edit Profil",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold
                        )

                        Text(
                            text = "Perbarui informasi akun",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            )
        }

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            // HEADER

            Card(
                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(22.dp),

                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),

                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Surface(
                        modifier = Modifier.size(52.dp),

                        shape = RoundedCornerShape(15.dp),

                        color = MaterialTheme.colorScheme.onPrimary.copy(
                            alpha = 0.15f
                        )
                    ) {

                        Box(
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,

                                tint = MaterialTheme.colorScheme.onPrimary,

                                modifier = Modifier.size(29.dp)
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.width(14.dp)
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Informasi Profil",

                            style = MaterialTheme.typography.titleLarge,

                            fontWeight = FontWeight.Bold,

                            color = MaterialTheme.colorScheme.onPrimary
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text = "Perbarui data profil pegawai",

                            style = MaterialTheme.typography.bodySmall,

                            color = MaterialTheme.colorScheme.onPrimary.copy(
                                alpha = 0.85f
                            )
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // DATA AKUN

            EditProfilSection(
                title = "Data Akun",
                icon = Icons.Default.Badge
            ) {

                OutlinedTextField(
                    value = nik,
                    onValueChange = {},
                    readOnly = true,

                    label = {
                        Text("NIK")
                    },

                    leadingIcon = {

                        Icon(
                            imageVector = Icons.Default.Badge,
                            contentDescription = null
                        )
                    },

                    supportingText = {

                        Text(
                            text = "NIK tidak dapat diubah"
                        )
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(12.dp),

                    singleLine = true
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // INFORMASI PRIBADI

            EditProfilSection(
                title = "Informasi Pribadi",
                icon = Icons.Default.Person
            ) {

                OutlinedTextField(
                    value = nama,
                    onValueChange = {
                        nama = it
                    },

                    label = {
                        Text("Nama Lengkap")
                    },

                    leadingIcon = {

                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null
                        )
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(12.dp),

                    singleLine = true
                )

                Spacer(
                    modifier = Modifier.height(14.dp)
                )

                OutlinedTextField(
                    value = noHp,
                    onValueChange = {
                        if (it.all { char -> char.isDigit() }) {
                            noHp = it
                        }
                    },

                    label = {
                        Text("Nomor HP")
                    },

                    leadingIcon = {

                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = null
                        )
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(12.dp),

                    singleLine = true
                )

                Spacer(
                    modifier = Modifier.height(14.dp)
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },

                    label = {
                        Text("Email")
                    },

                    leadingIcon = {

                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null
                        )
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(12.dp),

                    singleLine = true
                )
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            // INFO

            Surface(
                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(14.dp),

                color = MaterialTheme.colorScheme.primaryContainer
            ) {

                Row(
                    modifier = Modifier.padding(14.dp),

                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.Badge,
                        contentDescription = null,

                        tint = MaterialTheme.colorScheme.onPrimaryContainer,

                        modifier = Modifier.size(21.dp)
                    )

                    Spacer(
                        modifier = Modifier.width(10.dp)
                    )

                    Text(
                        text = "Pastikan data profil yang kamu masukkan sudah benar sebelum disimpan.",

                        style = MaterialTheme.typography.bodySmall,

                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            // TOMBOL

            Button(
                onClick = {
                    // proses simpan perubahan profil
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),

                shape = RoundedCornerShape(14.dp)
            ) {

                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = null
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Text(
                    text = "Simpan Perubahan",
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )
        }
    }
}

// SECTION

@Composable
private fun EditProfilSection(
    title: String,
    icon: ImageVector,
    content: @Composable ColumnScope.() -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(18.dp),

        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    modifier = Modifier.size(38.dp),

                    shape = RoundedCornerShape(11.dp),

                    color = MaterialTheme.colorScheme.primaryContainer
                ) {

                    Box(
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = icon,
                            contentDescription = null,

                            tint = MaterialTheme.colorScheme.onPrimaryContainer,

                            modifier = Modifier.size(21.dp)
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.width(10.dp)
                )

                Text(
                    text = title,

                    style = MaterialTheme.typography.titleMedium,

                    fontWeight = FontWeight.SemiBold,

                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            content()
        }
    }
}