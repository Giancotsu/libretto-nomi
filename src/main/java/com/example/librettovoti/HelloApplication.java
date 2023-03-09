package com.example.librettovoti;

import com.example.librettovoti.model.Libretto;
import com.example.librettovoti.model.Voto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch();



         applicationTest();






    }

    private static void applicationTest() {
        Libretto libretto = new Libretto();

        libretto.add(new Voto("Programmazione 1", 27, LocalDate.of(2018, 10, 25)));
        libretto.add(new Voto("Analisi 1", 19, LocalDate.of(2018, 10, 26)));

        libretto.stampaVoti();



    }
}