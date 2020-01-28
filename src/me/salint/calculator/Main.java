package me.salint.calculator;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        new App(stage);
    }


    public static void main(String[] args) {
        launch(args);
    }

}
