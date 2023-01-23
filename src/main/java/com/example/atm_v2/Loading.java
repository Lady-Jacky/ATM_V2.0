package com.example.atm_v2;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Loading extends Application {
    //This is what "runs" the program and decides what it would look like when it is first launched.
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Loading.class.getResource("LoadingScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Bank of Teyvat");
        stage.setScene(scene);
        stage.show();
        Parent loginorCreate = FXMLLoader.load(getClass().getResource("CreateLogin.fxml"));
        Scene scene2 = new Scene(loginorCreate);
        delay(3000, () -> stage.setScene(scene2));
    }



    //Credits to Dave8 for this delay method because apparently .wait() and . sleep() dont really work for Java FX:
    // https://stackoverflow.com/questions/26454149/make-javafx-wait-and-continue-with-code
    public static void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try { Thread.sleep(millis); }
                catch (InterruptedException e) { }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }

    public static void main(String[] args) {
        launch();
    }
}