import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bandi.Second;

@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");
        int initialAmount = Integer.parseInt(request.getParameter("initialAmount"));
        // Additional parameters
        
        // Call the method from Second class to create an account
        Second.createAccount(username, password, mobile, initialAmount);
        
        // Redirect to a success page
        response.sendRedirect("create_account.jsp");
    }
}

