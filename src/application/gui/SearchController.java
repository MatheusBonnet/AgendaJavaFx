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

public class SearchController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	protected Button btnCancelar;
	@FXML
	private Button btnBuscar;
	@FXML
	private Button btnEditar;
	@FXML
	private TextField inpBusca;
	@FXML
	protected TextField nome;
	@FXML
	protected TextField sobrenome;
	@FXML
	protected TextField celular;
	@FXML
	protected TextField email;
	@FXML
	protected TextField ddd;
	
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
	
	public void buscarAction(ActionEvent event) {
		buscarCtt();
		
	}
	
	public void editarAction(ActionEvent event) {
		editarContato();
		this.switchToList(event);
	}
	
	private Pessoa buscarCtt() {
		Pessoa newPessoa = new Pessoa();
		for(Pessoa pessoa: Agenda.getContatos()) {
			if(pessoa.getNome().contains(inpBusca.getText())) {
				newPessoa = pessoa;
				nome.setText(newPessoa.getNome());
				sobrenome.setText(newPessoa.getSobrenome());
				email.setText(newPessoa.getContato().getEmail());
				ddd.setText(newPessoa.getContato().getDdd());
				celular.setText(newPessoa.getContato().getTelefone());
			}
		}
		return newPessoa;
	}
	
	private void editarContato() {
		Pessoa pessoa = buscarCtt();
		if(pessoa != null) {
			pessoa.setNome(nome.getText());
			pessoa.setSobrenome(sobrenome.getText());
			pessoa.getContato().setDdd(ddd.getText());
			pessoa.getContato().setEmail(email.getText());
			pessoa.getContato().setTelefone(celular.getText());
			
			Alert alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setTitle("Sucesso!");
			alerta.setHeaderText("Contato editado com sucesso!");
			alerta.show();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

}
