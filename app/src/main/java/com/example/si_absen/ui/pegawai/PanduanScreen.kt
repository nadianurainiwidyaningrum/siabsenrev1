package com.example.si_absen.ui.pegawai

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Timelapse
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class PanduanItem(
    val judul: String,
    val deskripsi: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PanduanScreen() {

    val panduanList = listOf(
        PanduanItem(
            judul = "Absen Masuk",
            deskripsi = "Lakukan Absen Masuk sebelum memulai pekerjaan sesuai dengan jam kerja yang telah ditentukan."
        ),
        PanduanItem(
            judul = "Pastikan Lokasi Aktif",
            deskripsi = "Aktifkan GPS dan pastikan posisi Anda berada dalam radius absensi Kalurahan."
        ),
        PanduanItem(
            judul = "Ambil Foto Absensi",
            deskripsi = "Pastikan kamera dapat digunakan dan ambil foto sesuai ketentuan saat melakukan absensi."
        ),
        PanduanItem(
            judul = "Absen Kegiatan",
            deskripsi = "Gunakan Absen Kegiatan ketika melaksanakan tugas atau kegiatan di luar aktivitas kerja rutin."
        ),
        PanduanItem(
            judul = "Absen Pulang",
            deskripsi = "Lakukan Absen Pulang setelah pekerjaan selesai agar waktu kepulangan tercatat pada sistem."
        ),
        PanduanItem(
            judul = "Periksa Riwayat",
            deskripsi = "Periksa riwayat absensi secara berkala untuk memastikan seluruh data kehadiran telah tercatat."
        ),
        PanduanItem(
            judul = "Pantau Rekap Kehadiran",
            deskripsi = "Gunakan rekap kehadiran untuk melihat ringkasan kehadiran dan status absensi."
        )
    )

    val icons = listOf(
        Icons.Default.CheckCircle,
        Icons.Default.LocationOn,
        Icons.Default.CameraAlt,
        Icons.Default.Timelapse,
        Icons.Default.CheckCircle,
        Icons.AutoMirrored.Filled.MenuBook,
        Icons.Default.Notifications
    )

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Panduan Penggunaan",
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Cara menggunakan SI ABSEN",
                            style = MaterialTheme.typography.labelMedium,
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
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(
                top = 16.dp,
                bottom = 24.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
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
                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(
                                        MaterialTheme.colorScheme.onPrimary.copy(
                                            alpha = 0.15f
                                        )
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.MenuBook,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onPrimary,
                                    modifier = Modifier.size(27.dp)
                                )
                            }

                            Spacer(
                                modifier = Modifier.width(14.dp)
                            )

                            Column {
                                Text(
                                    text = "Panduan SI ABSEN",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(
                                    modifier = Modifier.height(3.dp)
                                )

                                Text(
                                    text = "Panduan penggunaan aplikasi bagi pegawai",
                                    color = MaterialTheme.colorScheme.onPrimary.copy(
                                        alpha = 0.8f
                                    ),
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }

                        Spacer(
                            modifier = Modifier.height(16.dp)
                        )

                        HorizontalDivider(
                            color = MaterialTheme.colorScheme.onPrimary.copy(
                                alpha = 0.2f
                            )
                        )

                        Spacer(
                            modifier = Modifier.height(14.dp)
                        )

                        Text(
                            text = "Ikuti setiap langkah agar proses absensi berjalan lancar dan data kehadiran tercatat dengan benar.",
                            color = MaterialTheme.colorScheme.onPrimary.copy(
                                alpha = 0.9f
                            ),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            // JUDUL
            item {
                Text(
                    text = "Langkah Penggunaan",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(
                        top = 4.dp,
                        bottom = 2.dp
                    )
                )
            }

            // LANGKAH
            itemsIndexed(
                items = panduanList
            ) { index, item ->

                PanduanCard(
                    nomor = index + 1,
                    item = item,
                    icon = icons[index]
                )
            }

            // TIPS
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    shape = RoundedCornerShape(16.dp),
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
                                imageVector = Icons.Default.Security,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(22.dp)
                            )

                            Spacer(
                                modifier = Modifier.width(10.dp)
                            )

                            Text(
                                text = "Tips Sebelum Absensi",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }

                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )

                        PanduanTipsRow(
                            text = "Pastikan GPS perangkat sudah aktif."
                        )

                        PanduanTipsRow(
                            text = "Pastikan Anda berada dalam radius absensi."
                        )

                        PanduanTipsRow(
                            text = "Pastikan kamera dapat digunakan."
                        )

                        PanduanTipsRow(
                            text = "Pastikan koneksi internet tersedia."
                        )
                    }
                }
            }

            // CATATAN
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {

                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.Top
                    ) {

                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(22.dp)
                        )

                        Spacer(
                            modifier = Modifier.width(12.dp)
                        )

                        Column {
                            Text(
                                text = "Catatan Penting",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(
                                modifier = Modifier.height(6.dp)
                            )

                            Text(
                                text = "Keterlambatan, absensi di luar radius, dan data absensi yang tidak sesuai ketentuan akan tercatat pada sistem dan dapat memengaruhi rekap kehadiran.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PanduanCard(
    nomor: Int,
    item: PanduanItem,
    icon: androidx.compose.ui.graphics.vector.ImageVector
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {

            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        MaterialTheme.colorScheme.primaryContainer
                    ),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = nomor.toString(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(
                modifier = Modifier.width(12.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(19.dp)
                    )

                    Spacer(
                        modifier = Modifier.width(7.dp)
                    )

                    Text(
                        text = item.judul,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = item.deskripsi,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun PanduanTipsRow(
    text: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.Top
    ) {

        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(17.dp)
        )

        Spacer(
            modifier = Modifier.width(8.dp)
        )

        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}