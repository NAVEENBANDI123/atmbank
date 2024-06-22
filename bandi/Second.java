package bandi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Second {

    public static class User {
        private String name;
        private String password;
        private String mobile;
        private int amount;
        private int accountNumber;
        private int initialAmount;

        public User(int accountNumber, String name, String password, String mobile, int amount) {
            this.accountNumber = accountNumber;
            this.name = name;
            this.password = password;
            this.mobile = mobile;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }

        public String getMobile() {
            return mobile;
        }

        public int getAmount() {
            return amount;
        }

        public int getAccountNumber() {
            return accountNumber;
        }
    }

    public static User m1(String name, String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atm", "root", "Naveen@143");
            PreparedStatement ps = con.prepareStatement("select * from user where name=? and password=?");
            ps.setString(1, name);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int accountNumber = rs.getInt(1);
                String userName = rs.getString(2);
                String password = rs.getString(3);
                String mobile = rs.getString(4);
                int amount = rs.getInt(5);

                return new User(accountNumber, userName, password, mobile, amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getBalance(String name) {
        int balance = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atm", "root", "Naveen@143");
            PreparedStatement ps = con.prepareStatement("select amount from user where name=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                balance = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }
    public static void deposit(String name, int depositAmount) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atm", "root", "Naveen@143");
            PreparedStatement ps = con.prepareStatement("update user set balance = balance + ? where name = ?");
            ps.setInt(1, depositAmount);
            ps.setString(2, name);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Deposit successful");
            } else {
                System.out.println("Deposit failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void balanceEnquiry(String name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atm", "root", "Naveen@143");
            PreparedStatement ps = con.prepareStatement("select balance from user where name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Current Balance: " + rs.getInt(1));
            } else {
                System.out.println("User not found");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void withdraw(String name, int withdrawAmount) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atm", "root", "Naveen@143");
            PreparedStatement ps1 = con.prepareStatement("select balance from user where name = ?");
            ps1.setString(1, name);
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                int currentAmount = rs.getInt(1);
                if (currentAmount >= withdrawAmount) {
                    PreparedStatement ps2 = con.prepareStatement("update user set balance = balance - ? where name = ?");
                    ps2.setInt(1, withdrawAmount);
                    ps2.setString(2, name);
                    int rowsAffected = ps2.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Withdrawal successful");
                    } else {
                        System.out.println("Withdrawal failed");
                    }
                } else {
                    System.out.println("Insufficient balance");
                }
            } else {
                System.out.println("User not found");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        }
        public static void createAccount(String name, String password, String mobile, int initialAmount) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atm", "root", "Naveen@143");
                PreparedStatement ps = con.prepareStatement("insert into user (name, password, mobile, balance) values (?, ?, ?, ?)");
                ps.setString(1, name);
                ps.setString(2, password);
                ps.setString(3, mobile);
                ps.setInt(4, initialAmount);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Account created successfully");
                } else {
                    System.out.println("Account creation failed");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void forgotPassword(String name,String mobile, String newPassword) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atm", "root", "Naveen@143");
                PreparedStatement ps = con.prepareStatement("update user set password = ? where name = ? AND mobile=?");
                ps.setString(1, newPassword);
                ps.setString(2, name);
                ps.setString(3, mobile);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Password updated successfully");
                } else {
                    System.out.println("Password update failed");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
    }
}
