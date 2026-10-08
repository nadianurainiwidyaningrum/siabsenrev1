package com.example.si_absen.ui.dukuh

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class RekapItem(
    val title: String,
    val value: String,
    val description: String,
    val icon: ImageVector
)

data class RiwayatRekap(
    val tanggal: String,
    val status: String,
    val waktu: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RekapDusunScreen() {

    val statistik = listOf(
        RekapItem(
            title = "Hadir",
            value = "22",
            description = "Hari hadir",
            icon = Icons.Default.CheckCircle
        ),
        RekapItem(
            title = "Terlambat",
            value = "2",
            description = "Kali terlambat",
            icon = Icons.Default.Schedule
        ),
        RekapItem(
            title = "Kegiatan",
            value = "15",
            description = "Kegiatan dusun",
            icon = Icons.Default.Event
        ),
        RekapItem(
            title = "Izin",
            value = "1",
            description = "Hari izin",
            icon = Icons.Default.Assessment
        )
    )

    val riwayat = listOf(
        RiwayatRekap(
            tanggal = "08 Sep 2026",
            status = "Hadir",
            waktu = "07.35 WIB"
        ),
        RiwayatRekap(
            tanggal = "09 Sep 2026",
            status = "Hadir",
            waktu = "07.40 WIB"
        ),
        RiwayatRekap(
            tanggal = "10 Sep 2026",
            status = "Terlambat",
            waktu = "08.15 WIB"
        ),
        RiwayatRekap(
            tanggal = "11 Sep 2026",
            status = "Hadir",
            waktu = "07.30 WIB"
        )
    )

    val colorScheme = MaterialTheme.colorScheme

    Scaffold(
        containerColor = colorScheme.background,

        topBar = {
            TopAppBar(
                title = {
                    Column {

                        Text(
                            text = "Rekap Kehadiran",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Ringkasan kehadiran wilayah dusun",
                            style = MaterialTheme.typography.bodySmall,
                            color = colorScheme.onSurfaceVariant
                        )
                    }
                }
            )
        }

    ) { padding ->

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp,
                bottom = 24.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) { // HEADER REKAP
            item(
                span = {
                    androidx.compose.foundation.lazy.grid.GridItemSpan(
                        maxLineSpan
                    )
                }
            ) {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = colorScheme.primary
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier.weight(1f)
                            ) {

                                Text(
                                    text = "Rekap Bulan September 2026",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = colorScheme.onPrimary.copy(
                                        alpha = 0.85f
                                    )
                                )

                                Spacer(
                                    modifier = Modifier.height(6.dp)
                                )

                                Text(
                                    text = "92%",
                                    style = MaterialTheme.typography.displaySmall,
                                    fontWeight = FontWeight.Bold,
                                    color = colorScheme.onPrimary
                                )

                                Text(
                                    text = "Persentase Kehadiran",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = colorScheme.onPrimary.copy(
                                        alpha = 0.85f
                                    )
                                )
                            }

                            Surface(
                                modifier = Modifier.size(54.dp),
                                shape = RoundedCornerShape(16.dp),
                                color = colorScheme.onPrimary.copy(
                                    alpha = 0.15f
                                )
                            ) {

                                Box(
                                    contentAlignment = Alignment.Center
                                ) {

                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.TrendingUp,
                                        contentDescription = null,
                                        tint = colorScheme.onPrimary,
                                        modifier = Modifier.size(28.dp)
                                    )
                                }
                            }
                        }

                        Spacer(
                            modifier = Modifier.height(18.dp)
                        )

                        LinearProgressIndicator(
                            progress = { 0.92f },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(7.dp),
                            color = colorScheme.onPrimary,
                            trackColor = colorScheme.onPrimary.copy(
                                alpha = 0.20f
                            )
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "Tingkat kehadiran bulan ini sangat baik",
                            style = MaterialTheme.typography.bodySmall,
                            color = colorScheme.onPrimary.copy(
                                alpha = 0.85f
                            )
                        )
                    }
                }
            }
            // JUDUL STATISTIK
            item(
                span = {
                    androidx.compose.foundation.lazy.grid.GridItemSpan(
                        maxLineSpan
                    )
                }
            ) {

                Text(
                    text = "Statistik Kehadiran",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = colorScheme.onSurface,
                    modifier = Modifier.padding(
                        top = 8.dp,
                        bottom = 2.dp
                    )
                )
            }
             // STATISTIK


            items(
                items = statistik,
                key = { it.title }
            ) { item ->

                RekapStatistikCard(
                    item = item
                )
            }
 // INFORMASI

            item(
                span = {
                    androidx.compose.foundation.lazy.grid.GridItemSpan(
                        maxLineSpan
                    )
                }
            ) {

                Column {

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "Informasi Kehadiran",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = colorScheme.onSurface
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = colorScheme.surface
                        ),
                        border = CardDefaults.outlinedCardBorder()
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            RekapInfoRow(
                                icon = Icons.Default.CalendarMonth,
                                label = "Hari Kerja",
                                value = "24 Hari"
                            )

                            HorizontalDivider(
                                modifier = Modifier.padding(
                                    vertical = 12.dp
                                ),
                                color = colorScheme.outlineVariant
                            )

                            RekapInfoRow(
                                icon = Icons.Default.CheckCircle,
                                label = "Total Hadir",
                                value = "22 Hari"
                            )

                            HorizontalDivider(
                                modifier = Modifier.padding(
                                    vertical = 12.dp
                                ),
                                color = colorScheme.outlineVariant
                            )

                            RekapInfoRow(
                                icon = Icons.Default.Schedule,
                                label = "Total Terlambat",
                                value = "2 Hari"
                            )

                            HorizontalDivider(
                                modifier = Modifier.padding(
                                    vertical = 12.dp
                                ),
                                color = colorScheme.outlineVariant
                            )

                            RekapInfoRow(
                                icon = Icons.Default.Event,
                                label = "Total Kegiatan",
                                value = "15 Kegiatan"
                            )

                            HorizontalDivider(
                                modifier = Modifier.padding(
                                    vertical = 12.dp
                                ),
                                color = colorScheme.outlineVariant
                            )

                            RekapInfoRow(
                                icon = Icons.Default.CheckCircle,
                                label = "Status",
                                value = "Aktif",
                                valueColor = colorScheme.primary
                            )
                        }
                    }
                }
            }
            // RIWAYAT

            item(
                span = {
                    androidx.compose.foundation.lazy.grid.GridItemSpan(
                        maxLineSpan
                    )
                }
            ) {

                Column {

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "Riwayat Bulan Ini",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = colorScheme.onSurface
                        )

                        Surface(
                            shape = RoundedCornerShape(50.dp),
                            color = colorScheme.primaryContainer
                        ) {

                            Text(
                                text = "${riwayat.size} Data",
                                modifier = Modifier.padding(
                                    horizontal = 10.dp,
                                    vertical = 5.dp
                                ),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.SemiBold,
                                color = colorScheme.onPrimaryContainer
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = colorScheme.surface
                        ),
                        border = CardDefaults.outlinedCardBorder()
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            riwayat.forEachIndexed { index, item ->

                                RiwayatRekapRow(
                                    item = item,
                                    isLast = index == riwayat.lastIndex
                                )
                            }
                        }
                    }
                }
            }
     // KESIMPULAN

            item(
                span = {
                    androidx.compose.foundation.lazy.grid.GridItemSpan(
                        maxLineSpan
                    )
                }
            ) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = colorScheme.surfaceVariant
                    )
                ) {

                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Surface(
                            modifier = Modifier.size(42.dp),
                            shape = RoundedCornerShape(12.dp),
                            color = colorScheme.primaryContainer
                        ) {

                            Box(
                                contentAlignment = Alignment.Center
                            ) {

                                Icon(
                                    imageVector = Icons.Default.Assessment,
                                    contentDescription = null,
                                    tint = colorScheme.onPrimaryContainer,
                                    modifier = Modifier.size(22.dp)
                                )
                            }
                        }

                        Spacer(
                            modifier = Modifier.width(12.dp)
                        )

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = "Ringkasan",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = colorScheme.onSurface
                            )

                            Spacer(
                                modifier = Modifier.height(3.dp)
                            )

                            Text(
                                text = "Kehadiran Dukuh pada bulan ini berada dalam kondisi baik dengan persentase 92%.",
                                style = MaterialTheme.typography.bodySmall,
                                color = colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun RekapStatistikCard(
    item: RekapItem
) {

    val colorScheme = MaterialTheme.colorScheme

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(132.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.surface
        ),
        border = CardDefaults.outlinedCardBorder()
    ) {

        Column(
            modifier = Modifier.padding(14.dp)
        ) {

            Surface(
                modifier = Modifier.size(36.dp),
                shape = RoundedCornerShape(10.dp),
                color = colorScheme.primaryContainer
            ) {

                Box(
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = item.icon,
                        contentDescription = null,
                        tint = colorScheme.onPrimaryContainer,
                        modifier = Modifier.size(19.dp)
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = item.title,
                style = MaterialTheme.typography.bodySmall,
                color = colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            Text(
                text = item.value,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = colorScheme.primary
            )

            Text(
                text = item.description,
                style = MaterialTheme.typography.labelSmall,
                color = colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun RekapInfoRow(
    icon: ImageVector,
    label: String,
    value: String,
    valueColor: androidx.compose.ui.graphics.Color =
        MaterialTheme.colorScheme.onSurface
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Surface(
            modifier = Modifier.size(38.dp),
            shape = RoundedCornerShape(10.dp),
            color = MaterialTheme.colorScheme.surfaceVariant
        ) {

            Box(
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(19.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(
            modifier = Modifier.width(12.dp)
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

@Composable
private fun RiwayatRekapRow(
    item: RiwayatRekap,
    isLast: Boolean
) {

    val colorScheme = MaterialTheme.colorScheme

    Column {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Surface(
                modifier = Modifier.size(38.dp),
                shape = RoundedCornerShape(10.dp),
                color = if (item.status == "Hadir") {
                    colorScheme.primaryContainer
                } else {
                    colorScheme.secondaryContainer
                }
            ) {

                Box(
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = if (item.status == "Hadir") {
                            Icons.Default.CheckCircle
                        } else {
                            Icons.Default.Schedule
                        },
                        contentDescription = null,
                        modifier = Modifier.size(19.dp),
                        tint = if (item.status == "Hadir") {
                            colorScheme.onPrimaryContainer
                        } else {
                            colorScheme.onSecondaryContainer
                        }
                    )
                }
            }

            Spacer(
                modifier = Modifier.width(12.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = item.tanggal,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = colorScheme.onSurface
                )

                Spacer(
                    modifier = Modifier.height(2.dp)
                )

                Text(
                    text = item.waktu,
                    style = MaterialTheme.typography.bodySmall,
                    color = colorScheme.onSurfaceVariant
                )
            }

            Surface(
                shape = RoundedCornerShape(50.dp),
                color = if (item.status == "Hadir") {
                    colorScheme.primaryContainer
                } else {
                    colorScheme.secondaryContainer
                }
            ) {

                Text(
                    text = item.status,
                    modifier = Modifier.padding(
                        horizontal = 10.dp,
                        vertical = 5.dp
                    ),
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = if (item.status == "Hadir") {
                        colorScheme.onPrimaryContainer
                    } else {
                        colorScheme.onSecondaryContainer
                    }
                )
            }
        }

        if (!isLast) {

            HorizontalDivider(
                modifier = Modifier.padding(
                    vertical = 12.dp
                ),
                color = colorScheme.outlineVariant
            )
        }
    }
}