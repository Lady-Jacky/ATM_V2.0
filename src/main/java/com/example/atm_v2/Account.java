package com.example.atm_v2;

public class Account {
    private static Customer[] account = new Customer[100];
    private static double[] userSavings = new double[100];
    private static double[] userChecks = new double[100];
    private static int count = 0;
    private static String currentUser = "";


    public static void addAccount(Customer thing) {
        account[count] = thing;
        userSavings[count] = 0.00;
        userChecks[count] = 0.00;
        count++;
    }

    public static String getUserSavings() {
        return String.format("%.2f", userSavings[findUser()]);
    }

    public static String getUserChecks() {
        return String.format("%.2f", userChecks[findUser()]);
    }

    private static int findUser() {
        for (int i = 0; i < account.length; i++) {
            if (account[i] != null && account[i].equals(currentUser)) {
                return i;
            }
        }
        return 0;
    }

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

    public static String checkLogIn(String username, String password) {
        if ((username.equals("") || password.equals(""))) {
            return "Username and password cannot be left blank.";
        } else if (checkInfo(username, password) == false) {
            return "Either username or password is wrong.";
        }
        currentUser = username;
        return "You are now logged in";
    }

    public static String withdraw(String account, double total, int fives, int twenties) {
        if (((fives * 5) + (twenties * 20)) != total) {
            return "The withdrawl requirements are impossible";
        }
        if (account.equals("Savings")) {
            if (total > userSavings[findUser()]) {
                return "Balance of account is insufficient";
            } else {
                userSavings[findUser()] -= total;
            }
        } else {
            if (total > userChecks[findUser()]) {
                return "Balance of account is insufficient";
            } else {
                userChecks[findUser()] -= total;
            }
        }
        return "";
    }

    public static String deposit(String account, double amount) {
        if (account.equals("Savings")) {
            userSavings[findUser()] += amount;
            return "Deposit successful";
        } else {
            userChecks[findUser()] += amount;
            return "Deposit successful";
        }
    }
}
