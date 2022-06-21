package application.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.domain.Agenda;
import application.domain.Contato;
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

public class FormController implements Initializable{

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	// componentes da tela
	@FXML
	protected Button btnCancelar;
	@FXML
	protected Button btnSalvar;
	@FXML
	protected TextField inpNome;
	@FXML
	protected TextField inpSobrenome;
	@FXML
	protected TextField inpTelefoneCelular;
	@FXML
	protected TextField inpEmail;
	@FXML
	protected TextField inpDDD;
	
	
	
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
	
	private Boolean validaCamposObrigatorios() {
		if (inpNome.getText().isBlank() || inpNome.getText().isEmpty()) {
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Atenção!");
			alerta.setHeaderText("Campos obrigatórios não foram preenchidos");
			alerta.setContentText("Nome é obrigatório!");
			alerta.show();
			return false;
		}
		return true;
	}
	
	
	public void salvarAction(ActionEvent event) {
			created();
			this.switchToList(event);
	}
	
	@SuppressWarnings("static-access")
	private void created() {
		if (validaCamposObrigatorios()) {
			Agenda agenda = new Agenda();
			Contato contato = new Contato();
			Pessoa pessoa = new Pessoa();
			List<Pessoa> listPessoa = new ArrayList<Pessoa>(agenda.getContatos());
			
			
			pessoa.setNome(inpNome.getText());
			pessoa.setSobrenome(inpSobrenome.getText());
			pessoa.setContato(contato);
			contato.setDdd(inpDDD.getText());
			contato.setEmail(inpEmail.getText());
			contato.setTelefone(inpTelefoneCelular.getText());
			listPessoa.add(pessoa);
			
			agenda.setContatos(listPessoa);
			
			Alert alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setTitle("Sucesso!");
			alerta.setHeaderText("Contato cadastrado com sucesso!");
			alerta.show();			
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
