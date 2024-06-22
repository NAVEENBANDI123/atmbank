import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bandi.Second;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("uname");
        String pass = request.getParameter("upass");
        Second.User user = Second.m1(name, pass);
        if (user != null) {
            request.setAttribute("user", user);
            request.setAttribute("balance", user.getAmount());
            request.getRequestDispatcher("/First.jsp").forward(request, response);
        } else {
            response.getWriter().println("Invalid user");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
