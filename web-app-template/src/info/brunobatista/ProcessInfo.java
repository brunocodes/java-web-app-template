package info.brunobatista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/ProcessInfo")
public class ProcessInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public ProcessInfo() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}
	
	// doPost Method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		String url = "/displayinfo.jsp";
		//
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		
		// if regexChecker not equal to fName
		if (!regexChecker("^[A-Za-z\\.\\' \\-]{2,30}$", fName)) {
			// reload page to index.jsp
			url = "/register.jsp";
			// Error message fName equal to
			fName = "Try Again";
		}
		
		// if regexChecker not equal to lName
		if (!regexChecker("^[A-Za-z\\.\\' \\-]{2,30}$", lName)) {
			// reload page to index.jsp
			url = "/register.jsp";
			// Error message lName equal to
			lName = "Try Again";
		}
		
		// if regexChecker not equal to street
		if (!regexChecker("^[A-Za-z0-9\\.\\' \\-]{5,50}$", street)) {
			// reload page to index.jsp
			url = "/register.jsp";
			// Error message street equal to
			street = "Try Again";
		}
		
		// if regexChecker not equal to city
		if (!regexChecker("^[A-Za-z\\.\\' \\-]{2,30}$", city)) {
			// reload page to index.jsp
			url = "/register.jsp";
			// Error message city equal to
			city = "Try Again";
		}
		
		// if regexChecker not equal to state
		if(!regexChecker("^(?:(A[KLRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|M[ADEINOST]|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY]))$", state)) {
			url = "/register.jsp";
			state = "Try again";
		}
		
		// if regexChecker not equal to zipcode
		if(!regexChecker("^[0-9\\-]{5,10}$", zipcode)) {
			url = "/register.jsp";
			zipcode = "Try again";
		}
		
		if(!regexChecker("^[A-Za-z0-9._\\%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$", email)) {
			url = "/register.jsp";
			email = "Try again";
		}
		
		// Must have 1 uppercase, 1 lowercase, 1 number and a special
		if(!regexChecker("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$", password)) {
			url = "/register.jsp";
			password = "Try again";
		}
		
		if(!regexChecker("^([0-9]( |-)?)?(\\(?[0-9]{3}\\)?|[0-9]{3})( |-)?([0-9]{3}( |-)?[0-9]{4}|[0-9]{7})$", phone)) {
			url = "/register.jsp";
			phone = "Try again";
		}
		
		
		// if url not equal to index.jsp
		if(!url.equals("/register.jsp")) {
			// updateDB with request.getParameter("Parameter")
			updateDB(fName, lName, street, city, state, zipcode, email, password ,phone);
		}
		
		//Creates object instance from the Customer java bean class
		// and passes in request.getParameter("Parameter")
		// to pass to displayinfo.jsp
		Customer cust = new Customer(fName, lName, street, city, state, zipcode, email, password ,phone);
		
		// setAttribute to the cust object
		request.setAttribute("cust", cust);
		getServletContext().getRequestDispatcher(url)
		.forward(request, response);		
	}
	
	protected void updateDB(String fName,String lName,String street, String city, String state, String zipcode, String email, String password ,String phone) {
		
		Connection con;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/jee_test_db_2?useTimezone=true&serverTimezone=UTC";			
			String user = "jeedbadmin2";
			String pw = "321654987";
			con = DriverManager.getConnection(url, user, pw);
			Statement s = con.createStatement();
			String query = "INSERT INTO CUSTOMER " + 
			        "(fname, lname, street, city, state, zipcode, email, password, phone, cust_id) " + 
			        "VALUES ('" + fName + "', '" + lName + "', '" +
			        street + "', '" + city + "', '" + state + "', '" +
			        zipcode + "', '" + email + "', '" + password + "', '" +
			        phone + "', NULL)";
			
			s.executeUpdate(query);
			
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	static boolean regexChecker(String theRegex, String Str2Check) {
		
		Pattern regexPattern = Pattern.compile(theRegex);
		Matcher regexMatcher = regexPattern.matcher(Str2Check);
		if (regexMatcher.matches()) {
			return true;
		} else {
			return false;
		}
						
	}
	

}