/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentinformationsystem;

/**
 *
 * @author adc
 */
import GUI.dashboard; // Import your dashboard class

public class StudentInformationSystem {

    public static void main(String[] args) {
        try {
            // This makes buttons look modern and handle colors properly
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) { // Nimbus handles colors better than default
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            new dashboard().setVisible(true);
        });
    }
}