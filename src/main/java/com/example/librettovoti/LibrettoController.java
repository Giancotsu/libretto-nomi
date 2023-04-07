package com.example.librettovoti;

import com.example.librettovoti.model.Libretto;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {

    public Libretto model;

    public void setModel(Libretto model) {
        this.model = model;
        txtOutput.setText(this.model.toString());
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> cmbVoto;

    @FXML
    private DatePicker selDate;

    @FXML
    private TextField txtNomeCorso;

    @FXML
    private TextArea txtOutput;

    @FXML
    void handleInserisci(ActionEvent event) {
        Voto voto = new Voto(txtNomeCorso.getText(), cmbVoto.getValue(), selDate.getValue());
        model.add(voto);
        txtOutput.setText(this.model.toString());
    }

    @FXML
    void initialize() {
        assert cmbVoto != null : "fx:id=\"cmbVoto\" was not injected: check your FXML file 'main.fxml'.";
        assert selDate != null : "fx:id=\"selDate\" was not injected: check your FXML file 'main.fxml'.";
        assert txtNomeCorso != null : "fx:id=\"txtNomeCorso\" was not injected: check your FXML file 'main.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'main.fxml'.";

        for (int v=18;v<=30; v++){
            cmbVoto.getItems().add(v);
        }

    }
}
