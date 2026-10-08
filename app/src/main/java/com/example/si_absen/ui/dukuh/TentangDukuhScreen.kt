package com.example.si_absen.ui.dukuh

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TentangDukuhScreen() {

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,

        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Tentang Aplikasi",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold
                        )

                        Text(
                            text = "Informasi SI ABSEN",
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
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // HEADER APLIKASI

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.extraLarge,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Surface(
                        modifier = Modifier.size(76.dp),
                        shape = MaterialTheme.shapes.large,
                        color = MaterialTheme.colorScheme.onPrimary
                            .copy(alpha = 0.15f)
                    ) {

                        Box(
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = Icons.Default.PhoneAndroid,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimary,
                                modifier = Modifier.size(42.dp)
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Text(
                        text = "SI ABSEN",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "Sistem Informasi Absensi",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                            .copy(alpha = 0.9f)
                    )

                    Text(
                        text = "Kalurahan Purwobinangun",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onPrimary
                            .copy(alpha = 0.8f)
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    Surface(
                        shape = MaterialTheme.shapes.small,
                        color = MaterialTheme.colorScheme.onPrimary
                            .copy(alpha = 0.12f)
                    ) {

                        Row(
                            modifier = Modifier.padding(
                                horizontal = 12.dp,
                                vertical = 6.dp
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Icon(
                                imageVector = Icons.Default.VerifiedUser,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp),
                                tint = MaterialTheme.colorScheme.onPrimary
                            )

                            Spacer(
                                modifier = Modifier.width(6.dp)
                            )

                            Text(
                                text = "Aplikasi Resmi",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }


            // INFORMASI APLIKASI

            AboutSectionCard(
                title = "Informasi Aplikasi",
                icon = Icons.Default.Info
            ) {

                AboutInfoRow(
                    label = "Versi Aplikasi",
                    value = "1.0.0"
                )

                AboutInfoRow(
                    label = "Build",
                    value = "2026.01"
                )

                AboutInfoRow(
                    label = "Platform",
                    value = "Android"
                )

                AboutInfoRow(
                    label = "Status",
                    value = "Production",
                    valueColor = MaterialTheme.colorScheme.primary
                )
            }


            // INSTANSI
            AboutSectionCard(
                title = "Instansi",
                icon = Icons.Default.LocationCity
            ) {

                AboutInfoRow(
                    label = "Nama",
                    value = "Kalurahan Purwobinangun"
                )

                AboutInfoRow(
                    label = "Kapanewon",
                    value = "Pakem"
                )

                AboutInfoRow(
                    label = "Kabupaten",
                    value = "Sleman"
                )

                AboutInfoRow(
                    label = "Provinsi",
                    value = "Daerah Istimewa Yogyakarta"
                )
            }

            // DESKRIPSI


            AboutSectionCard(
                title = "Tentang SI ABSEN",
                icon = Icons.Default.Business
            ) {

                Text(
                    text = "SI ABSEN merupakan aplikasi absensi pegawai dan dukuh berbasis Android yang digunakan untuk membantu proses pencatatan kehadiran secara digital.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = "Aplikasi ini menyediakan fitur absensi masuk, absensi pulang, absensi kegiatan, monitoring lokasi, pengelolaan kegiatan dusun, rekapitulasi kehadiran, notifikasi, serta pengelolaan administrasi Kalurahan Purwobinangun.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            //FITUR UTAMA


            AboutSectionCard(
                title = "Fitur Utama",
                icon = Icons.Default.Android
            ) {

                AboutFeatureRow(
                    title = "Absensi Digital",
                    description = "Mencatat absensi masuk, pulang, dan kegiatan."
                )

                AboutFeatureRow(
                    title = "Monitoring Lokasi",
                    description = "Validasi lokasi berdasarkan titik dan radius presensi."
                )

                AboutFeatureRow(
                    title = "Kegiatan Dusun",
                    description = "Mengelola pengajuan dan riwayat kegiatan wilayah."
                )

                AboutFeatureRow(
                    title = "Rekap Kehadiran",
                    description = "Melihat ringkasan kehadiran dan aktivitas."
                )
            }


            // COPYRIGHT

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 4.dp,
                        bottom = 8.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                HorizontalDivider(
                    color = MaterialTheme.colorScheme.outlineVariant
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Text(
                    text = "SI ABSEN • Versi 1.0.0",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = FontWeight.Medium
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = "© 2026 Kalurahan Purwobinangun",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

// SECTION CARD

@Composable
private fun AboutSectionCard(
    title: String,
    icon: ImageVector,
    content: @Composable ColumnScope.() -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    modifier = Modifier.size(42.dp),
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {

                    Box(
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                            modifier = Modifier.size(22.dp)
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

// INFO ROW

@Composable
private fun AboutInfoRow(
    label: String,
    value: String,
    valueColor: androidx.compose.ui.graphics.Color =
        MaterialTheme.colorScheme.onSurface
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {

        Text(
            text = label,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(
            modifier = Modifier.width(16.dp)
        )

        Text(
            text = value,
            modifier = Modifier.weight(1.2f),
            style = MaterialTheme.typography.bodyMedium,
            color = valueColor,
            fontWeight = FontWeight.Medium
        )
    }
}

// FEATURE ROW

@Composable
private fun AboutFeatureRow(
    title: String,
    description: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp),
        verticalAlignment = Alignment.Top
    ) {

        Surface(
            modifier = Modifier
                .padding(top = 2.dp)
                .size(8.dp),
            shape = MaterialTheme.shapes.small,
            color = MaterialTheme.colorScheme.primary
        ) {}

        Spacer(
            modifier = Modifier.width(12.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}