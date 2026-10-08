package com.example.si_absen.ui.dukuh

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.HourglassTop
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class RiwayatKegiatan(
    val nama: String,
    val tanggal: String,
    val status: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RiwayatKegiatanDusunScreen() {

    var search by remember {
        mutableStateOf("")
    }

    val riwayat = listOf(
        RiwayatKegiatan(
            nama = "Kerja Bakti",
            tanggal = "10 September 2026",
            status = "Disetujui"
        ),
        RiwayatKegiatan(
            nama = "Pendataan Warga",
            tanggal = "08 September 2026",
            status = "Disetujui"
        ),
        RiwayatKegiatan(
            nama = "Musyawarah RT",
            tanggal = "05 September 2026",
            status = "Menunggu"
        )
    )

    val filteredList = riwayat.filter {
        it.nama.contains(search, ignoreCase = true)
    }

    val jumlahDisetujui = riwayat.count {
        it.status == "Disetujui"
    }

    val jumlahMenunggu = riwayat.count {
        it.status == "Menunggu"
    }

    val colorScheme = MaterialTheme.colorScheme

    Scaffold(
        containerColor = colorScheme.background,

        topBar = {
            TopAppBar(
                title = {
                    Column {

                        Text(
                            text = "Riwayat Kegiatan",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Riwayat kegiatan wilayah dusun",
                            style = MaterialTheme.typography.bodySmall,
                            color = colorScheme.onSurfaceVariant
                        )
                    }
                }
            )
        }

    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp,
                bottom = 24.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // HEADER
            item {

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
                                    text = "Total Kegiatan",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = colorScheme.onPrimary.copy(
                                        alpha = 0.85f
                                    )
                                )

                                Spacer(
                                    modifier = Modifier.height(4.dp)
                                )

                                Text(
                                    text = "${riwayat.size}",
                                    style = MaterialTheme.typography.displaySmall,
                                    fontWeight = FontWeight.Bold,
                                    color = colorScheme.onPrimary
                                )

                                Text(
                                    text = "Kegiatan yang telah diajukan",
                                    style = MaterialTheme.typography.bodySmall,
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
                                        imageVector = Icons.Default.Event,
                                        contentDescription = null,
                                        tint = colorScheme.onPrimary,
                                        modifier = Modifier.size(28.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
 // RINGKASAN STATUS

            item {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    RiwayatSummaryCard(
                        modifier = Modifier.weight(1f),
                        title = "Disetujui",
                        value = jumlahDisetujui.toString(),
                        icon = Icons.Default.CheckCircle
                    )

                    RiwayatSummaryCard(
                        modifier = Modifier.weight(1f),
                        title = "Menunggu",
                        value = jumlahMenunggu.toString(),
                        icon = Icons.Default.HourglassTop
                    )
                }
            }
            // SEARCH

            item {

                OutlinedTextField(
                    value = search,
                    onValueChange = {
                        search = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(14.dp),
                    label = {
                        Text(
                            text = "Cari Kegiatan"
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Masukkan nama kegiatan..."
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                    trailingIcon = {
                        if (search.isNotEmpty()) {
                            IconButton(
                                onClick = {
                                    search = ""
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.SearchOff,
                                    contentDescription = "Hapus pencarian"
                                )
                            }
                        }
                    }
                )
            }
            // JUDUL HASIL

            item {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "Daftar Kegiatan",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = colorScheme.onSurface
                    )

                    Surface(
                        shape = RoundedCornerShape(50.dp),
                        color = colorScheme.primaryContainer
                    ) {

                        Text(
                            text = "${filteredList.size} Data",
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
            }
             // EMPTY STATE

            if (filteredList.isEmpty()) {

                item {

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = colorScheme.surfaceVariant
                        )
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(28.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Icon(
                                imageVector = Icons.Default.SearchOff,
                                contentDescription = null,
                                modifier = Modifier.size(42.dp),
                                tint = colorScheme.onSurfaceVariant
                            )

                            Spacer(
                                modifier = Modifier.height(12.dp)
                            )

                            Text(
                                text = "Kegiatan tidak ditemukan",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = colorScheme.onSurface
                            )

                            Spacer(
                                modifier = Modifier.height(4.dp)
                            )

                            Text(
                                text = "Coba gunakan kata kunci pencarian yang berbeda.",
                                style = MaterialTheme.typography.bodySmall,
                                color = colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

            } else {

                // LIST KEGIATAN

                items(
                    items = filteredList,
                    key = {
                        "${it.nama}-${it.tanggal}"
                    }
                ) { item ->

                    RiwayatKegiatanCard(
                        item = item
                    )
                }
            }
        }
    }
}

@Composable
private fun RiwayatSummaryCard(
    modifier: Modifier,
    title: String,
    value: String,
    icon: ImageVector
) {

    val colorScheme = MaterialTheme.colorScheme

    Card(
        modifier = modifier,
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
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.size(19.dp),
                        tint = colorScheme.onPrimaryContainer
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall,
                color = colorScheme.onSurfaceVariant
            )

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            Text(
                text = value,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = colorScheme.primary
            )
        }
    }
}

@Composable
private fun RiwayatKegiatanCard(
    item: RiwayatKegiatan
) {

    val colorScheme = MaterialTheme.colorScheme

    val isApproved = item.status == "Disetujui"

    val statusContainer = if (isApproved) {
        colorScheme.primaryContainer
    } else {
        colorScheme.secondaryContainer
    }

    val statusContent = if (isApproved) {
        colorScheme.onPrimaryContainer
    } else {
        colorScheme.onSecondaryContainer
    }

    val statusIcon = if (isApproved) {
        Icons.Default.CheckCircle
    } else {
        Icons.Default.HourglassTop
    }

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

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    modifier = Modifier.size(44.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = colorScheme.primaryContainer
                ) {

                    Box(
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.Event,
                            contentDescription = null,
                            modifier = Modifier.size(22.dp),
                            tint = colorScheme.onPrimaryContainer
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
                        text = item.nama,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = colorScheme.onSurface
                    )

                    Spacer(
                        modifier = Modifier.height(3.dp)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Default.CalendarMonth,
                            contentDescription = null,
                            modifier = Modifier.size(15.dp),
                            tint = colorScheme.onSurfaceVariant
                        )

                        Spacer(
                            modifier = Modifier.width(5.dp)
                        )

                        Text(
                            text = item.tanggal,
                            style = MaterialTheme.typography.bodySmall,
                            color = colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            HorizontalDivider(
                color = colorScheme.outlineVariant
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = statusIcon,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint = statusContent
                    )

                    Spacer(
                        modifier = Modifier.width(7.dp)
                    )

                    Text(
                        text = "Status Pengajuan",
                        style = MaterialTheme.typography.bodySmall,
                        color = colorScheme.onSurfaceVariant
                    )
                }

                Surface(
                    shape = RoundedCornerShape(50.dp),
                    color = statusContainer
                ) {

                    Text(
                        text = item.status,
                        modifier = Modifier.padding(
                            horizontal = 11.dp,
                            vertical = 6.dp
                        ),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = statusContent
                    )
                }
            }
        }
    }
}