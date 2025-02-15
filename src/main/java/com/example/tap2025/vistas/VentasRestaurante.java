package com.example.tap2025.vistas;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.kordamp.bootstrapfx.scene.layout.Panel;

public class VentasRestaurante extends Stage {
    private Panel pnlRestaurante;
    private Scene escena;
    public VentasRestaurante(){
        CrearUI();
        this.setTitle("Restaurante Rodriguez");
        this.setScene(escena);
        this.show();
    }

    void CrearUI(){
        pnlRestaurante= new Panel("Tacos el Inge");
        pnlRestaurante.getStyleClass().add("panel-warning");
        escena= new Scene(pnlRestaurante, 300, 300);
        escena.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
    }
}
