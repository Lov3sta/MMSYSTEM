package com.example.mmsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 710, 395);
       // stage.initStyle(StageStyle.UNDECORATED);
        //stage.setTitle("Hello!");
        stage.setScene(scene);
        
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}