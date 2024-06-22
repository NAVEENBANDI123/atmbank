import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bandi.Second;

@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Deposit() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("uname");
        int amount = Integer.parseInt(request.getParameter("uamount"));
        
        try {
            Second.deposit(name, amount);
            request.setAttribute("message", "Deposit successful");
        } catch (Exception e) {
            request.setAttribute("error", "Deposit failed: " + e.getMessage());
        }

        Second.User user = Second.m1(name, request.getParameter("upass"));
        request.setAttribute("user", user);
        request.setAttribute("balance", user.getAmount());
        request.getRequestDispatcher("/First.jsp").forward(request, response);
    }
}
