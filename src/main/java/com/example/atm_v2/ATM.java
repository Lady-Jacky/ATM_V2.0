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
//All the instance variables
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
    private TextField confirmPin;
    private int count = 0;
    private int trys = 3;


//Initializes all the Choiceboxes and gives them values based on the String Array "Choices"
    //Also makes sure that none of the choices boxes and labels will equal null
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

    //Sets the action for what would happen when a choice from whichAccount is selected
    public void getAccount(ActionEvent event) {
        String choice = whichAccount.getValue();
        if (choice.equals("Savings")) {
            amount.setText(choice + " account has $" + Account.getUserSavings());
        } else {
            amount.setText(choice + " account has $" + Account.getUserChecks());
        }
    }
    //Sets the action for what would happen when a choice from intoWhichAccount is selected
    public void getAccount2(ActionEvent event) {
        String choice = intoWhichAccount.getValue();
        if (choice.equals("Savings")) {
            amount.setText(choice + " account has $" + Account.getUserSavings());
        } else {
            amount.setText(choice + " account has $" + Account.getUserChecks());
        }
    }
    //Sets the action for what would happen when a choice from fromAccount is selected
    public void getAccount3(ActionEvent event) {
        String choice = fromAccount.getValue();
        if (choice.equals("Savings")) {
            amount.setText(choice + " account has $" + Account.getUserSavings());
        } else {
            amount.setText(choice + " account has $" + Account.getUserChecks());
        }
    }

//switches the scene to the scene for creating an account
    public void createAccount(ActionEvent event) throws IOException {
        Parent create = FXMLLoader.load(getClass().getResource("createAccount.fxml"));
        scene = new Scene(create);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //switches the scene to the scene for returning to the scene that allows you to choose to either long in or create a new account
    public void returnBack(ActionEvent event) throws Exception {
        Parent loginorCreate = FXMLLoader.load(getClass().getResource("CreateLogin.fxml"));
        scene = new Scene(loginorCreate);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    //switches the scene to the scene for logging into an account
    public void logIn(ActionEvent event) throws Exception {
        Parent menu = FXMLLoader.load(getClass().getResource("loggingIn.fxml"));
        scene = new Scene(menu);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    //allows the user to close the program after prompting them to make sure that they were certain that they wanted
    //to close the program
    public void exit(ActionEvent event) throws Exception {
        Alert exit = new Alert(Alert.AlertType.CONFIRMATION);
        exit.setTitle("Exit");
        exit.setHeaderText("You are now exiting the program");
        if (exit.showAndWait().get() == ButtonType.OK){
            System.exit(0);
        }
    }
    //switches the scene to the scene for withdrawing money
    public void withdraw(ActionEvent event) throws Exception {
        Parent menu = FXMLLoader.load(getClass().getResource("withdraw.fxml"));
        scene = new Scene(menu);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
    //switches the scene to the scene for depositing money
    public void deposit(ActionEvent event) throws Exception{
        Parent menu = FXMLLoader.load(getClass().getResource("deposit.fxml"));
        scene = new Scene(menu);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
    //switches the scene to the scene for transferring money
    public void transfer(ActionEvent event) throws Exception{
        Parent menu = FXMLLoader.load(getClass().getResource("transfer.fxml"));
        scene = new Scene(menu);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
    //switches the scene to the scene for changing the user's pin
    public void changePin(ActionEvent event) throws Exception {
        Parent change = FXMLLoader.load(getClass().getResource("pinChange.fxml"));
        scene = new Scene(change);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
    //switches the scene to the main menu of the program
    public void back(ActionEvent event) throws Exception {
        Parent create = FXMLLoader.load(getClass().getResource("menu.fxml"));
        scene = new Scene(create);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    //recieves the data from textfields createUser and createPass and sets those to the account's
    // username and pin respectively. The pin is checked to make sure it only contains numbers. If not, a label is
    // edited to inform the user about it
    public void create(ActionEvent event) {
        String username = createUser.getText();
        try {
            int passTemp = Integer.parseInt(createPass.getText());
            String password = "" + passTemp;
            result.setText(Account.createAccount(username, password));
        } catch (NumberFormatException e) {
            result.setText("Password must be in numbers format");
        }
    }
    //checks to see if the username and pin inserted into the 2 textfields are correct and will switch the scene to the
    // main menu if it is. If not, a label will be editted to inform the user that something is wrong with the information
    public void ifLogged(ActionEvent event) throws Exception {
        if (Account.checkInfo(enterUser.getText(), enterPass.getText())) {
            Account.setCurrentUser(enterUser.getText());

            Parent create = FXMLLoader.load(getClass().getResource("menu.fxml"));
            scene = new Scene(create);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else {
            result2.setText(Account.checkLogIn(enterUser.getText(), enterPass.getText()));
        }
    }
    //The method that allows for the withdrawal of money from a specific account. It checks to see if the amount entered
    //is a positive number and if it isn't an error message will pop up and inform the user about it. Then it will make
    // sure that the amount that is to be withdrawn is infact in the account. If the amount entered meets the requirements,
    // a receipt will pop up and show the user their account details. Then it will make sure they have to reenter
    // their pin as a security measure.
    public void drawMoney(ActionEvent event) throws Exception {
        String choice = whichAccount.getValue();
        if(Double.parseDouble(totalAmount.getText()) > 0 && Integer.parseInt(twenties.getText()) >= 0
                && Integer.parseInt(fives.getText()) >= 0){
            try {
                if (Account.canWithdraw(choice, Double.parseDouble(totalAmount.getText()),
                        Integer.parseInt(fives.getText()), Integer.parseInt(twenties.getText()))) {
                    Account.withdraw(choice, Double.parseDouble(totalAmount.getText()),
                            +Integer.parseInt(fives.getText()), Integer.parseInt(twenties.getText()));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Receipt");
                    alert.setHeaderText("Withdraw Successful");
                    alert.setContentText("$" + String.format("%.2f", Double.parseDouble(totalAmount.getText()))
                            + " was withdrawn from " + choice + "\n" + Account.getBal());
                    alert.show();

                    Parent create = FXMLLoader.load(getClass().getResource("confirm.fxml"));
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
            alert.setTitle("Invalid Option");
            alert.setHeaderText("Invalid Amount");
            alert.setContentText("Total amount, amount of $5 bills and $20 bills cannot be negative and total amount cannot be 0");
            alert.show();
        }
    }


    //This method allows the user to deposit money into a specified account. It checks to see if the amount the user
    // wants to store is a positive number. If not, then an error message will pop up, informing the user about it. Then
    // it will make sure they have to reenter their pin as a security measure.
    public void enterMoney(ActionEvent event) throws Exception {
        String choice = intoWhichAccount.getValue();
        if(Double.parseDouble(storeAmount.getText()) > 0) {
            try {
                Account.deposit(choice, Double.parseDouble(storeAmount.getText()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Receipt");
                alert.setHeaderText("Deposit Successful");
                alert.setContentText("$" + String.format("%.2f", Double.parseDouble(storeAmount.getText())) +
                        " was deposited into " + choice + "\n" + Account.getBal());
                alert.show();

                Parent create = FXMLLoader.load(getClass().getResource("confirm.fxml"));
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
            alert.setTitle("Invalid Option");
            alert.setHeaderText("Invalid Amount");
            alert.setContentText("Total Amount cannot be negative or 0");
            alert.show();
        }
    }

    //The method that allows for the transfer of money from a specific account to the other. It checks to see if the
    // amount entered
    //is a positive number and if it isn't an error message will pop up and inform the user about it. Then it will make
    // sure that the amount that is to be transfered is in fact in the account. If the amount entered meets the requirements,
    // a receipt will pop up and show the user their account details. Then it will make sure they have to reenter
    // their pin as a security measure.
    public void transferMoney(ActionEvent event) throws Exception {
        String other;
        String choice = fromAccount.getValue();
        if (choice.equals("Savings")) {
            other = "Checks";
        } else {
            other = "Savings";
        }
        if(Double.parseDouble(amountTransferred.getText()) > 0) {
            if (Account.enough(choice, Double.parseDouble(amountTransferred.getText()))) {
                try {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Receipt");
                    alert.setHeaderText(Account.transfer(choice, Double.parseDouble(amountTransferred.getText())));
                    alert.setContentText("$" + String.format("%.2f", Double.parseDouble(amountTransferred.getText())) +
                            " was transfered from " + choice + " to " + other + "\n" + Account.getBal());
                    alert.show();

                    Parent create = FXMLLoader.load(getClass().getResource("confirm.fxml"));
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
            alert.setTitle("Invalid Option");
            alert.setHeaderText("Invalid Amount");
            alert.setContentText("Amount transferred cannot be negative or 0");
            alert.show();
        }
    }

    //The method that allows for the password to be changed. Makes sure that the new pin entered is not the same as
    // the old pin.
    public void changePass(ActionEvent event) throws Exception {
        if (oldPin.getText().equals(Account.getUserPin())) {
            if(newPin.getText().equals(Account.getUserPin())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("New pin cannot be the same as old pin");
                alert.show();
            } else {
                Account.setPin(newPin.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Pin was changed successfully");
                alert.setContentText(Account.getBal());
                alert.show();

                Parent menu = FXMLLoader.load(getClass().getResource("confirm.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(menu);
                stage.setScene(scene);
                stage.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Wrong pin");
            alert.show();
        }
    }

    //The method that makes the user confirm their pin every time they comeplete an action.
    // If the user gets the pin wrong, they will be warned. If the user gets the pin wrong 3 times,
    // the program will be forcibly stopped
    public void confirmPin(ActionEvent event) throws Exception {
        if(confirmPin.getText().equals(Account.getUserPin())) {
            count = 0;
            Parent menu = FXMLLoader.load(getClass().getResource("menu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(menu);
            stage.setScene(scene);
            stage.show();
        } else {
            count++;
            trys = 3 - count;
            if(count >= 3) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Failed Too Much");
                alert.setHeaderText("Too many failed pin attempts");
                alert.setContentText("Try again in 7 years");
                alert.show();
                Loading.delay(5000,() -> System.exit(0));
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Wrong pin");
                alert.setContentText("You have " + trys + " tries left before the ATM forcibly shuts down");
                alert.show();
            }
        }
    }

    //How to update values without needing to "switch scenes" - for future references
//    public void bal(ActionEvent event) throws Exception {
//        Account.deposit("Checks", 50);
//        Parent create = FXMLLoader.load(getClass().getResource("menu.fxml"));
//        scene = new Scene(create);
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }

}

