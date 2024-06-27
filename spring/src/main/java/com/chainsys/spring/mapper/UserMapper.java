package com.chainsys.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.spring.model.Details; 

public class UserMapper implements RowMapper<Details> {

	@Override
	public Details mapRow(ResultSet rs, int rowNum) throws SQLException {
		Details details = new Details();
		
		String name=rs.getString("name");
		String mail=rs.getString("email");
		String phone=rs.getString("phone");
		String pass=rs.getString("password");
		
		details.setName(name);
		details.setMail(mail);
		details.setPhone(phone);
		details.setPassword(pass);
		
		System.out.println("mapper");
		
		return details;

		
		
		
		
	}
	
	

}
