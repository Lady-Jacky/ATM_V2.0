package com.example.atm_v2;

public class Account {
    //Account class's instance variables
    private static Customer[] account = new Customer[100];
    private static double[] userSavings = new double[100];
    private static double[] userChecks = new double[100];
    private static int count = 0;
    private static String currentUser = "";
    private static int transactionID = 10000;

    //the method that adds a Customer object to the account array and sets up the user's savings and checks account
    public static void addAccount(Customer thing) {
        account[count] = thing;
        userSavings[count] = 0.00;
        userChecks[count] = 0.00;
        count++;
    }

    //returns the user's pin
    public static String getUserPin() {
        return account[findUser()].getPin();
    }

    //returns the user's savings balance
    public static String getUserSavings() {
        return String.format("%.2f", userSavings[findUser()]);
    }

    //returns the user's checks balance
    public static String getUserChecks() {
        return String.format("%.2f", userChecks[findUser()]);
    }

    //returns the user's index in the acocunt array
    private static int findUser() {
        for (int i = 0; i < account.length; i++) {
            if (account[i] != null && account[i].equals(currentUser)) {
                return i;
            }
        }
        return 0;
    }

    //The method sets the user's pin to the new pin
    public static void setPin(String newPin) {
         account[findUser()].setPin(newPin);
    }

    //The method that just checks to see if the username entered by the user is available or not. This would've been
    // used if I included a log-out button, but I never did.
    public static boolean checkAvaliability(String username) {
        if (account.length >= 0) {
            for (Customer user : account) {
                if (user == null) {
                    return true;
                }
                if (user.getName().equals(username)) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

//returns the current user
    public static String getCurrentUser() {
        return currentUser;
    }
//sets the current user
    public static void setCurrentUser(String user) {
        currentUser = user;
    }
//checks the info of the specified user and see if the account that they entered is or is not an actual account
// that was created
    public static boolean checkInfo(String username, String password) {
        if (account.length >= 0) {
            for (int i = 0; i < account.length; i++) {
                if (account[i] != null && account[i].getName().equals(username)) {
                    if (password.equals(account[i].getPin())) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            return false;
        }
    }
//The method that actually creates the account and adds it to the accounts array
    public static String createAccount(String username, String password) {
        checkAvaliability(username);
        if (checkAvaliability(username) == false) {
            return "Username already taken. Please choose\na new one";
        } else if ((username.equals("") || password.equals(""))) {
            return "Username and password cannot be left blank.";
        } else {
            Customer thing = new Customer(username, password);
            addAccount(thing);
            return "Account created. Return and log in";
        }
    }
    //The method that would allow the user to log-in if they entered the correct information
    public static String checkLogIn(String username, String password) {
        if ((username.equals("") || password.equals(""))) {
            return "Username and password cannot be left blank.";
        } else if (checkInfo(username, password) == false) {
            return "Either username or password is wrong.";
        }
        setCurrentUser(username);
        return "You are now logged in";
    }

    //The method in Account that makes sure that the specified account has enough money to be withdrawn/
    // the class that does all the math for withdrawl
    public static boolean canWithdraw(String account, double total, int fives, int twenties) {
        if (total % 5 != 0) {
            return false;
        } else if (((fives * 5) + (twenties * 20)) != total) {
            return false;
        }
        if (account.equals("Savings")) {
            if (total > userSavings[findUser()]) {
                return false;
            }
        } else {
            if (total > userChecks[findUser()]) {
                return false;
            }
        }
        return true;
    }

    //The method in Account that initiates the withdrawl of money in the ATM class
    public static String withdraw(String account, double total, int fives, int twenties) {
        if (total % 5 != 0) {
            return "Invalid withdrawl amount";
        }
        if (((fives * 5) + (twenties * 20)) != total) {
            return "Math does not add up";
        }
        if (account.equals("Savings")) {
            if (total > userSavings[findUser()]) {
                return "Insufficient account funds";
            } else {
                userSavings[findUser()] -= total;
            }
        } else {
            if (total > userChecks[findUser()]) {
                return "Insufficient account funds";
            } else {
                userChecks[findUser()] -= total;
            }
        }
        return "";
    }

    //The method in Account that initiates the deposit of money in the ATM class
    public static void deposit(String account, double amount) {
        if (account.equals("Savings")) {
            userSavings[findUser()] += amount;
        } else if (account.equals("Checks")) {
            userChecks[findUser()] += amount;
        }
    }
    //The method in Account that initiates the transfer of money in the ATM class
    public static String transfer(String account, double amount) {
        if (account.equals("Savings")) {
            if (userSavings[findUser()] >= amount) {
                deposit("Checks", amount);
                userSavings[findUser()] -= amount;
            } else {
                return "Insufficient Balance";
            }
        } else if (account.equals("Checks")) {
            if (userChecks[findUser()] >= amount) {
                deposit("Savings", amount);
                userChecks[findUser()] -= amount;
            } else {
                return "Insufficient Balance";
            }
        }
        return "Transfer successful";
    }

    //Checks to make sure that whichever account is selected has the specified amount of money in it.
    public static boolean enough(String account, double amount) {
        if (account.equals("Savings")) {
            if (userSavings[findUser()] < amount) {
                return false;
            }
        } else if (account.equals("Checks")) {
            if (userChecks[findUser()] < amount) {
                return false;
            }
        }
        return true;
    }

    //returns a string of information about the user's account that I could use in the receipts
    public static String getBal() {
        transactionID++;
        return "Savings Balance: $" + getUserSavings() + "\nChecks Balance: $" + getUserChecks()
                + "\nTransaction ID: " + transactionID;
    }
}
