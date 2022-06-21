package application.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.domain.Agenda;
import application.domain.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ListController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	// campos da tela
	@FXML
	private TableView<Pessoa> tabelaPessoas;
	
	public void switchToForm(ActionEvent event) {
		try {
			root  = FXMLLoader.load(getClass().getResource("Form.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void switchToSearch(ActionEvent event) {
		try {
			root  = FXMLLoader.load(getClass().getResource("Search.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void switchToDelete(ActionEvent event) {
		try {
			root  = FXMLLoader.load(getClass().getResource("Delete.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void carregarDados() {	
		ObservableList<Pessoa> pessoaObservableList = FXCollections.observableArrayList(Agenda.getContatos());
		this.tabelaPessoas.setItems(pessoaObservableList);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		this.tabelaPessoas.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		carregarDados();
	}
	
	

	
}
