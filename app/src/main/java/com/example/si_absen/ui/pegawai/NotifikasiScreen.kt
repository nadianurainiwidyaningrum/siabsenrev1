package com.example.si_absen.ui.pegawai

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class NotifikasiItem(
    val judul: String,
    val pesan: String,
    val tanggal: String,
    val waktu: String,
    val tipe: String,
    val sudahDibaca: Boolean
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotifikasiScreen() {

    var data by remember {
        mutableStateOf(
            listOf(
                NotifikasiItem(
                    judul = "Absen Berhasil",
                    pesan = "Absensi masuk Anda berhasil tercatat.",
                    tanggal = "10 Sep 2026",
                    waktu = "07:28 WIB",
                    tipe = "Absensi",
                    sudahDibaca = false
                ),
                NotifikasiItem(
                    judul = "Jangan lupa absen pulang",
                    pesan = "Pastikan melakukan absensi pulang sebelum meninggalkan kantor.",
                    tanggal = "10 Sep 2026",
                    waktu = "15:30 WIB",
                    tipe = "Pengingat",
                    sudahDibaca = false
                ),
                NotifikasiItem(
                    judul = "Pengumuman Kalurahan",
                    pesan = "Terdapat pengumuman baru dari Kalurahan Purwobinangun.",
                    tanggal = "09 Sep 2026",
                    waktu = "10:15 WIB",
                    tipe = "Pengumuman",
                    sudahDibaca = true
                )
            )
        )
    }

    val jumlahBelumDibaca = data.count {
        !it.sudahDibaca
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Notifikasi",
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Informasi dan pemberitahuan",
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

                    Row(
                        modifier = Modifier.padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .background(
                                    MaterialTheme.colorScheme.onPrimary.copy(
                                        alpha = 0.15f
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimary,
                                modifier = Modifier.size(27.dp)
                            )
                        }

                        Spacer(
                            modifier = Modifier.width(14.dp)
                        )

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = "Pusat Notifikasi",
                                color = MaterialTheme.colorScheme.onPrimary,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(
                                modifier = Modifier.height(3.dp)
                            )

                            Text(
                                text = "Informasi terbaru untuk Anda",
                                color = MaterialTheme.colorScheme.onPrimary.copy(
                                    alpha = 0.8f
                                ),
                                style = MaterialTheme.typography.bodySmall
                            )
                        }

                        if (jumlahBelumDibaca > 0) {

                            Surface(
                                shape = RoundedCornerShape(50),
                                color = MaterialTheme.colorScheme.onPrimary.copy(
                                    alpha = 0.15f
                                )
                            ) {

                                Text(
                                    text = "$jumlahBelumDibaca baru",
                                    modifier = Modifier.padding(
                                        horizontal = 9.dp,
                                        vertical = 6.dp
                                    ),
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            // JUDUL
            item {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 4.dp,
                            bottom = 2.dp
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Notifikasi Terbaru",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "${data.size} notifikasi",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // LIST
            if (data.isEmpty()) {

                item {

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(32.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(48.dp)
                            )

                            Spacer(
                                modifier = Modifier.height(12.dp)
                            )

                            Text(
                                text = "Belum ada notifikasi",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(
                                modifier = Modifier.height(4.dp)
                            )

                            Text(
                                text = "Notifikasi baru akan muncul di sini.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

            } else {

                items(
                    items = data,
                    key = {
                        "${it.judul}_${it.tanggal}_${it.waktu}"
                    }
                ) { item ->

                    NotifikasiCard(
                        item = item,
                        onClick = {

                            data = data.map { notification ->

                                if (
                                    notification.judul == item.judul &&
                                    notification.tanggal == item.tanggal &&
                                    notification.waktu == item.waktu
                                ) {
                                    notification.copy(
                                        sudahDibaca = true
                                    )
                                } else {
                                    notification
                                }
                            }
                        }
                    )
                }
            }

            // INFO
            item {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
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
                            modifier = Modifier.size(21.dp)
                        )

                        Spacer(
                            modifier = Modifier.width(12.dp)
                        )

                        Column {

                            Text(
                                text = "Informasi",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(
                                modifier = Modifier.height(5.dp)
                            )

                            Text(
                                text = "Notifikasi berisi informasi absensi, pengingat, pengumuman, dan aktivitas Kalurahan Purwobinangun.",
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
private fun NotifikasiCard(
    item: NotifikasiItem,
    onClick: () -> Unit
) {

    val icon = when (item.tipe) {
        "Absensi" -> Icons.Default.CheckCircle
        "Pengingat" -> Icons.Default.AccessTime
        "Pengumuman" -> Icons.Default.Campaign
        else -> Icons.Default.Notifications
    }

    val containerColor = if (!item.sudahDibaca) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MaterialTheme.colorScheme.surface
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (!item.sudahDibaca) 2.dp else 1.dp
        ),
        onClick = onClick
    ) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {

            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(13.dp))
                    .background(
                        if (!item.sudahDibaca) {
                            MaterialTheme.colorScheme.primary.copy(
                                alpha = 0.12f
                            )
                        } else {
                            MaterialTheme.colorScheme.surfaceVariant
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = if (!item.sudahDibaca) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    },
                    modifier = Modifier.size(23.dp)
                )
            }

            Spacer(
                modifier = Modifier.width(12.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top
                ) {

                    Text(
                        text = item.judul,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = if (!item.sudahDibaca) {
                            FontWeight.Bold
                        } else {
                            FontWeight.SemiBold
                        },
                        modifier = Modifier.weight(1f)
                    )

                    if (!item.sudahDibaca) {

                        Spacer(
                            modifier = Modifier.width(8.dp)
                        )

                        Box(
                            modifier = Modifier
                                .size(9.dp)
                                .clip(RoundedCornerShape(50))
                                .background(
                                    MaterialTheme.colorScheme.primary
                                )
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(5.dp)
                )

                Text(
                    text = item.pesan,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.Schedule,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(14.dp)
                    )

                    Spacer(
                        modifier = Modifier.width(4.dp)
                    )

                    Text(
                        text = "${item.tanggal} • ${item.waktu}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(
                        modifier = Modifier.width(8.dp)
                    )

                    Surface(
                        shape = RoundedCornerShape(50),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {

                        Text(
                            text = item.tipe,
                            modifier = Modifier.padding(
                                horizontal = 7.dp,
                                vertical = 3.dp
                            ),
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}