package com.example.si_absen.ui.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Sick
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class StatistikItem(
    val title: String,
    val value: String,
    val icon: ImageVector,
    val description: String,
    val containerColor: Color,
    val contentColor: Color
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatistikScreen() {

    val colorScheme = MaterialTheme.colorScheme

    val statistik = remember {

        listOf(
            StatistikItem(
                title = "Total Pegawai",
                value = "35",
                icon = Icons.Default.Groups,
                description = "Pegawai terdaftar",
                containerColor = colorScheme.primaryContainer,
                contentColor = colorScheme.onPrimaryContainer
            ),
            StatistikItem(
                title = "Total Dukuh",
                value = "8",
                icon = Icons.Default.Person,
                description = "Dukuh terdaftar",
                containerColor = colorScheme.secondaryContainer,
                contentColor = colorScheme.onSecondaryContainer
            ),
            StatistikItem(
                title = "Hadir",
                value = "40",
                icon = Icons.Default.CheckCircle,
                description = "Catatan kehadiran",
                containerColor = colorScheme.primaryContainer,
                contentColor = colorScheme.onPrimaryContainer
            ),
            StatistikItem(
                title = "Terlambat",
                value = "5",
                icon = Icons.Default.Schedule,
                description = "Catatan keterlambatan",
                containerColor = colorScheme.secondaryContainer,
                contentColor = colorScheme.onSecondaryContainer
            ),
            StatistikItem(
                title = "Izin",
                value = "2",
                icon = Icons.Default.Assessment,
                description = "Catatan izin",
                containerColor = colorScheme.surfaceVariant,
                contentColor = colorScheme.onSurfaceVariant
            ),
            StatistikItem(
                title = "Sakit",
                value = "1",
                icon = Icons.Default.Sick,
                description = "Catatan sakit",
                containerColor = colorScheme.surfaceVariant,
                contentColor = colorScheme.onSurfaceVariant
            ),
            StatistikItem(
                title = "Alpa",
                value = "0",
                icon = Icons.Default.Warning,
                description = "Tanpa keterangan",
                containerColor = colorScheme.errorContainer,
                contentColor = colorScheme.onErrorContainer
            )
        )
    }

    val statistikRows = statistik.chunked(2)

    Scaffold(
        containerColor = colorScheme.background,

        topBar = {
            TopAppBar(
                title = {
                    Column {

                        Text(
                            text = "Statistik Kehadiran",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Ringkasan data presensi",
                            style = MaterialTheme.typography.labelMedium,
                            color = colorScheme.onSurfaceVariant
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(colorScheme.background)
                .padding(paddingValues),

            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 12.dp,
                bottom = 24.dp
            ),

            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            // RINGKASAN

            item {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = colorScheme.primary
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier.weight(1f)
                            ) {

                                Text(
                                    text = "Tingkat Kehadiran",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = colorScheme.onPrimary.copy(
                                        alpha = 0.85f
                                    )
                                )

                                Spacer(
                                    modifier = Modifier.height(5.dp)
                                )

                                Text(
                                    text = "93%",
                                    style = MaterialTheme.typography.displaySmall,
                                    fontWeight = FontWeight.Bold,
                                    color = colorScheme.onPrimary
                                )

                                Text(
                                    text = "Periode September 2026",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = colorScheme.onPrimary.copy(
                                        alpha = 0.8f
                                    )
                                )
                            }

                            Surface(
                                shape = CircleShape,
                                color = colorScheme.onPrimary.copy(
                                    alpha = 0.14f
                                )
                            ) {

                                Icon(
                                    imageVector = Icons.Default.TrendingUp,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .size(34.dp),
                                    tint = colorScheme.onPrimary
                                )
                            }
                        }

                        Spacer(
                            modifier = Modifier.height(18.dp)
                        )

                        HorizontalDivider(
                            color = colorScheme.onPrimary.copy(
                                alpha = 0.2f
                            )
                        )

                        Spacer(
                            modifier = Modifier.height(12.dp)
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = colorScheme.onPrimary,
                                modifier = Modifier.size(18.dp)
                            )

                            Spacer(
                                modifier = Modifier.width(8.dp)
                            )

                            Text(
                                text = "Ringkasan presensi bulanan",
                                style = MaterialTheme.typography.bodySmall,
                                color = colorScheme.onPrimary.copy(
                                    alpha = 0.9f
                                )
                            )
                        }
                    }
                }
            }

            // JUDUL

            item {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Rincian Statistik",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Data pegawai dan presensi",
                            style = MaterialTheme.typography.bodySmall,
                            color = colorScheme.onSurfaceVariant
                        )
                    }

                    Icon(
                        imageVector = Icons.Default.Assessment,
                        contentDescription = null,
                        tint = colorScheme.primary
                    )
                }
            }

            // STATISTIK

            items(
                items = statistikRows,
                key = { row ->
                    row.joinToString("-") {
                        it.title
                    }
                }
            ) { row ->

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    row.forEach { item ->

                        StatistikCard(
                            item = item,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    if (row.size == 1) {

                        Spacer(
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            // KESIMPULAN

            item {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = colorScheme.surface
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 1.dp
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Icon(
                                imageVector = Icons.Default.Assessment,
                                contentDescription = null,
                                tint = colorScheme.primary
                            )

                            Spacer(
                                modifier = Modifier.width(8.dp)
                            )

                            Text(
                                text = "Kesimpulan",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )

                        Text(
                            text = "Data menunjukkan tingkat kehadiran sebesar 93% pada periode September 2026. Terdapat beberapa catatan keterlambatan, izin, dan sakit yang perlu dipantau oleh administrator.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun StatistikCard(
    item: StatistikItem,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 150.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(14.dp)
        ) {

            Box(
                modifier = Modifier
                    .size(42.dp)
                    .background(
                        color = item.containerColor,
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = item.icon,
                    contentDescription = null,
                    tint = item.contentColor,
                    modifier = Modifier.size(23.dp)
                )
            }

            Spacer(
                modifier = Modifier.height(11.dp)
            )

            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Text(
                text = item.value,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Text(
                text = item.description,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}