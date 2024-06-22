import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bandi.Second;

@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("username");
        String mobile = request.getParameter("mobile");
        String newPassword = request.getParameter("newPassword");
        
        // Call the method from Second class to update password
        Second.forgotPassword(username, mobile, newPassword);
        
        // Redirect to a success page
        response.sendRedirect("forgotpass.jsp");
    }
}

