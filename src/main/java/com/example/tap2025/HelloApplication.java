package com.example.tap2025;

import com.example.tap2025.vistas.Calculadora;
import com.example.tap2025.vistas.VentasRestaurante;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Button btnSaludo, btnSaludo2, btnSaludo3; //covencion camelCase (forma de nombrar los objetos

    private VBox vBox; //herramienta para situar los botones de manera vertical, usar HBox de manera horizontal
    private MenuBar mnbPrincipal;
    private Menu menCompetencia1, getMenCompetencia2;
    private MenuItem mitCalculadora, mitRestaurante; //agrega al menu lo que sera la escena de la calculadora
    private Scene scena;
    void CrerUI(){
        //ir de lo particular a lo general
        mitCalculadora= new MenuItem("Calculadora"); //crea el elemento -calculadora del menu
        mitCalculadora.setOnAction(actionEvent -> new Calculadora()); //asigna un evento al mismo tiempo que instancia la nueva calculadora
        mitRestaurante= new MenuItem("Restaurante");
        mitRestaurante.setOnAction(actionEvent -> new VentasRestaurante());
        menCompetencia1=new Menu("Competencia 1");
        menCompetencia1.getItems().addAll(mitCalculadora, mitRestaurante);
        mnbPrincipal=new MenuBar();
        mnbPrincipal.getMenus().addAll(menCompetencia1);
        vBox= new VBox(mnbPrincipal);;
        scena= new Scene(vBox);
        scena.getStylesheets().add(getClass().getResource("/styles/main.css").toString());
    }
    @Override
    public void start(Stage stage) throws IOException {
        CrerUI();
        //vBox= new VBox();
        stage.setTitle("Hola Mundo de Eventos <3");
        stage.setScene(scena);
        stage.show();
        stage.setMaximized(true); //para maximizar la ventana
    }

    public static void main(String[] args) {
        launch();
    }

}
/*
//se instancia de lo oparticular o a lo general
//ya que vBox, por ejemplo, tiene la opcion de instanciar los opjetos ya instancias anteriormente
btnSaludo=new Button("Bienvenido madafacker <3");
btnSaludo.setOnAction(actionEvent ->clickEvent("Hola"));//estructura lamda
btnSaludo2=new Button("Bienvenido madafacker <3");
btnSaludo2.setOnAction(actionEvent ->clickEvent("Mundo"));//estructura lamda
btnSaludo3=new Button("Bienvenido madafacker <3");
btnSaludo3.setOnAction(actionEvent ->clickEvent("<3"));//estructura lamda
vBox.setSpacing(10);//setSpacing para espaciar, el double se refiere a pixeles
//padding es respecto del padre hacia el hijo, y cuando se habla del margen es desde el hijo, respecto al padre
//padding horizontal
//margin vertical
vBox.setPadding(new Insets(10, 0,0,0));//insets es una clase mas, por ello se instancia
void clickEvent(String mensaje){
    System.out.println(mensaje);
}
private Button btnSaludo, btnSaludo2, btnSaludo3; //covencion camelCase (forma de nombrar los objetos
*/