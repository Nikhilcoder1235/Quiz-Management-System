package com.sunbeam.dao;

import com.sunbeam.entity.User;

public interface userDao extends AutoCloseable {

	    int save(User user) throws Exception;
	 User login(String email,String password) throws Exception;
  
	
}
