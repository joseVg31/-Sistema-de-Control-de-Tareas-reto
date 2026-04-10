package org.example.sistemadecontroldetareas.controller;

import org.example.sistemadecontroldetareas.model.Tarea;
import org.example.sistemadecontroldetareas.view.VentanaPrincipal;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador: conecta la vista con el modelo.
 * Registra los listeners y contiene toda la lógica.
 */
public class TareaController {

    private final VentanaPrincipal vista;
    private final List<Tarea> tareas = new ArrayList<>();

    public TareaController(VentanaPrincipal vista) {
        this.vista = vista;
        initEventos();
        vista.setVisible(true);
    }

    private void initEventos() {

        // ── Agregar tarea ──────────────────────────────
        vista.getBtnAgregar().addActionListener(e -> {
            String texto = vista.getTxtTarea().getText().trim();

            if (texto.isEmpty()) {
                JOptionPane.showMessageDialog(vista,
                        "Ingresa un nombre para la tarea.",
                        "Campo vacío", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Tarea nueva = new Tarea(texto);
            tareas.add(nueva);
            vista.getModelo().addRow(new Object[]{nueva.getNombre(), nueva.getEstado()});
            vista.getTxtTarea().setText(""); // limpiar campo
            actualizarContador();
            JOptionPane.showMessageDialog(vista,
                    "Tarea agregada: " + texto,
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
        });

        // ── Eliminar tarea ─────────────────────────────
        vista.getBtnEliminar().addActionListener(e -> {
            int fila = vista.getTabla().getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista,
                        "Selecciona una tarea para eliminar.",
                        "Sin selección", JOptionPane.WARNING_MESSAGE);
                return;
            }
            tareas.remove(fila);
            vista.getModelo().removeRow(fila);
            actualizarContador();
        });

        // ── Marcar como completada ─────────────────────
        vista.getBtnCompletar().addActionListener(e -> {
            int fila = vista.getTabla().getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista,
                        "Selecciona una tarea para completar.",
                        "Sin selección", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Tarea t = tareas.get(fila);
            t.setEstado("Completada");
            vista.getModelo().setValueAt("Completada", fila, 1);
            JOptionPane.showMessageDialog(vista,
                    "Tarea completada: " + t.getNombre(),
                    "Completada ✓", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void actualizarContador() {
        vista.getLblContador().setText("Total: " + tareas.size());
    }
}