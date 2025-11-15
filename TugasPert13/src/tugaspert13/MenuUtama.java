/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugaspert13;
import javax.swing.*;

public class MenuUtama extends JFrame {

    public MenuUtama() {  // Constructor
        setTitle("Menu Utama");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Selamat datang di Menu Utama!", SwingConstants.CENTER);
        add(label);
    }
    
    public static void main(String[] args) {
        // Untuk testing langsung
        SwingUtilities.invokeLater(() -> {
            new MenuUtama().setVisible(true);
        });
    }
}