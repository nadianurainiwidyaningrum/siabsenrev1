package com.example.si_absen.ui.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.PictureAsPdf
import androidx.compose.material.icons.filled.TableView
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.theme.PrimaryBlue
import com.example.si_absen.ui.theme.SuccessGreen
import com.example.si_absen.ui.theme.TextPrimary
import com.example.si_absen.ui.theme.TextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LaporanScreen(
    navController: NavController
) {
    var periode by remember { mutableStateOf("September 2026") }
    var jenisLaporan by remember { mutableStateOf("Semua Data") }
    var showPeriodeDialog by remember { mutableStateOf(false) }

    val totalPegawai = 35
    val totalDukuh = 8
    val totalKehadiran = 40
    val totalTerlambat = 5
    val totalTidakHadir = 3

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Laporan",
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Rekap dan ekspor data absensi",
                            style = MaterialTheme.typography.bodySmall,
                            color = TextSecondary
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
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
                .padding(
                    horizontal = 16.dp,
                    vertical = 16.dp
                ),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            // HEADER
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = PrimaryBlue
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
                        color = Color.White.copy(alpha = 0.16f)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Assessment,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(27.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column {
                        Text(
                            text = "Laporan Absensi",
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Kelola dan unduh data kehadiran pegawai",
                            color = Color.White.copy(alpha = 0.82f),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }

            // FILTER
            Text(
                text = "Filter Laporan",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Column {
                        Text(
                            text = "Periode",
                            style = MaterialTheme.typography.labelMedium,
                            color = TextSecondary
                        )

                        Spacer(modifier = Modifier.height(7.dp))

                        OutlinedButton(
                            onClick = {
                                showPeriodeDialog = true
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(
                                horizontal = 14.dp,
                                vertical = 12.dp
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Default.CalendarMonth,
                                contentDescription = null
                            )

                            Spacer(modifier = Modifier.width(9.dp))

                            Text(
                                text = periode,
                                modifier = Modifier.weight(1f),
                                color = TextPrimary
                            )

                            Text(
                                text = "Ubah",
                                color = PrimaryBlue,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    Column {
                        Text(
                            text = "Jenis Laporan",
                            style = MaterialTheme.typography.labelMedium,
                            color = TextSecondary
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        val pilihan = listOf(
                            "Semua Data",
                            "Semua Pegawai",
                            "Per Pegawai",
                            "Semua Dukuh",
                            "Per Dukuh"
                        )

                        pilihan.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 5.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = jenisLaporan == item,
                                    onClick = {
                                        jenisLaporan = item
                                    }
                                )

                                Spacer(modifier = Modifier.width(6.dp))

                                Text(
                                    text = item,
                                    color = TextPrimary
                                )
                            }
                        }
                    }
                }
            }

            // PREVIEW
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Ringkasan Laporan",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )

                    Text(
                        text = "$jenisLaporan • $periode",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )
                }

                Icon(
                    imageVector = Icons.Default.Description,
                    contentDescription = null,
                    tint = PrimaryBlue
                )
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    LaporanSummaryRow(
                        icon = Icons.Default.Groups,
                        label = "Total Pegawai",
                        value = "$totalPegawai orang"
                    )

                    HorizontalDivider()

                    LaporanSummaryRow(
                        icon = Icons.Default.Groups,
                        label = "Total Dukuh",
                        value = "$totalDukuh orang"
                    )

                    HorizontalDivider()

                    LaporanSummaryRow(
                        icon = Icons.Default.Assessment,
                        label = "Total Kehadiran",
                        value = "$totalKehadiran data"
                    )
                }
            }

            // STATISTIK
            Text(
                text = "Statistik Kehadiran",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                StatistikLaporanCard(
                    modifier = Modifier.weight(1f),
                    label = "Hadir",
                    value = totalKehadiran.toString(),
                    valueColor = SuccessGreen
                )

                StatistikLaporanCard(
                    modifier = Modifier.weight(1f),
                    label = "Terlambat",
                    value = totalTerlambat.toString(),
                    valueColor = MaterialTheme.colorScheme.error
                )

                StatistikLaporanCard(
                    modifier = Modifier.weight(1f),
                    label = "Tidak Hadir",
                    value = totalTidakHadir.toString(),
                    valueColor = MaterialTheme.colorScheme.error
                )
            }

            // EXPORT
            Text(
                text = "Ekspor Laporan",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Pilih format file yang ingin digunakan.",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )

                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.TableView,
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Export Excel",
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    OutlinedButton(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.PictureAsPdf,
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Export PDF",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            // INFO
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = PrimaryBlue.copy(alpha = 0.06f)
                )
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(
                        imageVector = Icons.Default.Download,
                        contentDescription = null,
                        tint = PrimaryBlue,
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "Laporan akan menggunakan data absensi sesuai periode dan jenis laporan yang dipilih.",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )
                }
            }
        }
    }

    // DIALOG PERIODE
    if (showPeriodeDialog) {
        AlertDialog(
            onDismissRequest = {
                showPeriodeDialog = false
            },
            title = {
                Text(
                    text = "Pilih Periode",
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    listOf(
                        "September 2026",
                        "Agustus 2026",
                        "Juli 2026",
                        "Juni 2026"
                    ).forEach { item ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = periode == item,
                                onClick = {
                                    periode = item
                                    showPeriodeDialog = false
                                }
                            )

                            Spacer(modifier = Modifier.width(6.dp))

                            Text(text = item)
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showPeriodeDialog = false
                    }
                ) {
                    Text("Tutup")
                }
            }
        )
    }
}

@Composable
private fun LaporanSummaryRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier.size(40.dp),
            shape = RoundedCornerShape(11.dp),
            color = PrimaryBlue.copy(alpha = 0.1f)
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = PrimaryBlue,
                    modifier = Modifier.size(21.dp)
                )
            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = label,
            modifier = Modifier.weight(1f),
            color = TextSecondary
        )

        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )
    }
}

@Composable
private fun StatistikLaporanCard(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    valueColor: Color
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 8.dp,
                    vertical = 14.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = valueColor
            )

            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = TextSecondary
            )
        }
    }
}