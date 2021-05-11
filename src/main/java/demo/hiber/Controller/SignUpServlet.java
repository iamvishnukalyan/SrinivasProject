package demo.hiber.Controller;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.hiber.Model.SignUpUser;
import demo.hiber.Service.LoginService;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
Scanner sc = new Scanner(System.in);
		
		String id = request.getParameter("userid");
		String pwd = request.getParameter("password");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		int age1 = Integer.parseInt(age);
		String phnNum = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		
		SignUpUser customer = new SignUpUser();
		customer.setUserid(id);
		customer.setPassword(pwd);
		customer.setName(name);
		customer.setAge(age1);
		customer.setPhoneNumber(phnNum);
		customer.setEmail(email);
		customer.setAddress(address);
		customer.setCity(city);
		
		int value = LoginService.UserInsertion(customer);
		if (value == 1) {
			System.out.println("Sign Up Done");	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
