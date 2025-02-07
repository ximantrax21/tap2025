package com.example.tap2025.vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Stage { //hereda de Stage para la interfaz
    private Scene escena;
    private TextField txtDisplay;
    private VBox vBox;
    private GridPane gdpKeyboard;
    private Button[][] arrBtnTeclado;
    String strTeclas[]={"7","8","9","*","4","5","6","/","1","2","3","+","=","0",".","-"};
    public void CrearUI(){
        CrearKeyboard();
        txtDisplay = new TextField("0");
        txtDisplay.setEditable(false);
        txtDisplay.setAlignment(Pos.BASELINE_RIGHT);
        vBox = new VBox(txtDisplay, gdpKeyboard);
        vBox.setSpacing(15);
        vBox.setPadding(new Insets(15));
        escena = new Scene(vBox, 200,200);

    }
    public void CrearKeyboard(){
        arrBtnTeclado = new Button[4][4];
        gdpKeyboard= new GridPane();
        gdpKeyboard.setHgap(10);
        gdpKeyboard.setVgap(10);
        int pos=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arrBtnTeclado[i][j]= new Button(strTeclas[pos]);
                arrBtnTeclado[i][j].setPrefSize(50,50);
                gdpKeyboard.add(arrBtnTeclado[i][j],j,i);
                pos++;
            }

        }
    }
    public Calculadora(){
        CrearUI();
        this.setScene(escena);
        this.setTitle("Calculadora");
        this.show();
    }
}
//