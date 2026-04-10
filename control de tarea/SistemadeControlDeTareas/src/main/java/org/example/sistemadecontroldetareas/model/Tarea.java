package org.example.sistemadecontroldetareas.model;

/**
 * Modelo: representa una tarea con nombre y estado.
 * No conoce ni la vista ni el controlador.
 */
public class Tarea {

    private String nombre;
    private String estado; // "Pendiente" o "Completada"

    // Constructor
    public Tarea(String nombre) {
        this.nombre = nombre;
        this.estado = "Pendiente";
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getEstado() { return estado; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return nombre + " [" + estado + "]";
    }
}