package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import com.controller.UserController;
import com.controller.UserControllerImplements;


@WebServlet("/login")
public class login extends HttpServlet {
 
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String un=request.getParameter("username");
		String pwd= request.getParameter("password");
		
		String hashPwd= DigestUtils.shaHex(pwd.getBytes());
		
		UserController uc= new UserControllerImplements();
		
		
		if(uc.userLogin(un, hashPwd)==true)
		{
			HttpSession session= request.getSession();
			
			session.setAttribute("activeUser", un);
			request.setAttribute("user", un);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
		else
		{
			request.setAttribute("error","Username/Password Incorrect");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

}
