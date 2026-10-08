@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.si_absen.ui.pegawai

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun DetailKegiatanScreen(
    navController: NavController? = null
) {

    val context = LocalContext.current
 // DATA DUMMY
    // Nanti tinggal diganti dengan data dari database/API

    val namaKegiatan = "Rapat Koordinasi"
    val tanggal = "10 September 2026"
    val waktu = "09:00 WIB"
    val status = "Valid"

    val lokasi = "Kantor Kalurahan Purwobinangun"
    val latitude = -7.7612
    val longitude = 110.3678

    val keterangan =
        "Rapat koordinasi pegawai Kalurahan Purwobinangun untuk membahas program kerja, evaluasi kegiatan, dan penyusunan agenda pelayanan masyarakat."

    Scaffold(

        containerColor = MaterialTheme.colorScheme.background,

        topBar = {

            TopAppBar(

                title = {

                    Column {

                        Text(
                            text = "Detail Kegiatan",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Detail presensi kegiatan",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },

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

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }

    ) { paddingValues ->

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),

            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp,
                bottom = 24.dp
            ),

            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
  // STATUS PRESENSI
            item {

                ActivityStatusCard(
                    activityName = namaKegiatan,
                    date = tanggal,
                    time = waktu,
                    status = status
                )
            }

 // INFORMASI PRESENSI
            item {

                DetailSection(
                    title = "Informasi Presensi",
                    icon = Icons.Default.Event
                ) {

                    DetailInfoRow(
                        icon = Icons.Default.Event,
                        label = "Tanggal",
                        value = tanggal
                    )

                    DetailInfoRow(
                        icon = Icons.Default.AccessTime,
                        label = "Waktu Absen",
                        value = waktu
                    )

                    DetailInfoRow(
                        icon = Icons.Default.Badge,
                        label = "Jenis Presensi",
                        value = "Presensi Kegiatan"
                    )

                    DetailInfoRow(
                        icon = Icons.Default.Person,
                        label = "Peserta",
                        value = "Nadia Nuraini"
                    )

                    DetailInfoRow(
                        icon = Icons.Default.CheckCircle,
                        label = "Status",
                        value = "Valid",
                        valueColor = Color(0xFF2E7D32)
                    )
                }
            }

 // KETERANGAN
            item {

                DetailSection(
                    title = "Keterangan",
                    icon = Icons.Default.Description
                ) {

                    Text(
                        text = keterangan,

                        style = MaterialTheme.typography.bodyMedium,

                        color = MaterialTheme.colorScheme.onSurface,

                        lineHeight = MaterialTheme.typography.bodyMedium.lineHeight
                    )
                }
            }

    // LOKASI
            item {

                DetailSection(
                    title = "Lokasi Presensi",
                    icon = Icons.Default.LocationOn
                ) {

                    Text(
                        text = lokasi,

                        style = MaterialTheme.typography.titleSmall,

                        fontWeight = FontWeight.Bold,

                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )


                    // KOORDINAT

                    CoordinateCard(
                        latitude = latitude,
                        longitude = longitude
                    )


                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )


                    // STATUS LOKASI

                    Surface(
                        modifier = Modifier.fillMaxWidth(),

                        shape = RoundedCornerShape(12.dp),

                        color = MaterialTheme.colorScheme.primaryContainer
                    ) {

                        Row(
                            modifier = Modifier.padding(12.dp),

                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Icon(
                                imageVector = Icons.Default.CheckCircle,

                                contentDescription = null,

                                tint = MaterialTheme.colorScheme.onPrimaryContainer,

                                modifier = Modifier.size(19.dp)
                            )

                            Spacer(
                                modifier = Modifier.width(9.dp)
                            )

                            Column(
                                modifier = Modifier.weight(1f)
                            ) {

                                Text(
                                    text = "Lokasi berhasil diverifikasi",

                                    style = MaterialTheme.typography.labelLarge,

                                    fontWeight = FontWeight.SemiBold,

                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )

                                Text(
                                    text = "Presensi dilakukan dalam radius yang diizinkan.",

                                    style = MaterialTheme.typography.labelSmall,

                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        }
                    }


                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )


                    // GOOGLE MAPS

                    OutlinedButton(

                        onClick = {

                            val uri = Uri.parse(
                                "geo:$latitude,$longitude?q=$latitude,$longitude"
                            )

                            val intent = Intent(
                                Intent.ACTION_VIEW,
                                uri
                            )

                            context.startActivity(intent)
                        },

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),

                        shape = RoundedCornerShape(12.dp)
                    ) {

                        Icon(
                            imageVector = Icons.Default.Map,
                            contentDescription = null
                        )

                        Spacer(
                            modifier = Modifier.width(8.dp)
                        )

                        Text(
                            text = "Lihat Lokasi di Maps"
                        )
                    }
                }
            }

 // DOKUMENTASI
            item {

                DetailSection(
                    title = "Dokumentasi",
                    icon = Icons.Default.CameraAlt
                ) {

                    Box(

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(190.dp)
                            .clip(
                                RoundedCornerShape(14.dp)
                            )
                            .background(
                                MaterialTheme.colorScheme.surfaceVariant
                            ),

                        contentAlignment = Alignment.Center
                    ) {

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Surface(

                                modifier = Modifier.size(58.dp),

                                shape = RoundedCornerShape(16.dp),

                                color = MaterialTheme.colorScheme.primaryContainer
                            ) {

                                Box(
                                    contentAlignment = Alignment.Center
                                ) {

                                    Icon(
                                        imageVector = Icons.Default.CameraAlt,

                                        contentDescription = null,

                                        tint = MaterialTheme.colorScheme.primary,

                                        modifier = Modifier.size(28.dp)
                                    )
                                }
                            }

                            Spacer(
                                modifier = Modifier.height(10.dp)
                            )

                            Text(
                                text = "Foto Kegiatan",

                                style = MaterialTheme.typography.titleSmall,

                                fontWeight = FontWeight.SemiBold
                            )

                            Spacer(
                                modifier = Modifier.height(3.dp)
                            )

                            Text(
                                text = "Dokumentasi akan ditampilkan di sini",

                                style = MaterialTheme.typography.bodySmall,

                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }


           // SINKRONISASI
            item {

                SyncStatusCard()
            }
        }
    }
}

// STATUS CARD
@Composable
private fun ActivityStatusCard(
    activityName: String,
    date: String,
    time: String,
    status: String
) {

    Card(

        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(22.dp),

        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(

                    modifier = Modifier.size(52.dp),

                    shape = RoundedCornerShape(15.dp),

                    color = Color.White.copy(
                        alpha = 0.14f
                    )
                ) {

                    Box(
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.CheckCircle,

                            contentDescription = null,

                            tint = Color.White,

                            modifier = Modifier.size(28.dp)
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.width(13.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Presensi Berhasil",

                        style = MaterialTheme.typography.labelMedium,

                        color = Color.White.copy(
                            alpha = 0.78f
                        )
                    )

                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )

                    Text(
                        text = activityName,

                        style = MaterialTheme.typography.headlineSmall,

                        fontWeight = FontWeight.Bold,

                        color = Color.White
                    )

                    Spacer(
                        modifier = Modifier.height(3.dp)
                    )

                    Text(
                        text = "$date • $time",

                        style = MaterialTheme.typography.bodySmall,

                        color = Color.White.copy(
                            alpha = 0.78f
                        )
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )


            // STATUS BADGE

            Surface(

                shape = RoundedCornerShape(50.dp),

                color = Color.White.copy(
                    alpha = 0.14f
                )
            ) {

                Row(
                    modifier = Modifier.padding(
                        horizontal = 11.dp,
                        vertical = 7.dp
                    ),

                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.CheckCircle,

                        contentDescription = null,

                        tint = Color.White,

                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(
                        modifier = Modifier.width(6.dp)
                    )

                    Text(
                        text = status.uppercase(),

                        style = MaterialTheme.typography.labelSmall,

                        fontWeight = FontWeight.Bold,

                        color = Color.White
                    )
                }
            }
        }
    }
}
// DETAIL SECTION
@Composable
private fun DetailSection(
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

                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.width(10.dp)
                )

                Text(
                    text = title,

                    style = MaterialTheme.typography.titleMedium,

                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            content()
        }
    }
}

// DETAIL INFO ROW

@Composable
private fun DetailInfoRow(
    icon: ImageVector,
    label: String,
    value: String,
    valueColor: Color = MaterialTheme.colorScheme.onSurface
) {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,

            contentDescription = null,

            tint = MaterialTheme.colorScheme.onSurfaceVariant,

            modifier = Modifier.size(18.dp)
        )

        Spacer(
            modifier = Modifier.width(10.dp)
        )

        Text(
            text = label,

            style = MaterialTheme.typography.bodyMedium,

            color = MaterialTheme.colorScheme.onSurfaceVariant,

            modifier = Modifier.weight(1f)
        )

        Text(
            text = value,

            style = MaterialTheme.typography.bodyMedium,

            fontWeight = FontWeight.SemiBold,

            color = valueColor
        )
    }
}

//COORDINATE CARD

@Composable
private fun CoordinateCard(
    latitude: Double,
    longitude: Double
) {

    Surface(

        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(13.dp),

        color = MaterialTheme.colorScheme.surfaceVariant
    ) {

        Row(
            modifier = Modifier.padding(12.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.LocationOn,

                contentDescription = null,

                tint = MaterialTheme.colorScheme.primary,

                modifier = Modifier.size(20.dp)
            )

            Spacer(
                modifier = Modifier.width(9.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Koordinat Presensi",

                    style = MaterialTheme.typography.labelMedium,

                    fontWeight = FontWeight.SemiBold
                )

                Spacer(
                    modifier = Modifier.height(2.dp)
                )

                Text(
                    text = "Lat $latitude",

                    style = MaterialTheme.typography.labelSmall,

                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text(
                    text = "Long $longitude",

                    style = MaterialTheme.typography.labelSmall,

                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}


// SYNC STATUS
@Composable
private fun SyncStatusCard() {

    Card(

        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(18.dp),

        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {

        Row(

            modifier = Modifier.padding(15.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Surface(

                modifier = Modifier.size(40.dp),

                shape = RoundedCornerShape(12.dp),

                color = Color(0xFFE8F5E9)
            ) {

                Box(
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.Sync,

                        contentDescription = null,

                        tint = Color(0xFF2E7D32),

                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(
                modifier = Modifier.width(10.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Data tersinkronisasi",

                    style = MaterialTheme.typography.labelLarge,

                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = "Presensi telah tersimpan di server.",

                    style = MaterialTheme.typography.labelSmall,

                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Text(
                text = "Online",

                style = MaterialTheme.typography.labelSmall,

                fontWeight = FontWeight.Bold,

                color = Color(0xFF2E7D32)
            )
        }
    }
}