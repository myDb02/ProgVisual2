/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database_Sales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author al190
 */
public class Koneksi {
    private Connection koneksi;

    public Connection getKoneksi() {
        try {
            // Loading driver secara otomatis tidak diperlukan pada versi JDBC terkini
            // Class.forName("com.mysql.jdbc.Driver");

            // Menggunakan driver yang benar sesuai dengan peringatan yang diberikan
            koneksi = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_sales", "root", "root");

            if (koneksi != null) {
                System.out.println("Koneksi Berhasil");
            }
        } catch (SQLException ex) {
            System.out.println("Gagal Terkoneksi YA");
            ex.printStackTrace(); // Tambahkan ini untuk melihat detail kesalahan
        }
        return koneksi;
    }

    public static void main(String[] args) {
        Koneksi conn = new Koneksi();
        Connection koneksi = conn.getKoneksi();
    }
}
