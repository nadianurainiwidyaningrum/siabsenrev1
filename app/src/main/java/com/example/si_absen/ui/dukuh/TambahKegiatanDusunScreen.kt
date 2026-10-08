package com.example.si_absen.ui.dukuh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TambahKegiatanDusunScreen(
    navController: NavController
) {

    var namaKegiatan by remember {
        mutableStateOf("")
    }

    var tanggal by remember {
        mutableStateOf("14 September 2026")
    }

    var deskripsi by remember {
        mutableStateOf("")
    }

    val colorScheme = MaterialTheme.colorScheme

    val formValid =
        namaKegiatan.isNotBlank() &&
                tanggal.isNotBlank() &&
                deskripsi.isNotBlank()

    Scaffold(
        containerColor = colorScheme.background,

        topBar = {
            TopAppBar(
                title = {
                    Column {

                        Text(
                            text = "Tambah Kegiatan",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Ajukan kegiatan wilayah dusun",
                            style = MaterialTheme.typography.bodySmall,
                            color = colorScheme.onSurfaceVariant
                        )
                    }
                }
            )
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
                .padding(bottom = 24.dp)
        ) {

            Spacer(
                modifier = Modifier.height(8.dp)
            )
             // HEADER

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = colorScheme.primary
                )
            ) {

                Row(
                    modifier = Modifier.padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Surface(
                        modifier = Modifier.size(52.dp),
                        shape = RoundedCornerShape(15.dp),
                        color = colorScheme.onPrimary.copy(alpha = 0.15f)
                    ) {

                        Box(
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = Icons.Default.Event,
                                contentDescription = null,
                                modifier = Modifier.size(28.dp),
                                tint = colorScheme.onPrimary
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
                            text = "Pengajuan Kegiatan",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = colorScheme.onPrimary
                        )

                        Spacer(
                            modifier = Modifier.height(3.dp)
                        )

                        Text(
                            text = "Lengkapi informasi kegiatan yang akan dilaksanakan.",
                            style = MaterialTheme.typography.bodySmall,
                            color = colorScheme.onPrimary.copy(
                                alpha = 0.85f
                            )
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(22.dp)
            )

            // INFORMASI KEGIATAN

            FormSectionTitle(
                title = "Informasi Kegiatan",
                icon = Icons.Default.Description
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            OutlinedTextField(
                value = namaKegiatan,
                onValueChange = {
                    namaKegiatan = it
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(14.dp),
                label = {
                    Text("Nama Kegiatan")
                },
                placeholder = {
                    Text("Contoh: Kerja Bakti Dusun")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Event,
                        contentDescription = null
                    )
                }
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            OutlinedTextField(
                value = tanggal,
                onValueChange = {
                    tanggal = it
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(14.dp),
                label = {
                    Text("Tanggal Kegiatan")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.CalendarMonth,
                        contentDescription = null
                    )
                }
            )

            Spacer(
                modifier = Modifier.height(22.dp)
            )
            // DOKUMENTASI

            FormSectionTitle(
                title = "Dokumentasi",
                icon = Icons.Default.CameraAlt
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

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(170.dp)
                            .background(
                                color = colorScheme.surfaceVariant,
                                shape = RoundedCornerShape(14.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Surface(
                                modifier = Modifier.size(52.dp),
                                shape = RoundedCornerShape(14.dp),
                                color = colorScheme.primaryContainer
                            ) {

                                Box(
                                    contentAlignment = Alignment.Center
                                ) {

                                    Icon(
                                        imageVector = Icons.Default.CameraAlt,
                                        contentDescription = null,
                                        modifier = Modifier.size(27.dp),
                                        tint = colorScheme.onPrimaryContainer
                                    )
                                }
                            }

                            Spacer(
                                modifier = Modifier.height(10.dp)
                            )

                            Text(
                                text = "Belum Ada Foto",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = colorScheme.onSurface
                            )

                            Spacer(
                                modifier = Modifier.height(3.dp)
                            )

                            Text(
                                text = "Tambahkan dokumentasi kegiatan",
                                style = MaterialTheme.typography.bodySmall,
                                color = colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    OutlinedButton(
                        onClick = {
                            // TODO: buka kamera
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    ) {

                        Icon(
                            imageVector = Icons.Default.CameraAlt,
                            contentDescription = null,
                            modifier = Modifier.size(19.dp)
                        )

                        Spacer(
                            modifier = Modifier.width(8.dp)
                        )

                        Text(
                            text = "Ambil Foto",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(22.dp)
            )
          // LOKASI

            FormSectionTitle(
                title = "Lokasi Kegiatan",
                icon = Icons.Default.LocationOn
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

                    Row(
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
                                    imageVector = Icons.Default.LocationOn,
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
                                text = "Dusun Klepu",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = colorScheme.onSurface
                            )

                            Spacer(
                                modifier = Modifier.height(2.dp)
                            )

                            Text(
                                text = "Lokasi kegiatan terdeteksi",
                                style = MaterialTheme.typography.bodySmall,
                                color = colorScheme.onSurfaceVariant
                            )
                        }

                        Surface(
                            shape = RoundedCornerShape(50.dp),
                            color = colorScheme.primaryContainer
                        ) {

                            Row(
                                modifier = Modifier.padding(
                                    horizontal = 9.dp,
                                    vertical = 6.dp
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    modifier = Modifier.size(14.dp),
                                    tint = colorScheme.onPrimaryContainer
                                )

                                Spacer(
                                    modifier = Modifier.width(4.dp)
                                )

                                Text(
                                    text = "Valid",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.SemiBold,
                                    color = colorScheme.onPrimaryContainer
                                )
                            }
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    HorizontalDivider(
                        color = colorScheme.outlineVariant
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    LocationDataRow(
                        label = "Latitude",
                        value = "-7.7612"
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    LocationDataRow(
                        label = "Longitude",
                        value = "110.3678"
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    LocationDataRow(
                        label = "Jarak",
                        value = "42 Meter"
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(22.dp)
            )
            // DESKRIPSI

            FormSectionTitle(
                title = "Deskripsi Kegiatan",
                icon = Icons.Default.Description
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            OutlinedTextField(
                value = deskripsi,
                onValueChange = {
                    deskripsi = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 140.dp),
                shape = RoundedCornerShape(14.dp),
                minLines = 5,
                label = {
                    Text("Deskripsi")
                },
                placeholder = {
                    Text(
                        "Jelaskan tujuan, kegiatan, atau informasi tambahan..."
                    )
                }
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )
               // SIMPAN

            Button(
                onClick = {
                    // TODO:
                    // simpan kegiatan ke database
                    // status awal = Menunggu
                    navController.popBackStack()
                },
                enabled = formValid,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorScheme.primary,
                    contentColor = colorScheme.onPrimary
                )
            ) {

                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Text(
                    text = "Simpan Kegiatan",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Setelah disimpan, kegiatan akan masuk ke proses validasi admin.",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodySmall,
                color = colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun FormSectionTitle(
    title: String,
    icon: ImageVector
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(
            modifier = Modifier.width(8.dp)
        )

        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
private fun LocationDataRow(
    label: String,
    value: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}