package com.example.si_absen.ui.navigation

sealed class Screen(val route: String) {

    // =====================================================
    // AUTH
    // =====================================================

    object Splash : Screen("splash")

    object Login : Screen("login")

    object Register : Screen("register")

    object ForgotPassword : Screen("forgot_password")

    // VERIFIKASI OTP
    object VerifikasiOtp : Screen("verifikasi_otp/{nik}") {

        fun createRoute(nik: String): String {
            return "verifikasi_otp/$nik"
        }
    }

    // UBAH PASSWORD
    object UbahPassword : Screen("ubah_password/{nik}") {

        fun createRoute(nik: String): String {
            return "ubah_password/$nik"
        }
    }


    // =====================================================
    // ADMIN
    // =====================================================

    object DashboardAdmin : Screen("dashboard_admin")

    object DataPegawai : Screen("data_pegawai")

    object DetailPegawai : Screen("detail_pegawai")

    object DataDukuh : Screen("data_dukuh")

    object DetailDukuh : Screen("detail_dukuh/{id}") {
        fun createRoute(id: Int): String {
            return "detail_dukuh/$id"
        }
    }

    object MonitoringAbsensi : Screen("monitoring_absensi")

    object MonitoringLokasi : Screen("monitoring_lokasi")

    object ValidasiAbsensi : Screen("validasi_absensi")

    object Statistik : Screen("statistik")

    object Laporan : Screen("laporan")

    object PengumumanAdmin : Screen("pengumuman_admin")

    object TambahPengumuman : Screen("tambah_pengumuman")

    object ProfilAdmin : Screen("profil_admin")

    object PengaturanAdmin : Screen("pengaturan_admin")

    object PengaturanSistem : Screen("pengaturan_sistem")

    object ManajemenRole : Screen("manajemen_role")

    object LogAktivitas : Screen("log_aktivitas")


    // =====================================================
    // DUKUH
    // =====================================================

    object DashboardDukuh : Screen("dashboard_dukuh")

    object AbsenMasukDukuh : Screen("absen_masuk_dukuh")

    object AbsenPulangDukuh : Screen("absen_pulang_dukuh")

    object KegiatanDusun : Screen("kegiatan_dusun")

    object TambahKegiatanDusun : Screen("tambah_kegiatan_dusun")

    object DetailKegiatanDusun : Screen("detail_kegiatan_dusun")

    object RiwayatKegiatanDusun : Screen("riwayat_kegiatan_dusun")

    object MonitoringWilayah : Screen("monitoring_wilayah")

    object RekapDusun : Screen("rekap_dusun")

    object NotifikasiDukuh : Screen("notifikasi_dukuh")

    object ProfilDukuh : Screen("profil_dukuh")

    object PengaturanAkunDukuh : Screen("pengaturan_akun_dukuh")

    object PanduanDukuh : Screen("panduan_dukuh")

    object TentangDukuh : Screen("tentang_dukuh")


    // =====================================================
    // PEGAWAI
    // =====================================================

    object DashboardPegawai : Screen("dashboard_pegawai")

    object AbsenMasuk : Screen("absen_masuk")

    object AbsenPulang : Screen("absen_pulang")

    object LokasiAbsensi : Screen("lokasi_absensi")

    object AbsenKegiatan : Screen("absen_kegiatan")

    object DetailKegiatan : Screen("detail_kegiatan")

    object RiwayatKegiatan : Screen("riwayat_kegiatan")

    object RiwayatAbsensi : Screen("riwayat_absensi")

    object DetailAbsensi : Screen("detail_absensi")

    object RekapKehadiran : Screen("rekap_kehadiran")

    object JadwalKerja : Screen("jadwal_kerja")

    object Notifikasi : Screen("notifikasi")

    object Profil : Screen("profil")

    object EditProfil : Screen("edit_profil")

    object PengaturanAkun : Screen("pengaturan_akun")

    object Panduan : Screen("panduan")

    object Tentang : Screen("tentang")
}