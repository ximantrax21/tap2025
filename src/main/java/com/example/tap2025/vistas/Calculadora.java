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
        //txtDisplay.setPromptText("Teclea tu operación");
        txtDisplay.setEditable(false);
        txtDisplay.setAlignment(Pos.BASELINE_RIGHT);
        vBox = new VBox(txtDisplay, gdpKeyboard);
        vBox.setSpacing(15);
        vBox.setPadding(new Insets(15));
        escena = new Scene(vBox, 200,200);
        escena.getStylesheets().add(getClass().getResource("/styles/Calculadora.css").toString());    //parametro string es la ruta para el archivo

        //URL y UIS la url es localizador de recursos y la uis es identificador de recursos universal
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
                if(strTeclas[pos].equals("*,-,")) {
                    arrBtnTeclado[i][j].setId("fontButton");
                    arrBtnTeclado[i][j].setStyle("-fx-background-color: white");
                }
                int finalPos = pos;
                arrBtnTeclado[i][j].setOnAction(event -> EventoTeclado(strTeclas[finalPos]));
                arrBtnTeclado[i][j].setPrefSize(50,50);
                gdpKeyboard.add(arrBtnTeclado[i][j],j,i);
                pos++;

                //pseudoclases: paseudo:falso, se refieren a clases falsas que llevan un comportamiento distinto, por ejemoplo hover, que lo que hacen es
                //ejecutar estilo cuando el cursor pasa encima de un elemento
            }

        }
    }
    private void EventoTeclado(String strTecla) {
        txtDisplay.appendText(strTecla);
    }
    public Calculadora(){
        CrearUI();
        this.setScene(escena);
        this.setTitle("Calculadora");
        this.show();
    }
}
//