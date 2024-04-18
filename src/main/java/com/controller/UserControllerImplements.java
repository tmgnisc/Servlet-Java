package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.User;

public class UserControllerImplements  implements UserController{

	Connection conn=null;
	public UserControllerImplements()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");

		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@Override
	public boolean addUser(User u) {
		
		String sql="insert into usertable(fname,lname,username,password) values(?,?,?,?)";
		
		try {
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setString(1,u.getFname() );
			pstm.setString(2,u.getLname() );
			pstm.setString(3,u.getUsername() );
			pstm.setString(4, u.getPassword());
			
			
			pstm.execute();
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return false;
	}


	@Override
	public boolean userLogin(String un, String pwd) {
	boolean answer=false;
		
		String sql="select * from usertable where username=? and password=?";
		try {
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setString(1, un);
			pstm.setString(2, pwd);
			ResultSet rs=pstm.executeQuery();
			
			if(rs.next())
			{
				answer=true;
			}
			else {
				answer=false;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return answer;
	}


	@Override
	public List<User> getAllData() {
		List<User> userList= new ArrayList<>();
		String sql="select * from usertable";
		try {
			Statement stm= conn.createStatement();
			ResultSet rs= stm.executeQuery(sql);
			
			while(rs.next())
			{
				User u= new User();
				u.setId(rs.getInt("id"));
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));			
				userList.add(u);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return userList;
	}


	@Override
	public boolean deleteAUser(int id) {
		String sql="delete from usertable where id="+id;
		
		try {
			Statement stm=conn.createStatement();
			stm.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}


	@Override
	public User getUserById(int id) {
	    User u = null; // Initialize the user object as null
	    String sql = "select * from usertable where id=" + id;
	    try {
	        Statement stm = conn.createStatement();
	        ResultSet rs = stm.executeQuery(sql);
	        
	        if (rs.next()) { // Move the cursor to the first row
	            u = new User(); // Initialize the user object inside the loop
	            u.setId(rs.getInt("id"));
	            u.setFname(rs.getString("fname"));
	            u.setLname(rs.getString("lname"));
	            u.setUsername(rs.getString("username"));
	            u.setPassword(rs.getString("password"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return u; // Return the user object (which could be null if user not found)
	}

	@Override
	public boolean editUser(User u) {
		
		String sql = "UPDATE usertable SET fname=?, lname=?, username=? WHERE id=?";
	    
	    try {
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setString(1, u.getFname());
	        pstm.setString(2, u.getLname());
	        pstm.setString(3, u.getUsername());
	        pstm.setInt(4, u.getId()); 
	        
	        int rowsUpdated = pstm.executeUpdate();
	        
	        if (rowsUpdated > 0) {
	            return true; // Update successful
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return false; // Update failed
	}

	
	
	
}
