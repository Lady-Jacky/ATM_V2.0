package com.example.atm_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class ATM {
    private Stage stage;
    private Scene scene;
    @FXML
    private TextField createPass;
    @FXML
    private TextField createUser;
    @FXML
    private Label result;
    @FXML
    private TextField enterPass;

    @FXML
    private TextField enterUser;

    @FXML
    private Label result2;

    public void createAccount(ActionEvent event) throws IOException {
        Parent create = FXMLLoader.load(getClass().getResource("createAccount.fxml"));
        scene = new Scene(create);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void create(ActionEvent event) {
        String username = createUser.getText();
        String password = createPass.getText();
        result.setText(Account.createAccount(username, password));
    }

    public void returnBack(ActionEvent event) throws Exception {
        Parent loginorCreate = FXMLLoader.load(getClass().getResource("CreateLogin.fxml"));
        scene = new Scene(loginorCreate);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public void logIn(ActionEvent event) throws Exception {
        Parent menu = FXMLLoader.load(getClass().getResource("loggingIn.fxml"));
        scene = new Scene(menu);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public void ifLogged(ActionEvent event) throws Exception {
        if (Account.checkInfo(enterUser.getText(), enterPass.getText())) {
            Parent menu = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            scene = new Scene(menu);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } else {
            result2.setText(Account.checkLogIn(enterUser.getText(), enterPass.getText()));
        }
    }
}
