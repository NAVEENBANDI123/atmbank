<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="bandi.Second.User" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Actions</title>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        font-family: 'Arial', sans-serif;
        background: url('https://media.istockphoto.com/id/955576348/photo/businessman-calculating-the-conversion-rate-for-the-indian-rupee-money.jpg?s=2048x2048&w=is&k=20&c=QCl-ySHJUYZnXzGlVmduoSLK7c8ukE_xkoAGsn5MMN0=') no-repeat center center fixed;
        background-size: cover;
    }
    .overlay {
        background-color: rgba(255, 255, 255, 0.8);
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
        max-width: 400px;
        width: 100%;
    }
    h2, h3, h4 {
        margin-bottom: 20px;
        color: #333333;
    }
    form {
        margin: 15px 0;
    }
    input[type="number"],
    input[type="submit"] {
        padding: 12px;
        margin: 8px 0;
        border: 1px solid #dddddd;
        border-radius: 5px;
        width: calc(100% - 24px);
        box-sizing: border-box;
    }
    input[type="submit"] {
        background-color: #007bff;
        color: white;
        border: none;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
    input[type="number"] {
        background-color: #f9f9f9;
    }
</style>
</head>
<body>
    <div class="overlay">
        <h2>Welcome, <%= ((User) request.getAttribute("user")).getName() %></h2>
        <h3>Account Number: <%= ((User) request.getAttribute("user")).getAccountNumber() %></h3>
        <h4>Current Balance: $<%= request.getAttribute("balance") %></h4>

        <form action="Deposit" method="post">
            <input type="hidden" name="uname" value="<%= ((User) request.getAttribute("user")).getName() %>">
            <input type="hidden" name="upass" value="<%= ((User) request.getAttribute("user")).getPassword() %>">
            <input type="number" name="uamount" placeholder="Enter amount to deposit" required>
            <input type="submit" value="Deposit">
        </form>

        <form action="Withdraw" method="post">
            <input type="hidden" name="uname" value="<%= ((User) request.getAttribute("user")).getName() %>">
            <input type="hidden" name="upass" value="<%= ((User) request.getAttribute("user")).getPassword() %>">
            <input type="number" name="uamount" placeholder="Enter amount to withdraw" required>
            <input type="submit" value="Withdraw">
        </form>

        <form action="BalanceEnquiry" method="post">
            <input type="hidden" name="uname" value="<%= ((User) request.getAttribute("user")).getName() %>">
            <input type="hidden" name="upass" value="<%= ((User) request.getAttribute("user")).getPassword() %>">
            <input type="submit" value="Balance Enquiry">
        </form>
    </div>
</body>
</html>
