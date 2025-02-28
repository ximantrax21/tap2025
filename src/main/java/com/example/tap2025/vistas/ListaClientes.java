package com.example.tap2025.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.example.tap2025.modelos.ClientesDAO;

public class ListaClientes extends Stage {
    private ToolBar tblMenu;
    private TableView<ClientesDAO> tbvClientes;
    private VBox vBox;
    private Scene escena;
    private Button btnAgregar;
    public ListaClientes(){
        CrearUI();
        this.setTitle("Listado de CLientes");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        btnAgregar = new Button();
      //  btnAgregar.setPrefSize(20,20);
        btnAgregar.setGraphic(new ImageView(getClass().getResource("/images/usuario.png").toString()));
        tblMenu= new ToolBar(btnAgregar);
        tbvClientes= new TableView<>();
        CreateTabla();
        vBox =new VBox(tblMenu,tbvClientes);
        escena= new Scene(vBox, 800, 600);

    }

    private void CreateTabla(){
        ClientesDAO objCte= new ClientesDAO();
        TableColumn<ClientesDAO, String> tbcNomCte = new TableColumn<>("Nombre");
        tbcNomCte.setCellValueFactory(new PropertyValueFactory<>("nomCte"));
        TableColumn<ClientesDAO, String> tbcDireccion = new TableColumn<>("Direccion");
        tbcDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        TableColumn<ClientesDAO, String> tbcTel= new TableColumn<>("Telefono");
        tbcTel.setCellValueFactory(new PropertyValueFactory<>("telCte"));
        TableColumn<ClientesDAO, String> tbcEmail = new TableColumn<>("Email");
        tbcEmail.setCellValueFactory(new PropertyValueFactory<>("emailCte"));
        tbvClientes.getColumns().addAll(tbcNomCte,tbcDireccion,tbcTel,tbcEmail);
        tbvClientes.setItems(objCte.SELECT());
    }


}
