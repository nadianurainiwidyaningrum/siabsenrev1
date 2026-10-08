package com.example.si_absen.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

import com.example.si_absen.ui.admin.*
import com.example.si_absen.ui.auth.*
import com.example.si_absen.ui.dukuh.*
import com.example.si_absen.ui.pegawai.*
import com.example.si_absen.ui.screen.admin.DashboardAdminScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        modifier = modifier
    ) {

        // AUTH

        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }

        composable(Screen.Login.route) {
            LoginScreen(navController)
        }

        composable(Screen.Register.route) {
            RegisterScreen(navController)
        }

        composable(Screen.ForgotPassword.route) {
            ForgotPasswordScreen(navController)
        }

        composable(
            route = Screen.VerifikasiOtp.route,
            arguments = listOf(
                navArgument("nik") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val nik = backStackEntry.arguments?.getString("nik") ?: ""

            VerifikasiOtpScreen(
                navController = navController,
                nik = nik
            )
        }

        composable(
            route = Screen.UbahPassword.route,
            arguments = listOf(
                navArgument("nik") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val nik = backStackEntry.arguments?.getString("nik") ?: ""

            UbahPasswordScreen(
                navController = navController,
                nik = nik
            )
        }

        // ADMIN

        composable(Screen.DashboardAdmin.route) {
            DashboardAdminScreen(navController)
        }

        composable(Screen.DataPegawai.route) {
            DataPegawaiScreen(navController)
        }

        composable(Screen.DetailPegawai.route) {
            DetailPegawaiScreen(navController)
        }

        composable(Screen.DataDukuh.route) {
            DataDukuhScreen(navController)
        }

        composable(
            route = Screen.DetailDukuh.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val id = backStackEntry.arguments?.getInt("id") ?: 1

            DetailDukuhScreen(
                navController = navController,
                id = id
            )
        }

        composable(Screen.MonitoringAbsensi.route) {
            MonitoringAbsensiScreen()
        }

        composable(Screen.MonitoringLokasi.route) {
            MonitoringLokasiScreen()
        }

        composable(Screen.ValidasiAbsensi.route) {
            ValidasiAbsensiScreen()
        }

        composable(Screen.Statistik.route) {
            StatistikScreen()
        }

        composable(Screen.Laporan.route) {
            LaporanScreen(navController)
        }

        composable(Screen.PengumumanAdmin.route) {
            PengumumanAdminScreen(navController)
        }

        composable(Screen.TambahPengumuman.route) {
            TambahPengumumanScreen()
        }

        composable(Screen.ProfilAdmin.route) {
            ProfilAdminScreen()
        }

        composable(Screen.PengaturanAdmin.route) {
            PengaturanAdminScreen(navController)
        }

        composable(Screen.PengaturanSistem.route) {
            PengaturanSistemScreen()
        }

        composable(Screen.ManajemenRole.route) {
            ManajemenRoleScreen()
        }

        composable(Screen.LogAktivitas.route) {
            LogAktivitasScreen()
        }

        // DUKUH

        composable(Screen.DashboardDukuh.route) {
            DashboardDukuhScreen(navController)
        }

        composable(Screen.AbsenMasukDukuh.route) {
            AbsenMasukDukuhScreen()
        }

        composable(Screen.AbsenPulangDukuh.route) {
            AbsenPulangDukuhScreen()
        }

        composable(Screen.KegiatanDusun.route) {
            KegiatanDusunScreen(navController)
        }

        composable(Screen.TambahKegiatanDusun.route) {
            TambahKegiatanDusunScreen(navController)
        }

        composable(Screen.DetailKegiatanDusun.route) {
            DetailKegiatanDusunScreen()
        }

        composable(Screen.RiwayatKegiatanDusun.route) {
            RiwayatKegiatanDusunScreen()
        }

        composable(Screen.MonitoringWilayah.route) {
            MonitoringWilayahScreen()
        }

        composable(Screen.RekapDusun.route) {
            RekapDusunScreen()
        }

        composable(Screen.NotifikasiDukuh.route) {
            NotifikasiDukuhScreen()
        }

        composable(Screen.ProfilDukuh.route) {
            ProfilDukuhScreen()
        }

        composable(Screen.PengaturanAkunDukuh.route) {
            PengaturanAkunDukuhScreen()
        }

        composable(Screen.PanduanDukuh.route) {
            PanduanDukuhScreen()
        }

        composable(Screen.TentangDukuh.route) {
            TentangDukuhScreen()
        }

        // PEGAWAI

        composable(Screen.DashboardPegawai.route) {
            DashboardPegawaiScreen(navController)
        }

        composable(Screen.AbsenMasuk.route) {
            AbsenMasukScreen()
        }

        composable(Screen.AbsenPulang.route) {
            AbsenPulangScreen()
        }

        composable(Screen.LokasiAbsensi.route) {
            LokasiAbsensiScreen()
        }

        composable(Screen.AbsenKegiatan.route) {
            AbsenKegiatanScreen()
        }

        composable(Screen.DetailKegiatan.route) {
            DetailKegiatanScreen()
        }

        composable(Screen.RiwayatKegiatan.route) {
            RiwayatKegiatanScreen(navController)
        }

        composable(Screen.RiwayatAbsensi.route) {
            RiwayatAbsensiScreen(navController)
        }

        composable(Screen.DetailAbsensi.route) {
            DetailAbsensiScreen()
        }

        composable(Screen.RekapKehadiran.route) {
            RekapKehadiranScreen()
        }

        composable(Screen.JadwalKerja.route) {
            JadwalKerjaScreen()
        }

        composable(Screen.Notifikasi.route) {
            NotifikasiScreen()
        }

        composable(Screen.Profil.route) {
            ProfilScreen(navController)
        }

        composable(Screen.EditProfil.route) {
            EditProfilScreen()
        }

        composable(Screen.PengaturanAkun.route) {
            PengaturanAkunScreen()
        }

        composable(Screen.Panduan.route) {
            PanduanScreen()
        }

        composable(Screen.Tentang.route) {
            TentangScreen()
        }
    }
}