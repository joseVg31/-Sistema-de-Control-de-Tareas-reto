module org.example.sistemadecontroldetareas {
    // Requerido para que Java reconozca Swing y AWT (JFrame, JPanel, etc.)
    requires java.desktop;

    // Exportamos los paquetes para que las clases sean accesibles al ejecutar
    exports org.example.sistemadecontroldetareas;
    exports org.example.sistemadecontroldetareas.model;
    exports org.example.sistemadecontroldetareas.controller;
    exports org.example.sistemadecontroldetareas.view;
}