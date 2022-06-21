package application.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.domain.Agenda;
import application.domain.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	protected Button btnCancelar;
	@FXML
	protected Button btnExcluir;
	@FXML
	private TextField inpExcluir;
	
	public void switchToList(ActionEvent event) {
		try {
			root  = FXMLLoader.load(getClass().getResource("List.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void excluirAction(ActionEvent event) {
		excluirCtt();
		this.switchToList(event);
	}
	
	private void excluirCtt() {
		for(Pessoa pessoa: Agenda.getContatos()) {
			if(pessoa.getNome().contains(inpExcluir.getText())) {
				Agenda.getContatos().remove(pessoa);
				Alert alerta = new Alert(AlertType.CONFIRMATION);
				alerta.setTitle("Sucesso!");
				alerta.setHeaderText("Contato excluido com sucesso!");
				alerta.show();
			}else {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("Não encontrado!");
				alerta.setHeaderText("Contato não encontrado na lista!");
				alerta.show();
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

}
