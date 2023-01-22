package com.example.atm_v2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.input.KeyCode.S;

public class ATM implements Initializable{
    private Stage confirmation;
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
    @FXML
    private TextField newPin;

    @FXML
    private TextField oldPin;

//    Label welcome = new Label();
//    Label savings = new Label();
//    Label checks = new Label();
    @FXML
    private ChoiceBox<String> whichAccount;
    @FXML
    private Label amount;
    private String[] choices = {"Savings", "Checks"};

    @FXML
    private Label checks;

    @FXML
    private Label saves;
    @FXML
    private Label welcome;

    @FXML
    private TextField fives;

    @FXML
    private TextField totalAmount;

    @FXML
    private TextField twenties;
    @FXML
    private ChoiceBox<String> intoWhichAccount;

    @FXML
    private TextField storeAmount;
    @FXML
    private TextField amountTransferred;

    @FXML
    private ChoiceBox<String> fromAccount;
    @FXML
    private TextField confirmPin1;
    @FXML
    private TextField confirmPin2;
    @FXML
    private TextField transferPin;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        if(whichAccount == null) {
            whichAccount = new ChoiceBox<String>();
        }
        if(fromAccount == null) {
            fromAccount = new ChoiceBox<String>();
        }
        if(intoWhichAccount == null) {
            intoWhichAccount = new ChoiceBox<String>();
        }
        if(checks == null) {
            checks = new Label();
        }
        if(saves == null) {
            saves = new Label();
        }
        if(welcome == null) {
            welcome = new Label();
        }
        checks.setText("Checks Balance: $" + Account.getUserChecks());
        saves.setText("Savings Balance: $" + Account.getUserSavings());
        welcome.setText("Welcome,\n" + Account.getCurrentUser());
        whichAccount.getItems().addAll(choices);
        whichAccount.setOnAction(this::getAccount);
        intoWhichAccount.getItems().addAll(choices);
        intoWhichAccount.setOnAction(this::getAccount2);
        fromAccount.getItems().addAll(choices);
        fromAccount.setOnAction(this::getAccount3);
    }

    public void getAccount(ActionEvent event) {
        String choice = whichAccount.getValue();
        if (choice.equals("Savings")) {
            amount.setText(choice + " account has $" + Account.getUserSavings());
        } else {
            amount.setText(choice + " account has $" + Account.getUserChecks());
        }
    }
    public void getAccount2(ActionEvent event) {
        String choice = intoWhichAccount.getValue();
        if (choice.equals("Savings")) {
            amount.setText(choice + " account has $" + Account.getUserSavings());
        } else {
            amount.setText(choice + " account has $" + Account.getUserChecks());
        }
    }

    public void getAccount3(ActionEvent event) {
        String choice = fromAccount.getValue();
        if (choice.equals("Savings")) {
            amount.setText(choice + " account has $" + Account.getUserSavings());
        } else {
            amount.setText(choice + " account has $" + Account.getUserChecks());
        }
    }

    public void ifLogged(ActionEvent event) throws Exception {
        if (Account.checkInfo(enterUser.getText(), enterPass.getText())) {
            //The commented below code is proof of my suffering that I coded before I figured out the solution to a bug
//            Parent withdrawing = FXMLLoader.load(getClass().getResource("withdraw.fxml"));
//            String username = enterUser.getText();
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.hide();
//            menu2 = new Group();
//            Scene main = new Scene(menu2,723,549, Color.web("#373656"));
//            Stage mainMenu = new Stage();
//            mainMenu.setScene(main);
//            Rectangle rect = new Rectangle(356, 131);
//            rect.setX(42);
//            rect.setY(130);
//            rect.setFill(Color.TRANSPARENT);
//            rect.setStyle("-fx-stroke: white; -fx-stroke-width: 5;");
//            savings.setText("Savings: $" + Account.getUserSavings());
//            savings.setFont(Font.font("Baskerville Old Face", 27));
//            savings.setTextFill(Color.WHITE);
//            savings.setLayoutX(59);
//            savings.setLayoutY(148);
//            checks.setText("Checks Balance: $" + Account.getUserChecks());
//            checks.setFont(Font.font("Baskerville Old Face", 27));
//            checks.setTextFill(Color.WHITE);
//            checks.setLayoutX(59);
//            checks.setLayoutY(214);
//            welcome.setText("Welcome,\n" + username);
//            welcome.setFont(Font.font("Baskerville Old Face", 34));
//            welcome.setTextFill(Color.WHITE);
//            welcome.setLayoutX(42);
//            welcome.setLayoutY(33);
//            Button deposit = new Button("Deposit");
//            deposit.setPrefSize(206, 62);
//            deposit.setFont(Font.font("Book Antiqua", 24));
//            deposit.setLayoutX(149);
//            deposit.setLayoutY(298);
//            Button withdraw = new Button("Withdraw");
//            withdraw.setPrefSize(206, 62);
//            withdraw.setFont(Font.font("Book Antiqua", 20));
//            withdraw.setLayoutX(371);
//            withdraw.setLayoutY(298);
//            Button transfer = new Button("Transfer");
//            transfer.setPrefSize(206, 62);
//            transfer.setFont(Font.font("Book Antiqua", 24));
//            transfer.setLayoutX(149);
//            transfer.setLayoutY(378);
//            Button pinChange = new Button("Change Pin");
//            pinChange.setPrefSize(206, 62);
//            pinChange.setFont(Font.font("Book Antiqua", 18));
//            pinChange.setLayoutX(371);
//            pinChange.setLayoutY(378);
//            Button exit = new Button("Exit");
//            exit.setPrefSize(108, 62);
//            exit.setFont(Font.font("Book Antiqua", 18));
//            exit.setLayoutX(592);
//            exit.setLayoutY(472);
//            exit.setBackground(Background.fill(Color.web("#b95a46")));
//            exit.setTextFill(Color.WHITE);
//            menu2.getChildren().addAll(rect, welcome, savings, checks, deposit, withdraw, transfer, pinChange, exit);
//            mainMenu.show();
//
//            exit.setOnAction(new EventHandler<ActionEvent>() {
//                public void handle(ActionEvent event) {
//                    System.exit(0);
//                }
//            });
//
//            withdraw.setOnAction(new EventHandler<ActionEvent>() {
//                public void handle(ActionEvent event) {
//                    mainMenu.hide();
//                    scene = new Scene(withdrawing);
//                    stage.setScene(scene);
//                    stage.show();
//                }
//            });
            Account.setCurrentUser(enterUser.getText());

            Parent create = FXMLLoader.load(getClass().getResource("menu.fxml"));
            String user = enterUser.getText();
            scene = new Scene(create);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else {
            result2.setText(Account.checkLogIn(enterUser.getText(), enterPass.getText()));
        }
    }

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

    public void exit(ActionEvent event) throws Exception {
        System.exit(0);
    }

    public void withdraw(ActionEvent event) throws Exception {
        Parent menu = FXMLLoader.load(getClass().getResource("withdraw.fxml"));
        scene = new Scene(menu);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    //How to update values without needing to "switch scenes" - for future references
    public void bal(ActionEvent event) throws Exception {
//        Account.deposit("Checks", 50);
//        Parent create = FXMLLoader.load(getClass().getResource("menu.fxml"));
//        scene = new Scene(create);
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
    }

    public void back(ActionEvent event) throws Exception {
        Parent create = FXMLLoader.load(getClass().getResource("menu.fxml"));
        scene = new Scene(create);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void drawMoney(ActionEvent event) throws Exception{
        String choice = whichAccount.getValue();
        if(confirmPin1.getText().equals(Account.getUserPin())) {
            try {
                if (Account.canWithdraw(choice, Double.parseDouble(totalAmount.getText()),
                        Integer.parseInt(fives.getText()), Integer.parseInt(twenties.getText()))) {
                    Account.withdraw(choice, Double.parseDouble(totalAmount.getText()),
                            +Integer.parseInt(fives.getText()), Integer.parseInt(twenties.getText()));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Receipt");
                    alert.setHeaderText("Withdraw Successful");
                    alert.setContentText("$" + String.format("%.2f", Double.parseDouble(totalAmount.getText())) + " was withdrawn from " + choice);
                    alert.show();

                    Parent create = FXMLLoader.load(getClass().getResource("menu.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(create);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    Alert alert2 = new Alert(Alert.AlertType.ERROR);
                    alert2.setTitle("Invalid Option");
                    alert2.setHeaderText("Invalid Amount");
                    alert2.setContentText(Account.withdraw(choice, Double.parseDouble(totalAmount.getText()),
                            +Integer.parseInt(fives.getText()), Integer.parseInt(twenties.getText())));
                    alert2.show();
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Option");
                alert.setHeaderText("Invalid Amount");
                alert.setContentText("Total Amount, amount of $5 bills, and amount of #20 bills must be a number");
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Wrong pin");
            alert.show();
        }
    }

    public void enterMoney(ActionEvent event) throws Exception {
        String choice = intoWhichAccount.getValue();
        if (confirmPin2.getText().equals(Account.getUserPin())) {
            try {
                Account.deposit(choice, Double.parseDouble(storeAmount.getText()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Receipt");
                alert.setHeaderText("Deposit Successful");
                alert.setContentText("$" + String.format("%.2f", Double.parseDouble(storeAmount.getText())) + " was deposited into " + choice);
                alert.show();

                Parent create = FXMLLoader.load(getClass().getResource("menu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(create);
                stage.setScene(scene);
                stage.show();


            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Option");
                alert.setHeaderText("Invalid Amount");
                alert.setContentText("Total Amount must be a number");
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Wrong pin");
            alert.show();
        }
    }


    public void deposit(ActionEvent event) throws Exception{
        Parent menu = FXMLLoader.load(getClass().getResource("deposit.fxml"));
        scene = new Scene(menu);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public void transfer(ActionEvent event) throws Exception{
        Parent menu = FXMLLoader.load(getClass().getResource("transfer.fxml"));
        scene = new Scene(menu);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public void transferMoney(ActionEvent event) throws Exception {
        String other;
        String choice = fromAccount.getValue();
        if(choice.equals("Savings")) {
            other = "Checks";
        } else {
            other = "Savings";
        }
        if (transferPin.getText().equals(Account.getUserPin())) {
            if(Account.enough(choice, Double.parseDouble(amountTransferred.getText()))) {
                try {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Receipt");
                    alert.setHeaderText(Account.transfer(choice, Double.parseDouble(amountTransferred.getText())));
                    alert.setContentText("$" + String.format("%.2f", Double.parseDouble(amountTransferred.getText())) +
                            " was transfered from " + choice + " to " + other);
                    alert.show();

                    Parent create = FXMLLoader.load(getClass().getResource("menu.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(create);
                    stage.setScene(scene);
                    stage.show();


                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Option");
                    alert.setHeaderText("Invalid Amount");
                    alert.setContentText("Total Amount must be a number");
                    alert.show();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Insufficient Balance");
                alert.setContentText("Amount transfered much be equal to or less than amount in selected account");
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Wrong pin");
            alert.show();
        }
    }

    public void changePin(ActionEvent event) throws Exception {
        Parent change = FXMLLoader.load(getClass().getResource("pinChange.fxml"));
        scene = new Scene(change);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public void changePass(ActionEvent event) throws Exception {
        if (oldPin.getText().equals(Account.getUserPin())) {
            Account.setPin(newPin.getText());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Pin was changed successfully");
            alert.show();

            Parent menu = FXMLLoader.load(getClass().getResource("menu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(menu);
            stage.setScene(scene);
            stage.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Wrong pin");
            alert.show();
        }
    }
}

