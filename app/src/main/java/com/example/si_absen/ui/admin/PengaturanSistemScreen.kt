package com.example.si_absen.ui.admin

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.GpsFixed
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PengaturanSistemScreen() {

    val context = LocalContext.current

    var radius by remember {
        mutableStateOf("100")
    }

    var toleransi by remember {
        mutableStateOf("15")
    }

    var jamMasuk by remember {
        mutableStateOf("07:30")
    }

    var jamPulang by remember {
        mutableStateOf("16:00")
    }

    var gpsAktif by remember {
        mutableStateOf(true)
    }

    var fotoAktif by remember {
        mutableStateOf(true)
    }

    var notifikasiAktif by remember {
        mutableStateOf(true)
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,

        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Pengaturan Sistem",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Konfigurasi aturan dan fitur SI ABSEN",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    MaterialTheme.colorScheme.background
                )
                .padding(paddingValues),

            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 16.dp
            ),

            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            // HEADER

            item {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
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

                        Box(
                            modifier = Modifier
                                .size(52.dp)
                                .clip(RoundedCornerShape(15.dp))
                                .background(
                                    MaterialTheme.colorScheme.onPrimary.copy(
                                        alpha = 0.15f
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = null,
                                modifier = Modifier.size(28.dp),
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }

                        Spacer(
                            modifier = Modifier.width(14.dp)
                        )

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = "Konfigurasi SI ABSEN",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimary
                            )

                            Spacer(
                                modifier = Modifier.height(3.dp)
                            )

                            Text(
                                text = "Atur aturan presensi yang digunakan oleh seluruh pengguna.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onPrimary.copy(
                                    alpha = 0.85f
                                )
                            )
                        }
                    }
                }
            }

            // ATURAN ABSENSI

            item {

                SectionHeader(
                    title = "Aturan Absensi",
                    description = "Tentukan batas lokasi dan toleransi keterlambatan"
                )
            }

            item {

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
                        modifier = Modifier.padding(16.dp)
                    ) {

                        OutlinedTextField(
                            value = radius,
                            onValueChange = {
                                if (it.all { char -> char.isDigit() }) {
                                    radius = it
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            shape = RoundedCornerShape(12.dp),
                            label = {
                                Text("Radius Absensi")
                            },
                            placeholder = {
                                Text("Contoh: 100")
                            },
                            supportingText = {
                                Text("Jarak maksimal pegawai dari titik kantor.")
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.GpsFixed,
                                    contentDescription = null
                                )
                            },
                            trailingIcon = {
                                Text(
                                    text = "Meter",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            )
                        )

                        Spacer(
                            modifier = Modifier.height(14.dp)
                        )

                        OutlinedTextField(
                            value = toleransi,
                            onValueChange = {
                                if (it.all { char -> char.isDigit() }) {
                                    toleransi = it
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            shape = RoundedCornerShape(12.dp),
                            label = {
                                Text("Toleransi Keterlambatan")
                            },
                            placeholder = {
                                Text("Contoh: 15")
                            },
                            supportingText = {
                                Text("Batas waktu toleransi setelah jam masuk.")
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.AccessTime,
                                    contentDescription = null
                                )
                            },
                            trailingIcon = {
                                Text(
                                    text = "Menit",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            )
                        )
                    }
                }
            }

            // JAM KERJA

            item {

                SectionHeader(
                    title = "Jam Kerja",
                    description = "Atur waktu standar presensi pegawai"
                )
            }

            item {

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
                        modifier = Modifier.padding(16.dp)
                    ) {

                        TimeSettingRow(
                            icon = Icons.Default.AccessTime,
                            title = "Jam Masuk",
                            description = "Waktu mulai presensi masuk",
                            value = jamMasuk,
                            onValueChange = {
                                jamMasuk = it
                            }
                        )

                        Spacer(
                            modifier = Modifier.height(14.dp)
                        )

                        TimeSettingRow(
                            icon = Icons.Default.AccessTime,
                            title = "Jam Pulang",
                            description = "Waktu mulai presensi pulang",
                            value = jamPulang,
                            onValueChange = {
                                jamPulang = it
                            }
                        )
                    }
                }
            }

            // FITUR SISTEM

            item {

                SectionHeader(
                    title = "Fitur Sistem",
                    description = "Aktifkan fitur yang digunakan dalam proses presensi"
                )
            }

            item {

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

                    Column {

                        SystemFeatureRow(
                            icon = Icons.Default.GpsFixed,
                            title = "Validasi GPS",
                            description = "Gunakan lokasi perangkat untuk memvalidasi radius.",
                            checked = gpsAktif,
                            onCheckedChange = {
                                gpsAktif = it
                            }
                        )

                        HorizontalDivider(
                            color = MaterialTheme.colorScheme.outlineVariant
                        )

                        SystemFeatureRow(
                            icon = Icons.Default.CameraAlt,
                            title = "Wajib Foto",
                            description = "Pegawai mengambil foto saat melakukan presensi.",
                            checked = fotoAktif,
                            onCheckedChange = {
                                fotoAktif = it
                            }
                        )

                        HorizontalDivider(
                            color = MaterialTheme.colorScheme.outlineVariant
                        )

                        SystemFeatureRow(
                            icon = Icons.Default.Notifications,
                            title = "Notifikasi",
                            description = "Aktifkan pemberitahuan terkait aktivitas absensi.",
                            checked = notifikasiAktif,
                            onCheckedChange = {
                                notifikasiAktif = it
                            }
                        )
                    }
                }
            }

            // RINGKASAN

            item {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(17.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                modifier = Modifier.size(22.dp),
                                tint = MaterialTheme.colorScheme.onPrimaryContainer
                            )

                            Spacer(
                                modifier = Modifier.width(9.dp)
                            )

                            Text(
                                text = "Ringkasan Konfigurasi",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }

                        Spacer(
                            modifier = Modifier.height(12.dp)
                        )

                        ConfigurationSummaryRow(
                            title = "Radius Presensi",
                            value = "$radius Meter"
                        )

                        ConfigurationSummaryRow(
                            title = "Jam Masuk",
                            value = jamMasuk
                        )

                        ConfigurationSummaryRow(
                            title = "Jam Pulang",
                            value = jamPulang
                        )

                        ConfigurationSummaryRow(
                            title = "Toleransi",
                            value = "$toleransi Menit"
                        )

                        ConfigurationSummaryRow(
                            title = "GPS",
                            value = if (gpsAktif) "Aktif" else "Nonaktif"
                        )

                        ConfigurationSummaryRow(
                            title = "Foto",
                            value = if (fotoAktif) "Wajib" else "Opsional"
                        )
                    }
                }
            }

            // SIMPAN

            item {

                Button(
                    onClick = {
                        Toast.makeText(
                            context,
                            "Pengaturan berhasil disimpan",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(14.dp)
                ) {

                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(
                        modifier = Modifier.width(8.dp)
                    )

                    Text(
                        text = "Simpan Pengaturan",
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Composable
private fun SectionHeader(
    title: String,
    description: String
) {

    Column {

        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(3.dp)
        )

        Text(
            text = description,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun TimeSettingRow(
    icon: ImageVector,
    title: String,
    description: String,
    value: String,
    onValueChange: (String) -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {

        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(
                    MaterialTheme.colorScheme.primaryContainer
                ),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(21.dp),
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

        Spacer(
            modifier = Modifier.width(12.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                placeholder = {
                    Text("HH:MM")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                )
            )
        }
    }
}

@Composable
private fun SystemFeatureRow(
    icon: ImageVector,
    title: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 14.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(
                    MaterialTheme.colorScheme.primaryContainer
                ),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(21.dp),
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

        Spacer(
            modifier = Modifier.width(12.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
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

        Spacer(
            modifier = Modifier.width(8.dp)
        )

        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Composable
private fun ConfigurationSummaryRow(
    title: String,
    value: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(
                alpha = 0.75f
            )
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}