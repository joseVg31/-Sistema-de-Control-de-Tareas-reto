package org.example.sistemadecontroldetareas.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Vista: toda la interfaz gráfica.
 * No contiene lógica de negocio.
 */
public class VentanaPrincipal extends JFrame {

    private JTextField txtTarea;
    private JButton btnAgregar, btnEliminar, btnCompletar;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel lblContador;

    public VentanaPrincipal() {
        setTitle("Gestor de Tareas");
        setSize(480, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponentes();
    }

    private void initComponentes() {
        setLayout(new BorderLayout(10, 10));

        // ── Panel superior: título ─────────────────────
        JLabel titulo = new JLabel("Mis Tareas", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        add(titulo, BorderLayout.NORTH);

        // ── Panel central: campo + tabla ───────────────
        JPanel centro = new JPanel(new BorderLayout(5, 5));
        centro.setBorder(BorderFactory.createEmptyBorder(5,15,5,15));

        // TextField + botón Agregar
        txtTarea = new JTextField();
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBackground(new Color(67, 97, 238));
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setFocusPainted(false);

        JPanel panelInput = new JPanel(new BorderLayout(5,0));
        panelInput.add(txtTarea, BorderLayout.CENTER);
        panelInput.add(btnAgregar, BorderLayout.EAST);

        // JTable con columnas Tarea / Estado
        modelo = new DefaultTableModel(new String[]{"Tarea", "Estado"}, 0) {
            @Override
            public boolean isCellEditable(int r, int c) { return false; }
        };
        tabla = new JTable(modelo);
        tabla.setRowHeight(24);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        centro.add(panelInput, BorderLayout.NORTH);
        centro.add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(centro, BorderLayout.CENTER);

        // ── Panel inferior: botones + contador ─────────
        btnCompletar = new JButton("Completar");
        btnCompletar.setBackground(new Color(76, 175, 80));
        btnCompletar.setForeground(Color.WHITE);
        btnCompletar.setFocusPainted(false);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(new Color(244, 67, 54));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFocusPainted(false);

        lblContador = new JLabel("Total: 0");
        lblContador.setForeground(Color.GRAY);

        JPanel sur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        sur.add(lblContador);
        sur.add(btnCompletar);
        sur.add(btnEliminar);
        add(sur, BorderLayout.SOUTH);
    }

    // Getters para que el controlador conecte los eventos
    public JTextField     getTxtTarea()    { return txtTarea; }
    public JButton        getBtnAgregar()  { return btnAgregar; }
    public JButton        getBtnEliminar() { return btnEliminar; }
    public JButton        getBtnCompletar(){ return btnCompletar; }
    public JTable         getTabla()       { return tabla; }
    public DefaultTableModel getModelo()  { return modelo; }
    public JLabel         getLblContador() { return lblContador; }
}