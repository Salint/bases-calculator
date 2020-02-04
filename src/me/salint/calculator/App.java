package me.salint.calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;

import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;

public class App {

    App(Stage stage) throws FileNotFoundException {

        InputStream in = Class.class.getResourceAsStream("/res/background.jpeg");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(10);
        grid.setBackground(new Background(new BackgroundImage(new Image(in),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

        Text title = new Text("Bases Calculator");
        title.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        title.setBlendMode(BlendMode.OVERLAY);
        grid.add(title, 0, 0, 2, 1);

        Label decLabel = new Label("Decimal: ");
        grid.add(decLabel, 0, 1);

        TextField decimal = new TextField();
        grid.add(decimal, 1, 1);
        decimal.setBlendMode(BlendMode.OVERLAY);

        Label binLabel = new Label("Binary: ");
        grid.add(binLabel, 0, 2);

        TextField binary = new TextField();
        grid.add(binary, 1, 2);
        binary.setBlendMode(BlendMode.OVERLAY);

        Label hexLabel = new Label("Hexadecimal: ");
        grid.add(hexLabel, 0, 3);

        TextField hex = new TextField();
        grid.add(hex, 1, 3);
        hex.setBlendMode(BlendMode.OVERLAY);

        Button decbut = new Button("Transform");
        decbut.setBlendMode(BlendMode.OVERLAY);
        grid.add(decbut, 2, 1);

        Button binbut = new Button("Transform");
        binbut.setBlendMode(BlendMode.OVERLAY);
        grid.add(binbut, 2, 2);

        Button hexbut = new Button("Transform");
        hexbut.setBlendMode(BlendMode.OVERLAY);
        grid.add(hexbut, 2, 3);

        decbut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(decimal.getText().length() == 0) return;
                binary.setText(Integer.toBinaryString(Integer.parseInt(decimal.getText())));
                hex.setText(Integer.toHexString(Integer.parseInt(decimal.getText())));

            }
        });
        binbut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(binary.getText().length() == 0) return;
                hex.setText(Integer.toHexString(Integer.parseInt(binary.getText(), 2)));
                decimal.setText(Integer.toString(Integer.parseInt(binary.getText(), 2)));

            }
        });
        hexbut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(hex.getText().length() == 0) return;
                binary.setText(Integer.toBinaryString(Integer.parseInt(hex.getText(), 16)));
                decimal.setText(Integer.toString(Integer.parseInt(hex.getText(), 16)));

            }
        });

        Scene scene = new Scene(grid, 500, 450);

        stage.setScene(scene);
        stage.setTitle("Bases Calculator");
        stage.setResizable(false);
        stage.show();

    }

}
