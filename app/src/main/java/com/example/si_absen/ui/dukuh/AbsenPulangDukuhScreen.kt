package com.example.si_absen.ui.dukuh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Notes
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notes
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AbsenPulangDukuhScreen() {

    var keterangan by remember {
        mutableStateOf("")
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,

        topBar = {
            TopAppBar(
                title = {
                    Column {

                        Text(
                            text = "Absensi Pulang",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold
                        )

                        Text(
                            text = "Presensi kepulangan Dukuh",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            )
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            // STATUS ABSENSI

            Card(
                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(20.dp),

                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape)
                                .background(
                                    MaterialTheme.colorScheme.onPrimary.copy(
                                        alpha = 0.15f
                                    )
                                ),

                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = "Status absensi",

                                tint = MaterialTheme.colorScheme.onPrimary,

                                modifier = Modifier.size(24.dp)
                            )
                        }

                        Spacer(
                            modifier = Modifier.width(12.dp)
                        )

                        Column {

                            Text(
                                text = "Status Kehadiran",

                                style = MaterialTheme.typography.bodyMedium,

                                color = MaterialTheme.colorScheme.onPrimary.copy(
                                    alpha = 0.85f
                                )
                            )

                            Text(
                                text = "Siap Absen Pulang",

                                style = MaterialTheme.typography.titleLarge,

                                fontWeight = FontWeight.Bold,

                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Default.AccessTime,
                            contentDescription = null,

                            tint = MaterialTheme.colorScheme.onPrimary,

                            modifier = Modifier.size(18.dp)
                        )

                        Spacer(
                            modifier = Modifier.width(6.dp)
                        )

                        Text(
                            text = "Hari ini • 16:00 WIB",

                            style = MaterialTheme.typography.bodyMedium,

                            color = MaterialTheme.colorScheme.onPrimary.copy(
                                alpha = 0.9f
                            )
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // WAKTU PULANG

            SectionCardPulang(
                title = "Waktu Absensi",
                icon = Icons.Default.AccessTime
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),

                    horizontalArrangement = Arrangement.SpaceBetween,

                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column {

                        Text(
                            text = "Waktu Saat Ini",

                            style = MaterialTheme.typography.bodyMedium,

                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Text(
                            text = "16:00 WIB",

                            style = MaterialTheme.typography.titleLarge,

                            fontWeight = FontWeight.Bold
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(10.dp),

                        color = MaterialTheme.colorScheme.primaryContainer
                    ) {

                        Text(
                            text = "Jam Pulang",

                            style = MaterialTheme.typography.labelMedium,

                            fontWeight = FontWeight.Medium,

                            color = MaterialTheme.colorScheme.onPrimaryContainer,

                            modifier = Modifier.padding(
                                horizontal = 12.dp,
                                vertical = 8.dp
                            )
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

           // INFORMASI LOKASI

            SectionCardPulang(
                title = "Informasi Lokasi",
                icon = Icons.Default.LocationOn
            ) {

                LocationInfoPulang(
                    label = "Latitude",
                    value = "-7.7612"
                )

                LocationInfoPulang(
                    label = "Longitude",
                    value = "110.3678"
                )

                LocationInfoPulang(
                    label = "Jarak ke Kantor",
                    value = "42 Meter"
                )

                LocationInfoPulang(
                    label = "Status Radius",
                    value = "Dalam Radius",

                    valueColor = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // FOTO SELFIE

            SectionCardPulang(
                title = "Foto Selfie",
                icon = Icons.Default.CameraAlt
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(170.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(
                            MaterialTheme.colorScheme.surfaceVariant
                        ),

                    contentAlignment = Alignment.Center
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Icon(
                            imageVector = Icons.Default.CameraAlt,

                            contentDescription = null,

                            tint = MaterialTheme.colorScheme.onSurfaceVariant,

                            modifier = Modifier.size(42.dp)
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "Belum Ada Foto",

                            style = MaterialTheme.typography.bodyMedium,

                            fontWeight = FontWeight.Medium,

                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text = "Foto selfie diperlukan untuk absensi",

                            style = MaterialTheme.typography.bodySmall,

                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                OutlinedButton(
                    onClick = {
                        // TODO: buka kamera
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(12.dp)
                ) {

                    Icon(
                        imageVector = Icons.Default.CameraAlt,

                        contentDescription = null
                    )

                    Spacer(
                        modifier = Modifier.width(8.dp)
                    )

                    Text(
                        text = "Ambil Foto Selfie"
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // KETERANGAN

            SectionCardPulang(
                title = "Keterangan",
                icon = Icons.AutoMirrored.Filled.Notes
            ) {

                OutlinedTextField(
                    value = keterangan,

                    onValueChange = {
                        keterangan = it
                    },

                    modifier = Modifier.fillMaxWidth(),

                    placeholder = {
                        Text(
                            text = "Tambahkan catatan jika diperlukan"
                        )
                    },

                    minLines = 3,

                    maxLines = 5,

                    shape = RoundedCornerShape(12.dp)
                )
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            // TOMBOL ABSEN

            Button(
                onClick = {

                    // TODO:
                    // 1. validasi lokasi
                    // 2. validasi foto
                    // 3. simpan absensi pulang
                    // 4. jika offline -> status pending
                    // 5. kirim ketika internet tersedia

                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),

                shape = RoundedCornerShape(14.dp)
            ) {

                Icon(
                    imageVector = Icons.Default.CheckCircle,

                    contentDescription = null
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Text(
                    text = "ABSEN PULANG",

                    style = MaterialTheme.typography.labelLarge,

                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )
        }
    }
}

// SECTION CARD PULANG

@Composable
private fun SectionCardPulang(
    title: String,

    icon: androidx.compose.ui.graphics.vector.ImageVector,

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
                .padding(18.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    modifier = Modifier.size(40.dp),

                    shape = RoundedCornerShape(12.dp),

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
                    modifier = Modifier.width(12.dp)
                )

                Text(
                    text = title,

                    style = MaterialTheme.typography.titleMedium,

                    fontWeight = FontWeight.SemiBold,

                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            content()
        }
    }
}


// LOCATION INFO

@Composable
private fun LocationInfoPulang(
    label: String,

    value: String,

    valueColor: Color = MaterialTheme.colorScheme.onSurface
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp),

        horizontalArrangement = Arrangement.SpaceBetween,

        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = label,

            style = MaterialTheme.typography.bodyMedium,

            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = value,

            style = MaterialTheme.typography.bodyMedium,

            fontWeight = FontWeight.Medium,

            color = valueColor
        )
    }
}