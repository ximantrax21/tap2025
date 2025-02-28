package com.example.tap2025.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;

public class Cliente extends Stage {
    private Scene escena;
    private Button btnGuardar;
    private TextField txtNomCte, txtDireccion, txtTelCte, txtEmail;
    private VBox vBox;

    public Cliente(){
        this.setTitle("Registrar Cliente");
        this.setScene(escena);
        this.show();

    }

    private void CrearUI(){
        txtNomCte = new TextField();
        txtDireccion = new TextField();
        txtTelCte = new TextField();
        txtEmail = new TextField();
        btnGuardar=new Button();
        vBox =new VBox(txtNomCte, txtDireccion, txtTelCte, txtEmail,btnGuardar);
        escena=new Scene(vBox, 120, 150);
    }
}
