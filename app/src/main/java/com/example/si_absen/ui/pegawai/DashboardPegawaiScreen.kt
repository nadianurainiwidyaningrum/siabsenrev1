package com.example.si_absen.ui.pegawai

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CloudDone
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.si_absen.ui.navigation.Screen

@Composable
fun DashboardPegawaiScreen(
    navController: NavController
) {

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,

        bottomBar = {
            PegawaiBottomNavigation(
                navController = navController
            )
        }

    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),

            contentPadding = PaddingValues(
                bottom = 24.dp
            ),

            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // =====================================================
            // HEADER
            // =====================================================

            item {

                PegawaiHeader(
                    name = "Nadia Nuraini",
                    role = "Staff Administrasi",

                    onNotificationClick = {
                        navController.navigate(
                            Screen.Notifikasi.route
                        )
                    },

                    onProfileClick = {
                        navController.navigate(
                            Screen.Profil.route
                        )
                    }
                )
            }

            // =====================================================
            // PENGINGAT / STATUS ABSENSI
            // =====================================================

            item {

                SectionTitle(
                    title = "Absensi Hari Ini",
                    description = "Pantau status kehadiranmu hari ini."
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                AttendanceReminderCard(
                    onAbsenMasuk = {
                        navController.navigate(
                            Screen.AbsenMasuk.route
                        )
                    },

                    onAbsenPulang = {
                        navController.navigate(
                            Screen.AbsenPulang.route
                        )
                    },

                    onAbsenKegiatan = {
                        navController.navigate(
                            Screen.AbsenKegiatan.route
                        )
                    }
                )
            }

            // =====================================================
            // PENGINGAT JADWAL
            // =====================================================

            item {

                SectionTitle(
                    title = "Jadwal Hari Ini",
                    description = "Informasi jadwal kerja kamu."
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                ScheduleReminderCard(
                    onClick = {
                        navController.navigate(
                            Screen.JadwalKerja.route
                        )
                    }
                )
            }

            // =====================================================
            // RINGKASAN KEHADIRAN
            // =====================================================

            item {

                SectionTitle(
                    title = "Ringkasan Kehadiran",
                    description = "Rekap kehadiran bulan ini."
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                AttendanceSummaryCard(
                    onClick = {
                        navController.navigate(
                            Screen.RekapKehadiran.route
                        )
                    }
                )
            }

            // =====================================================
            // STATUS SISTEM
            // =====================================================

            item {

                SystemStatusCard(
                    onLocationClick = {
                        navController.navigate(
                            Screen.LokasiAbsensi.route
                        )
                    }
                )
            }

            // =====================================================
            // FOOTER
            // =====================================================

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 20.dp,
                            vertical = 4.dp
                        ),

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "SI ABSEN",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )

                    Text(
                        text = "Kalurahan Purwobinangun",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}


// =============================================================
// HEADER
// =============================================================

@Composable
private fun PegawaiHeader(
    name: String,
    role: String,
    onNotificationClick: () -> Unit,
    onProfileClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    bottomStart = 28.dp,
                    bottomEnd = 28.dp
                )
            )
            .background(
                MaterialTheme.colorScheme.primary
            )
            .padding(
                horizontal = 20.dp,
                vertical = 22.dp
            )
    ) {

        Column {

            // -----------------------------------------------------
            // TOP BAR
            // -----------------------------------------------------

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "SI ABSEN",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                    Text(
                        text = "Kalurahan Purwobinangun",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onPrimary.copy(
                            alpha = 0.75f
                        )
                    )
                }

                // NOTIFIKASI

                HeaderIconButton(
                    icon = Icons.Default.Notifications,
                    contentDescription = "Notifikasi",
                    onClick = onNotificationClick
                )

                Spacer(
                    modifier = Modifier.size(8.dp)
                )

                // PROFILE

                HeaderProfileButton(
                    onClick = onProfileClick
                )
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            // -----------------------------------------------------
            // GREETING
            // -----------------------------------------------------

            Text(
                text = "Selamat datang 👋",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary.copy(
                    alpha = 0.82f
                )
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Text(
                text = name,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = role,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary.copy(
                    alpha = 0.78f
                )
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Text(
                text = "Kamis, 8 Oktober 2026",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onPrimary.copy(
                    alpha = 0.65f
                )
            )
        }
    }
}


// =============================================================
// HEADER ICON
// =============================================================

@Composable
private fun HeaderIconButton(
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .size(42.dp)
            .clip(CircleShape)
            .background(
                MaterialTheme.colorScheme.onPrimary.copy(
                    alpha = 0.13f
                )
            )
            .clickable {
                onClick()
            },

        contentAlignment = Alignment.Center
    ) {

        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.size(21.dp)
        )
    }
}


// =============================================================
// PROFILE BUTTON
// =============================================================

@Composable
private fun HeaderProfileButton(
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .size(42.dp)
            .clip(CircleShape)
            .background(
                MaterialTheme.colorScheme.onPrimary.copy(
                    alpha = 0.13f
                )
            )
            .clickable {
                onClick()
            },

        contentAlignment = Alignment.Center
    ) {

        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Profil",
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.size(21.dp)
        )
    }
}


// =============================================================
// SECTION TITLE
// =============================================================

@Composable
private fun SectionTitle(
    title: String,
    description: String
) {

    Column(
        modifier = Modifier.padding(
            horizontal = 16.dp
        )
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(2.dp)
        )

        Text(
            text = description,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}


// =============================================================
// ATTENDANCE REMINDER
// =============================================================

@Composable
private fun AttendanceReminderCard(
    onAbsenMasuk: () -> Unit,
    onAbsenPulang: () -> Unit,
    onAbsenKegiatan: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            // -----------------------------------------------------
            // STATUS UTAMA
            // -----------------------------------------------------

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(
                            MaterialTheme.colorScheme.primaryContainer
                        ),

                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(25.dp)
                    )
                }

                Spacer(
                    modifier = Modifier.size(12.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Status Kehadiran",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )

                    Text(
                        text = "Sudah Absen Masuk",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }

                StatusBadge(
                    text = "Hadir",
                    color = Color(0xFF2E7D32),
                    background = Color(0xFFE8F5E9)
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // -----------------------------------------------------
            // 3 ABSENSI
            // -----------------------------------------------------

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                AttendanceTypeCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.Badge,
                    title = "Masuk",
                    value = "07:28",
                    completed = true,
                    onClick = onAbsenMasuk
                )

                AttendanceTypeCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.Schedule,
                    title = "Pulang",
                    value = "Belum",
                    completed = false,
                    onClick = onAbsenPulang
                )

                AttendanceTypeCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.Event,
                    title = "Kegiatan",
                    value = "Absen",
                    completed = false,
                    onClick = onAbsenKegiatan
                )
            }

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            // -----------------------------------------------------
            // LOCATION STATUS
            // -----------------------------------------------------

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(12.dp)
                    )
                    .background(
                        MaterialTheme.colorScheme.surfaceVariant
                    )
                    .padding(11.dp),

                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(18.dp)
                )

                Spacer(
                    modifier = Modifier.size(8.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Lokasi absensi",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        text = "Dalam radius Kalurahan Purwobinangun",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Text(
                    text = "Valid",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2E7D32)
                )
            }
        }
    }
}


// =============================================================
// ATTENDANCE TYPE CARD
// =============================================================

@Composable
private fun AttendanceTypeCard(
    modifier: Modifier,
    icon: ImageVector,
    title: String,
    value: String,
    completed: Boolean,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .height(104.dp)
            .clickable {
                onClick()
            },

        shape = RoundedCornerShape(14.dp),

        colors = CardDefaults.cardColors(
            containerColor =
            if (completed) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.surfaceVariant
            }
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(9.dp),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint =
                if (completed) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                },

                modifier = Modifier.size(21.dp)
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Text(
                text = title,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = value,
                style = MaterialTheme.typography.labelSmall,
                color =
                if (completed) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                }
            )
        }
    }
}


// =============================================================
// STATUS BADGE
// =============================================================

@Composable
private fun StatusBadge(
    text: String,
    color: Color,
    background: Color
) {

    Surface(
        shape = RoundedCornerShape(50.dp),
        color = background
    ) {

        Text(
            text = text,
            modifier = Modifier.padding(
                horizontal = 10.dp,
                vertical = 6.dp
            ),

            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            color = color
        )
    }
}


// =============================================================
// SCHEDULE REMINDER
// =============================================================

@Composable
private fun ScheduleReminderCard(
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable {
                onClick()
            },

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {

        Column(
            modifier = Modifier.padding(17.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(RoundedCornerShape(13.dp))
                        .background(
                            Color.White.copy(
                                alpha = 0.14f
                            )
                        ),

                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.Schedule,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(23.dp)
                    )
                }

                Spacer(
                    modifier = Modifier.size(11.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Jadwal Kerja Hari Ini",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.White.copy(
                            alpha = 0.82f
                        )
                    )

                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )

                    Text(
                        text = "07:30 — 16:00",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.Event,
                    contentDescription = null,
                    tint = Color.White.copy(
                        alpha = 0.85f
                    ),
                    modifier = Modifier.size(17.dp)
                )

                Spacer(
                    modifier = Modifier.size(7.dp)
                )

                Text(
                    text = "Kamu sedang dalam jam kerja",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(
                        alpha = 0.85f
                    ),

                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "Detail →",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}


// =============================================================
// ATTENDANCE SUMMARY
// =============================================================

@Composable
private fun AttendanceSummaryCard(
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Bulan Oktober",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Ringkasan kehadiran",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Text(
                    text = "Lihat rekap →",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(
                modifier = Modifier.height(14.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                SummaryItem(
                    modifier = Modifier.weight(1f),
                    title = "Hadir",
                    value = "22",
                    icon = Icons.Default.CheckCircle
                )

                SummaryItem(
                    modifier = Modifier.weight(1f),
                    title = "Terlambat",
                    value = "2",
                    icon = Icons.Default.Schedule
                )

                SummaryItem(
                    modifier = Modifier.weight(1f),
                    title = "Izin",
                    value = "1",
                    icon = Icons.Default.Event
                )

                SummaryItem(
                    modifier = Modifier.weight(1f),
                    title = "Sakit",
                    value = "0",
                    icon = Icons.Default.Info
                )
            }
        }
    }
}


// =============================================================
// SUMMARY ITEM
// =============================================================

@Composable
private fun SummaryItem(
    modifier: Modifier,
    title: String,
    value: String,
    icon: ImageVector
) {

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(13.dp),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {

        Column(
            modifier = Modifier.padding(
                vertical = 11.dp,
                horizontal = 5.dp
            ),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(19.dp)
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = title,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}


// =============================================================
// SYSTEM STATUS
// =============================================================

@Composable
private fun SystemStatusCard(
    onLocationClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Status Sistem",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            SystemStatusRow(
                icon = Icons.Default.LocationOn,
                title = "Lokasi",
                description = "GPS aktif dan lokasi terdeteksi",
                status = "Aktif",
                statusColor = Color(0xFF2E7D32),
                onClick = onLocationClick
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            SystemStatusRow(
                icon = Icons.Default.CloudDone,
                title = "Sinkronisasi",
                description = "Data absensi tersimpan ke server",
                status = "Online",
                statusColor = Color(0xFF2E7D32),
                onClick = {}
            )
        }
    }
}


// =============================================================
// SYSTEM STATUS ROW
// =============================================================

@Composable
private fun SystemStatusRow(
    icon: ImageVector,
    title: String,
    description: String,
    status: String,
    statusColor: Color,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },

        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(11.dp))
                .background(
                    MaterialTheme.colorScheme.primaryContainer
                ),

            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(
            modifier = Modifier.size(10.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = description,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Text(
            text = status,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            color = statusColor
        )
    }
}


// =============================================================
// BOTTOM NAVIGATION
// =============================================================

@Composable
private fun PegawaiBottomNavigation(
    navController: NavController
) {

    NavigationBar(
        modifier = Modifier.navigationBarsPadding()
    ) {

        // HOME

        NavigationBarItem(
            selected = true,

            onClick = {
                // sudah di dashboard
            },

            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Beranda"
                )
            },

            label = {
                Text("Beranda")
            }
        )


        // RIWAYAT

        NavigationBarItem(
            selected = false,

            onClick = {
                navController.navigate(
                    Screen.RiwayatAbsensi.route
                )
            },

            icon = {
                Icon(
                    imageVector = Icons.Default.Assessment,
                    contentDescription = "Riwayat"
                )
            },

            label = {
                Text("Riwayat")
            }
        )


        // NOTIFIKASI

        NavigationBarItem(
            selected = false,

            onClick = {
                navController.navigate(
                    Screen.Notifikasi.route
                )
            },

            icon = {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifikasi"
                )
            },

            label = {
                Text("Notifikasi")
            }
        )


        // LAINNYA

        NavigationBarItem(
            selected = false,

            onClick = {
                navController.navigate(
                    Screen.PengaturanAkun.route
                )
            },

            icon = {
                Icon(
                    imageVector = Icons.Default.MoreHoriz,
                    contentDescription = "Lainnya"
                )
            },

            label = {
                Text("Lainnya")
            }
        )
    }
}