

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserProcess")
public class UserProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UserProcess() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter printer = response.getWriter();
		
		String firstName = request.getParameter("first-name");
		String lastName = request.getParameter("last-name");
		String email = request.getParameter("email");
		String zipCode = request.getParameter("zip-code");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm-password");
		String username = request.getParameter("user-name");
		String [] musicGenres = request.getParameterValues("music-genre");
		String wantNotification = request.getParameter("notifications");
		
		if(!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !zipCode.isEmpty() && !password.isEmpty() 
				&& !confirmPassword.isEmpty() && !username.isEmpty())
			{
			
			if (!password.equals(confirmPassword)) {
				printer.println("<html><body><h3>Passwords do not match</h3></body></html>");
				
			} else {
				String out = "<!DOCTYPE html><html lang='en'><head><meta name='viewport' content='width=device-width, initial-scale=1.0'>"
						+ "<link rel='stylesheet' href='style.css'><title>Thank You</title></head>";
				out += "<body><div id='box'><fieldset><h2>Thank you for joining our mailing list</h2><p>Here is the information that you entered</p>"
						+ "<table><tr><th>First Name</th><td>" + firstName +"</td></tr><tr></tr><th>Last Name</th><td>" + lastName + "</td>"
						+ "</tr><tr><th>Email</th><td>" + email + "</td></tr><tr><th>Zip Code</th><td>" + zipCode + "</td></tr><tr><th>Username</th>"
						+ "<td>" + username + "</td></tr><tr><th>Password</th><td>" + password + "</td></tr><th>Favorite Music</th><td>";
				for (String genre : musicGenres) {
					out += genre + ", ";
				}
				out += "</td><tr><th>Receive special sale notification</th><td>" + wantNotification +"</td></tr></table></fieldset></div></body></html>";
				printer.println(out);
			}

		} else {
			printer.println("<html><body><h3>Please fill all mandatory fields</h3></body></html>");
		}
		

	}

}
