package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.UserController;
import com.controller.UserControllerImplements;
import com.model.User;

/**
 * Servlet implementation class edit
 */
@WebServlet("/edit")
public class edit extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String username = request.getParameter("username");
        
        UserController uc = new UserControllerImplements();
      User user = uc.getUserById(id);
        
        if (user != null) {
        
            User userToUpdate = user;
            userToUpdate.setFname(fname);
            userToUpdate.setLname(lname);
            userToUpdate.setUsername(username);
            
            boolean editSuccess = uc.editUser(userToUpdate);
            
            if (editSuccess) {
            	System.out.println("change vayo");
                response.sendRedirect("table.jsp");
                return;
            } else {
                response.sendRedirect("error.jsp");
                return;
            }
        }
        
        response.sendRedirect("error.jsp");
    }
}
