/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugaspert13;

/**
 *
 * @author RAISSA
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                // Load driver PostgreSQL
                Class.forName("org.postgresql.Driver");

                String url  = "jdbc:postgresql://localhost:5432/pbo_pert13";
                String user = "postgres";     // username PostgreSQL
                String pass = "ABCDE12345";   // password PostgreSQL

                conn = DriverManager.getConnection(url, user, pass);
                System.out.println("Koneksi berhasil!");

            } catch (ClassNotFoundException e) {
                System.out.println("Driver tidak ditemukan: " + e.getMessage());

            } catch (SQLException e) {
                System.out.println("Koneksi gagal: " + e.getMessage());
            }
        }

        return conn;
    }
}
