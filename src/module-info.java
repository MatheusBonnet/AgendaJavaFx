module AgendaContatoFx {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens application.domain;
	opens application.gui to javafx.graphics, javafx.fxml;
}
