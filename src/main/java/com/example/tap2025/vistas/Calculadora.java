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
    private StringBuilder expresion;
    private boolean nuevaOperacion;
    String strTeclas[]={"7","8","9","*","4","5","6","/","1","2","3","+","=","0",".","-"};
    public void CrearUI(){
        CrearKeyboard(); //crea el teclado
        txtDisplay = new TextField("0"); //inicializa el display de la calculadora en 0
        //txtDisplay.setPromptText("Teclea tu operación");
        txtDisplay.setEditable(false); //hace q no pueda ser editable el display
        txtDisplay.setAlignment(Pos.BASELINE_RIGHT); //alinea el texto a la derecha
        vBox = new VBox(txtDisplay, gdpKeyboard); //agrega display y teclado al VBox vertical
        vBox.setSpacing(15); //separa elementos
        vBox.setPadding(new Insets(15)); //aplica un margen padre-hijo
        escena = new Scene(vBox, 200,200);// Crea la escena con el tamaño dado
        escena.getStylesheets().add(getClass().getResource("/styles/Calculadora.css").toString());//parametro string es la ruta para el archivo

        //URL y UIS la url es localizador de recursos y la uis es identificador de recursos universal
    }
    public void CrearKeyboard(){ //metodo que crea el teclado
        arrBtnTeclado = new Button[4][4]; //arreglo de botones y su orgnizacion
        gdpKeyboard= new GridPane(); //panel de la cuadricula para los botones
        gdpKeyboard.setHgap(10); //espacio horizontal de los botones
        gdpKeyboard.setVgap(10); //espacio vertical de los botones
        int pos=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arrBtnTeclado[i][j]= new Button(strTeclas[pos]); //creacion del boton con el signo
                arrBtnTeclado[i][j].getStyleClass().add("button");

                if(strTeclas[pos].equals("*,-,/,+,=")) { //estilo css
                    arrBtnTeclado[i][j].setId("fontButton"); //estilo css
                    arrBtnTeclado[i][j].setStyle("-fx-background-color: white"); //estilo css
                }
                int finalPos = pos;
                arrBtnTeclado[i][j].setOnAction(event -> EventoTeclado(strTeclas[finalPos])); //aplica un evento al dar clic
                arrBtnTeclado[i][j].setPrefSize(50,50); //establece tamano
                gdpKeyboard.add(arrBtnTeclado[i][j],j,i); //agrega el boton al panel
                pos++;

                //pseudoclases: paseudo:falso, se refieren a clases falsas que llevan un comportamiento distinto, por ejemoplo hover, que lo que hacen es
                //ejecutar estilo cuando el cursor pasa encima de un elemento
            }

        }
    }
    public Calculadora() {
        expresion = new StringBuilder();
        CrearUI();
        this.setScene(escena);
        this.setTitle("Calculadora");
        this.show();
    }
    private void EventoTeclado(String strTecla) {
        if (nuevaOperacion) {
            txtDisplay.setText("");
            expresion.setLength(0);
            nuevaOperacion = false;
        }

        if (strTecla.equals("=")) {
            calcularResultado();
        } else {
            if (txtDisplay.getText().equals("0")) {
                txtDisplay.setText(strTecla);
                expresion.setLength(0);
            } else {
                txtDisplay.appendText(strTecla);
            }
            expresion.append(strTecla);
        }
    }

    private void calcularResultado() {
        String operacion =expresion.toString();
        double resultado =evaluarExpresion(operacion);
        txtDisplay.setText(Double.isNaN(resultado) ? "Error" : String.valueOf(resultado));
        expresion.setLength(0);
        expresion.append(Double.isNaN(resultado) ? "" : resultado);
        nuevaOperacion = true;
    }

    private double evaluarExpresion(String operacion) {
        if (operacion.matches(".*[+\\-*/]{2,}.*") || operacion.endsWith("+") ||
                operacion.endsWith("-") || operacion.endsWith("*") || operacion.endsWith("/")) {//operacion.endsWith
            return Double.NaN; //Doule Nan, es Not a Number, es que una fomr ade cacahr excpeciones en el caso de no ingresar un numero en el dispay
        }

        String[] numeros = operacion.split("[-+*/]");
        String[] operadores = operacion.split("\\d+(?:\\.\\d+)?");

        if (numeros.length < 2) return Double.NaN;

        double resultado = Double.parseDouble(numeros[0]);
        int opIndex = 1;
        for (int i = 1; i < numeros.length; i++) {
            if (opIndex >= operadores.length) break;
            double num = Double.parseDouble(numeros[i]);
            switch (operadores[opIndex]) {
                case "+" -> resultado += num;
                case "-" -> resultado -= num;
                case "*" -> resultado *= num;
                case "/" -> resultado = (num == 0) ? Double.NaN : resultado / num;
            }
            opIndex++;
        }
        return resultado;
    }
}
