package com.example.si_absen.ui.admin

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.PriorityHigh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TambahPengumumanScreen() {

    val context = LocalContext.current

    var judul by remember {
        mutableStateOf("")
    }

    var isi by remember {
        mutableStateOf("")
    }

    var tanggalMulai by remember {
        mutableStateOf("")
    }

    var tanggalSelesai by remember {
        mutableStateOf("")
    }

    var prioritas by remember {
        mutableStateOf("Normal")
    }

    val daftarPrioritas = listOf(
        "Normal",
        "Penting",
        "Sangat Penting"
    )

    val formValid = judul.isNotBlank() &&
            isi.isNotBlank() &&
            tanggalMulai.isNotBlank()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,

        topBar = {
            TopAppBar(
                title = {
                    Column {

                        Text(
                            text = "Tambah Pengumuman",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Buat informasi untuk pengguna",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            )
        }

    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    MaterialTheme.colorScheme.background
                )
                .padding(padding)
                .padding(horizontal = 16.dp),

            verticalArrangement = Arrangement.spacedBy(16.dp),

            contentPadding = PaddingValues(
                top = 12.dp,
                bottom = 24.dp
            )
        ) {

            // HEADER INFORMASI

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

                        Surface(
                            modifier = Modifier.size(52.dp),
                            shape = RoundedCornerShape(14.dp),
                            color = MaterialTheme.colorScheme.onPrimary
                                .copy(alpha = 0.14f)
                        ) {

                            Box(
                                contentAlignment = Alignment.Center
                            ) {

                                Icon(
                                    imageVector = Icons.Default.Campaign,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onPrimary,
                                    modifier = Modifier.size(28.dp)
                                )
                            }
                        }

                        Spacer(
                            modifier = Modifier.width(14.dp)
                        )

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = "Publikasi Pengumuman",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimary
                            )

                            Spacer(
                                modifier = Modifier.height(4.dp)
                            )

                            Text(
                                text = "Informasi yang dipublikasikan akan dapat dilihat oleh pegawai dan dukuh.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onPrimary
                                    .copy(alpha = 0.82f)
                            )
                        }
                    }
                }
            }

            // INFORMASI DASAR

            item {

                SectionTitle(
                    title = "Informasi Pengumuman",
                    description = "Masukkan judul dan isi informasi."
                )
            }

            item {

                OutlinedTextField(
                    value = judul,
                    onValueChange = {
                        judul = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(14.dp),

                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Description,
                            contentDescription = null
                        )
                    },

                    label = {
                        Text("Judul Pengumuman")
                    },

                    placeholder = {
                        Text("Contoh: Rapat Kalurahan")
                    }
                )
            }

            item {

                OutlinedTextField(
                    value = isi,
                    onValueChange = {
                        isi = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 140.dp),

                    shape = RoundedCornerShape(14.dp),

                    label = {
                        Text("Isi Pengumuman")
                    },

                    placeholder = {
                        Text(
                            "Tuliskan informasi pengumuman di sini..."
                        )
                    },

                    minLines = 5
                )
            }

            // PRIORITAS

            item {

                SectionTitle(
                    title = "Prioritas",
                    description = "Tentukan tingkat kepentingan pengumuman."
                )
            }

            item {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(8.dp)
                    ) {

                        daftarPrioritas.forEach { item ->

                            val selected =
                                prioritas == item

                            Surface(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(12.dp),
                                color = if (selected) {
                                    MaterialTheme.colorScheme.primaryContainer
                                } else {
                                    MaterialTheme.colorScheme.surface
                                },
                                onClick = {
                                    prioritas = item
                                }
                            ) {

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(
                                            horizontal = 8.dp,
                                            vertical = 4.dp
                                        ),
                                    verticalAlignment =
                                    Alignment.CenterVertically
                                ) {

                                    RadioButton(
                                        selected = selected,
                                        onClick = {
                                            prioritas = item
                                        }
                                    )

                                    Spacer(
                                        modifier = Modifier.width(4.dp)
                                    )

                                    Icon(
                                        imageVector =
                                        if (item == "Normal") {
                                            Icons.Default.Description
                                        } else {
                                            Icons.Default.PriorityHigh
                                        },
                                        contentDescription = null,
                                        tint = if (selected) {
                                            MaterialTheme.colorScheme
                                                .onPrimaryContainer
                                        } else {
                                            MaterialTheme.colorScheme
                                                .onSurfaceVariant
                                        },
                                        modifier = Modifier.size(20.dp)
                                    )

                                    Spacer(
                                        modifier = Modifier.width(10.dp)
                                    )

                                    Column(
                                        modifier = Modifier.weight(1f)
                                    ) {

                                        Text(
                                            text = item,
                                            style = MaterialTheme
                                                .typography.bodyMedium,
                                            fontWeight =
                                            if (selected) {
                                                FontWeight.SemiBold
                                            } else {
                                                FontWeight.Normal
                                            },
                                            color = if (selected) {
                                                MaterialTheme.colorScheme
                                                    .onPrimaryContainer
                                            } else {
                                                MaterialTheme.colorScheme
                                                    .onSurface
                                            }
                                        )

                                        Text(
                                            text = when (item) {
                                                "Normal" ->
                                                    "Informasi umum"
                                                "Penting" ->
                                                    "Perlu diperhatikan"
                                                else ->
                                                    "Informasi sangat penting"
                                            },
                                            style = MaterialTheme
                                                .typography.labelSmall,
                                            color = if (selected) {
                                                MaterialTheme.colorScheme
                                                    .onPrimaryContainer
                                                    .copy(alpha = 0.75f)
                                            } else {
                                                MaterialTheme.colorScheme
                                                    .onSurfaceVariant
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // PERIODE
            item {

                SectionTitle(
                    title = "Periode Pengumuman",
                    description = "Atur masa berlaku pengumuman."
                )
            }

            item {

                OutlinedTextField(
                    value = tanggalMulai,
                    onValueChange = {
                        tanggalMulai = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(14.dp),

                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.CalendarMonth,
                            contentDescription = null
                        )
                    },

                    label = {
                        Text("Tanggal Mulai")
                    },

                    placeholder = {
                        Text("Contoh: 15 September 2026")
                    }
                )
            }

            item {

                OutlinedTextField(
                    value = tanggalSelesai,
                    onValueChange = {
                        tanggalSelesai = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(14.dp),

                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.CalendarMonth,
                            contentDescription = null
                        )
                    },

                    label = {
                        Text("Tanggal Selesai")
                    },

                    placeholder = {
                        Text("Contoh: 20 September 2026")
                    }
                )
            }

            // PREVIEW

            item {

                SectionTitle(
                    title = "Preview Pengumuman",
                    description = "Tampilan informasi sebelum dipublikasikan."
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
                        defaultElevation = 2.dp
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(18.dp)
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = MaterialTheme.colorScheme
                                    .primaryContainer
                            ) {

                                Icon(
                                    imageVector = Icons.Default.Campaign,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme
                                        .onPrimaryContainer,
                                    modifier = Modifier
                                        .padding(9.dp)
                                        .size(21.dp)
                                )
                            }

                            Spacer(
                                modifier = Modifier.width(12.dp)
                            )

                            Column(
                                modifier = Modifier.weight(1f)
                            ) {

                                Text(
                                    text = if (judul.isBlank()) {
                                        "Belum ada judul"
                                    } else {
                                        judul
                                    },
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(
                                    modifier = Modifier.height(3.dp)
                                )

                                Text(
                                    text = "Pengumuman Kalurahan",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme
                                        .onSurfaceVariant
                                )
                            }
                        }

                        Spacer(
                            modifier = Modifier.height(14.dp)
                        )

                        HorizontalDivider(
                            color = MaterialTheme.colorScheme.outlineVariant
                        )

                        Spacer(
                            modifier = Modifier.height(14.dp)
                        )

                        PreviewInfoRow(
                            label = "Prioritas",
                            value = prioritas
                        )

                        PreviewInfoRow(
                            label = "Mulai",
                            value = if (tanggalMulai.isBlank()) {
                                "-"
                            } else {
                                tanggalMulai
                            }
                        )

                        PreviewInfoRow(
                            label = "Selesai",
                            value = if (tanggalSelesai.isBlank()) {
                                "-"
                            } else {
                                tanggalSelesai
                            }
                        )

                        if (isi.isNotBlank()) {

                            Spacer(
                                modifier = Modifier.height(10.dp)
                            )

                            Text(
                                text = isi,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme
                                    .onSurfaceVariant
                            )
                        }
                    }
                }
            }

            // VALIDATION INFO

            if (!formValid) {

                item {

                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        color = MaterialTheme.colorScheme
                            .secondaryContainer
                    ) {

                        Text(
                            text = "Isi judul, isi pengumuman, dan tanggal mulai sebelum mempublikasikan.",
                            modifier = Modifier.padding(14.dp),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme
                                .onSecondaryContainer
                        )
                    }
                }
            }

            // BUTTON

            item {

                Button(
                    onClick = {

                        if (formValid) {

                            Toast.makeText(
                                context,
                                "Pengumuman berhasil dipublikasikan",
                                Toast.LENGTH_SHORT
                            ).show()

                        } else {

                            Toast.makeText(
                                context,
                                "Lengkapi data pengumuman terlebih dahulu",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = formValid,
                    shape = RoundedCornerShape(12.dp)
                ) {

                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null
                    )

                    Spacer(
                        modifier = Modifier.width(8.dp)
                    )

                    Text(
                        text = "Publikasikan Pengumuman",
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            item {

                OutlinedButton(
                    onClick = {

                        Toast.makeText(
                            context,
                            "Pengumuman disimpan sebagai draft",
                            Toast.LENGTH_SHORT
                        ).show()

                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {

                    Text(
                        text = "Simpan Sebagai Draft",
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Composable
private fun SectionTitle(
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
private fun PreviewInfoRow(
    label: String,
    value: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = label,
            modifier = Modifier.width(70.dp),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = ":",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(
            modifier = Modifier.width(8.dp)
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}