package com.example.si_absen.ui.pegawai

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class JadwalKerja(
    val hari: String,
    val jam: String,
    val keterangan: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JadwalKerjaScreen() {

    val jadwal = listOf(
        JadwalKerja(
            hari = "Senin",
            jam = "07:30 - 16:00",
            keterangan = "Jam kerja normal"
        ),
        JadwalKerja(
            hari = "Selasa",
            jam = "07:30 - 16:00",
            keterangan = "Jam kerja normal"
        ),
        JadwalKerja(
            hari = "Rabu",
            jam = "07:30 - 16:00",
            keterangan = "Jam kerja normal"
        ),
        JadwalKerja(
            hari = "Kamis",
            jam = "07:30 - 16:00",
            keterangan = "Jam kerja normal"
        ),
        JadwalKerja(
            hari = "Jumat",
            jam = "07:30 - 11:00",
            keterangan = "Jam kerja lebih singkat"
        )
    )

    val hariIni = remember {
        SimpleDateFormat(
            "EEEE",
            Locale("id", "ID")
        ).format(Date())
            .replaceFirstChar {
                if (it.isLowerCase()) {
                    it.titlecase(Locale("id", "ID"))
                } else {
                    it.toString()
                }
            }
    }

    val jadwalHariIni = jadwal.find {
        it.hari.equals(
            hariIni,
            ignoreCase = true
        )
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,

        topBar = {

            TopAppBar(

                title = {

                    Column {

                        Text(
                            text = "Jadwal Kerja",
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Jam kerja pegawai",
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
                .background(
                    MaterialTheme.colorScheme.background
                )
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
                                    .clip(
                                        RoundedCornerShape(14.dp)
                                    )
                                    .background(
                                        MaterialTheme.colorScheme.onPrimary.copy(
                                            alpha = 0.15f
                                        )
                                    ),

                                contentAlignment = Alignment.Center
                            ) {

                                Icon(
                                    imageVector = Icons.Default.CalendarMonth,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onPrimary,
                                    modifier = Modifier.size(26.dp)
                                )
                            }

                            Spacer(
                                modifier = Modifier.width(14.dp)
                            )

                            Column {

                                Text(
                                    text = "Jadwal Kerja Pegawai",
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(
                                    modifier = Modifier.height(2.dp)
                                )

                                Text(
                                    text = "Kalurahan Purwobinangun",
                                    color = MaterialTheme.colorScheme.onPrimary.copy(
                                        alpha = 0.85f
                                    ),
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }

                        Spacer(
                            modifier = Modifier.height(18.dp)
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
                            text = "Jam kerja aktif minggu ini",
                            color = MaterialTheme.colorScheme.onPrimary.copy(
                                alpha = 0.8f
                            ),
                            style = MaterialTheme.typography.bodySmall
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text = "Senin - Jumat",
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            // JADWAL HARI INI

            item {

                if (jadwalHariIni != null) {

                    Card(
                        modifier = Modifier.fillMaxWidth(),

                        shape = RoundedCornerShape(16.dp),

                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),

                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(44.dp)
                                    .clip(
                                        RoundedCornerShape(12.dp)
                                    )
                                    .background(
                                        MaterialTheme.colorScheme.primary.copy(
                                            alpha = 0.12f
                                        )
                                    ),

                                contentAlignment = Alignment.Center
                            ) {

                                Icon(
                                    imageVector = Icons.Default.Schedule,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }

                            Spacer(
                                modifier = Modifier.width(12.dp)
                            )

                            Column(
                                modifier = Modifier.weight(1f)
                            ) {

                                Text(
                                    text = "Jadwal Hari Ini",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )

                                Spacer(
                                    modifier = Modifier.height(2.dp)
                                )

                                Text(
                                    text = jadwalHariIni.hari,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )

                                Text(
                                    text = jadwalHariIni.keterangan,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(
                                        alpha = 0.75f
                                    )
                                )
                            }

                            Column(
                                horizontalAlignment = Alignment.End
                            ) {

                                Text(
                                    text = jadwalHariIni.jam,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )

                                Spacer(
                                    modifier = Modifier.height(4.dp)
                                )

                                Text(
                                    text = "Hari kerja",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        }
                    }
                }
            }

            // JADWAL MINGGUAN

            item {

                Text(
                    text = "Jadwal Mingguan",

                    style = MaterialTheme.typography.titleMedium,

                    fontWeight = FontWeight.Bold,

                    color = MaterialTheme.colorScheme.onBackground,

                    modifier = Modifier.padding(
                        top = 4.dp,
                        bottom = 2.dp
                    )
                )
            }

            items(
                items = jadwal,
                key = { it.hari }
            ) { item ->

                val isToday = item.hari.equals(
                    hariIni,
                    ignoreCase = true
                )

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
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),

                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(46.dp)
                                .clip(
                                    RoundedCornerShape(13.dp)
                                )
                                .background(
                                    if (isToday) {
                                        MaterialTheme.colorScheme.primaryContainer
                                    } else {
                                        MaterialTheme.colorScheme.surfaceVariant
                                    }
                                ),

                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = if (isToday) {
                                    Icons.Default.CheckCircle
                                } else {
                                    Icons.Default.CalendarMonth
                                },

                                contentDescription = null,

                                tint = if (isToday) {
                                    MaterialTheme.colorScheme.primary
                                } else {
                                    MaterialTheme.colorScheme.onSurfaceVariant
                                },

                                modifier = Modifier.size(23.dp)
                            )
                        }

                        Spacer(
                            modifier = Modifier.width(14.dp)
                        )

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Text(
                                    text = item.hari,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )

                                if (isToday) {

                                    Spacer(
                                        modifier = Modifier.width(8.dp)
                                    )

                                    Surface(
                                        shape = RoundedCornerShape(50),
                                        color = MaterialTheme.colorScheme.primaryContainer
                                    ) {

                                        Text(
                                            text = "Hari ini",

                                            modifier = Modifier.padding(
                                                horizontal = 8.dp,
                                                vertical = 4.dp
                                            ),

                                            style = MaterialTheme.typography.labelSmall,

                                            fontWeight = FontWeight.SemiBold,

                                            color = MaterialTheme.colorScheme.primary
                                        )
                                    }
                                }
                            }

                            Spacer(
                                modifier = Modifier.height(3.dp)
                            )

                            Text(
                                text = item.keterangan,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.End
                        ) {

                            Icon(
                                imageVector = Icons.Default.AccessTime,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(18.dp)
                            )

                            Spacer(
                                modifier = Modifier.height(4.dp)
                            )

                            Text(
                                text = item.jam,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }

            // KETERANGAN

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
                            imageVector = Icons.Default.AccessTime,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(22.dp)
                        )

                        Spacer(
                            modifier = Modifier.width(12.dp)
                        )

                        Column {

                            Text(
                                text = "Keterangan",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(
                                modifier = Modifier.height(6.dp)
                            )

                            Text(
                                text = "Pegawai wajib melakukan absensi masuk dan pulang sesuai jadwal yang telah ditentukan oleh Kalurahan Purwobinangun.",

                                style = MaterialTheme.typography.bodySmall,

                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                text = "Jumat memiliki jam kerja lebih singkat.",

                                style = MaterialTheme.typography.bodySmall,

                                fontWeight = FontWeight.Medium,

                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }
    }
}