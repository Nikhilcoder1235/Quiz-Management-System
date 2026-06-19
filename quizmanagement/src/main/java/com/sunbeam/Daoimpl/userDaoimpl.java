package com.sunbeam.Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import com.sunbeam.dao.userDao;
import com.sunbeam.entity.Role;
import com.sunbeam.entity.User;
import com.sunbeam.exception.AuthenticationFailedException;
import com.sunbeam.exception.InvalidInputException;
import com.sunbeam.utils.DbUtil;

public class userDaoimpl implements userDao {

	private Connection con;

	public userDaoimpl() throws Exception {
		con = DbUtil.getConnection();
	}

	@Override
	public void close() throws Exception {
		if (con != null)
			con.close();
	}

	@Override
	public int save(User user) throws Exception {
		
		if(!user.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
	        throw new InvalidInputException("Invalid Email Format");

	    if(user.getPassword().length() < 6)
	        throw new InvalidInputException("Password must be at least 6 characters");


		String sql =
		"insert into user(name,email,password,role) values(?,?,?,?)";

		PreparedStatement stmt =
				con.prepareStatement(sql);

		stmt.setString(1, user.getName());
		stmt.setString(2, user.getEmail());
		stmt.setString(3, user.getPassword());

		
		stmt.setString(4,
				user.getRole().name().toLowerCase());

		return stmt.executeUpdate();
	}

	@Override
	public User login(String email, String password)
			throws Exception, AuthenticationFailedException {
		if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
		    throw new InvalidInputException("Invalid Email Format");

		if(password.length() < 6)
		    throw new InvalidInputException("Invalid Password");
		
		String sql =
		"select * from user where email=? and password=?";

		PreparedStatement stmt =
				con.prepareStatement(sql);

		stmt.setString(1, email);
		stmt.setString(2, password);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {

			User u = new User();

			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setEmail(rs.getString("email"));
			u.setPassword(rs.getString("password"));

			
			String role = rs.getString("role");

			u.setRole(
				Role.valueOf(role.toUpperCase()));

			return u;
		}

		throw new AuthenticationFailedException(
		        "Invalid Email or Password");
	}
}