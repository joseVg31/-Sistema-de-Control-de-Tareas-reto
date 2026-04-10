package org.example.sistemadecontroldetareas;

import org.example.sistemadecontroldetareas.controller.TareaController;
import org.example.sistemadecontroldetareas.view.VentanaPrincipal;
import javax.swing.*;

/**
 * Main: punto de entrada de la aplicación.
 * Solo crea la vista y el controlador.
 */
public class Main {

    public static void main(String[] args) {

        // Aplicar Look & Feel del sistema operativo
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Lanzar la UI en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal vista = new VentanaPrincipal();
            new TareaController(vista);
        });
    }
}