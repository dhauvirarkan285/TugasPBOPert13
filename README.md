# LAPORAN TUGAS KULIAH PEMROGRAMAN BERORIENTASI OBJEK PERTEMUAN KEDUABELAS

Disusun guna memenuhi tugas mata kuliah **Pemrograman Berorientasi Objek**

---

## Dosen Pembimbing
Bayu Adhi Nugroho, Ph.D

## Disusun Oleh
Muhamad Dhauvir Arkan (09020624044)

**PROGRAM STUDI SISTEM INFORMASI**  
FAKULTAS SAINS DAN TEKNOLOGI  
UNIVERSITAS ISLAM NEGERI SUNAN AMPEL  
SURABAYA  
TAHUN 2025

---

## Bab 1 – Tujuan Praktikum

1. **Mengenal Entity Class pada JPA (Java Persistence API)**  
   - Mahasiswa mampu membuat entity class (`AkunOrang`) yang merepresentasikan tabel di database PostgreSQL.

2. **Membuat CRUD Sederhana di Java Swing dengan Database**  
   - Mahasiswa dapat membuat form **Login**, **Daftar**, dan **Reset** untuk mengelola data akun pengguna.  
   - Memahami koneksi ke PostgreSQL menggunakan JDBC (`Koneksi.java`).

3. **Memahami Mekanisme Validasi dan Notifikasi di GUI**  
   - Mengimplementasikan validasi input (misal: username/password kosong, password konfirmasi tidak cocok).  
   - Memberikan feedback pengguna berupa pesan pop-up (`JOptionPane`) seperti: `"Selamat Datang! Semoga dapat menikmati"`

4. **Mengintegrasikan Entity Class dengan GUI**  
   - Entity `AkunOrang` digunakan sebagai model data untuk menyimpan dan mengambil informasi pengguna.

---

## Bab 2 – Dasar Teori

### 1. Entity Class (`AkunOrang`)
- Representasi objek Java dari tabel `akun_orang` di database.
- Anotasi JPA yang digunakan:
java
@Entity
@Table(name = "akun_orang")
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "username")
- Memudahkan operasi CRUD melalui JPA atau langsung via JDBC.
### 2. Java Swing GUI
- JFrame digunakan untuk membuat form Login, Daftar, dan Reset.
- Komponen seperti JTextField, JButton, JLabel digunakan untuk interaksi pengguna.
- JOptionPane menampilkan notifikasi berupa pop-up.

### 3. JDBC (Java Database Connectivity)
- Menghubungkan aplikasi Java dengan PostgreSQL (Koneksi.java).
- Contoh query menambahkan akun baru:
PreparedStatement ps = conn.prepareStatement(
    "INSERT INTO akun_orang(username, password) VALUES (?, ?)"
);
- Memungkinkan manipulasi data: INSERT, UPDATE, SELECT.
### 4. Validasi Input dan Keamanan Dasar
- Pastikan username dan password tidak kosong.
- Validasi password konfirmasi saat reset.
- Memberikan pesan sesuai kondisi sukses atau gagal.
### 5. Navigasi Antar Form
- Login → berhasil login → MenuUtama muncul.
- Daftar → submit akun baru → kembali ke Login.
- Reset → password berhasil diubah → kembali ke Login.
### 6. Konsep MVC Sederhana
- AkunOrang → Model
- Daftar, Login, Reset, MenuUtama → View
- PreparedStatement & Koneksi → Controller

## Bab 3 – Pelaksanaan Praktikum
### 1. Membuat Java Application
- Buat project baru di NetBeans: TugasPert13.
<img width="722" height="512" alt="Screenshot 2025-11-16 012007" src="https://github.com/user-attachments/assets/cd211195-ab98-4cf4-b368-4b5b8709539e" />
### 2. Membuat Database PostgreSQL
- Buat database baru: pbo_pert13.
- Buat tabel akun_orang:
CREATE TABLE akun_orang (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    nama_lengkap VARCHAR(100)
);
<img width="595" height="201" alt="Screenshot 2025-11-16 012546" src="https://github.com/user-attachments/assets/8f1cbe9d-7466-4dc3-b3c3-facc13a02916" />

### 3. Membuat Entity Database
- Buat AkunOrang.java sesuai struktur tabel.
- Sesuaikan koneksi database.
<img width="717" height="525" alt="Screenshot 2025-11-16 014916" src="https://github.com/user-attachments/assets/5d866a6b-e9fc-45d3-8e7c-1084f5128ba4" />

### 4. Membuat JFrame
- Buat form Login, Daftar, Reset.
- Tambahkan method untuk menjalankan masing-masing JFrame.
  <img width="673" height="740" alt="Screenshot 2025-11-16 014236" src="https://github.com/user-attachments/assets/febc5406-64c6-4190-b69c-73f2ef024f74" />
<img width="706" height="662" alt="Screenshot 2025-11-16 014149" src="https://github.com/user-attachments/assets/1a921296-bc7e-4d58-8db0-d91d95adb16f" />
<img width="1488" height="837" alt="Screenshot 2025-11-16 014002" src="https://github.com/user-attachments/assets/f151eb89-e9ba-42b7-8a64-756db04ab2a0" />

### 5. Membuat Java Class Koneksi
- File Koneksi.java untuk menghubungkan PostgreSQL:
String url = "jdbc:postgresql://localhost:5432/pbo_pert13";
String user = "postgres";
String pass = "ABCDE12345";
<img width="671" height="773" alt="Screenshot 2025-11-16 014803" src="https://github.com/user-attachments/assets/d6d6d945-4ea2-4bd6-a4a0-6e3f9ec75d56" />

- Sesuaikan username & password PostgreSQL masing-masing pengguna.

### 6. Pengujian Program
- Jalankan Login, Daftar, Reset untuk memastikan aplikasi bekerja:
- Login: Masukkan username & password → klik tombol Login.
<img width="503" height="327" alt="Screenshot 2025-11-16 021457" src="https://github.com/user-attachments/assets/ec53f310-8239-4a53-9ef7-f09c0789c838" />

- Daftar: Isi username & password baru → klik Submit → akun tersimpan di DB.
<img width="395" height="217" alt="Screenshot 2025-11-16 021414" src="https://github.com/user-attachments/assets/a10bdb83-4758-4ce2-ac3b-b0684262cec2" />

- Reset: Masukkan password baru & konfirmasi → klik Reset → password diperbarui.
<img width="393" height="220" alt="Screenshot 2025-11-16 021601" src="https://github.com/user-attachments/assets/b43e0d03-d22f-4411-a95d-637801bdbc7d" />

