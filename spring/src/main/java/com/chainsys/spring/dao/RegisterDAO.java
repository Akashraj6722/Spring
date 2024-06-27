package com.chainsys.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.spring.mapper.UserMapper;
import com.chainsys.spring.model.Details;

@Repository
public class RegisterDAO implements UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	UserMapper userMapper;

	public void insert(Details details) {

		String command = "INSERT INTO list(name,email,phone,password) VALUES(?,?,?,?)";

		Object[] parameter = { details.getName(), details.getMail(), details.getPhone(), details.getPassword() };
		int rows = jdbcTemplate.update(command, parameter);

		System.out.println("inserting....");

	}

	public List<Details> read() {

		String command = "SELECT name,email,phone,password FROM list";

		List<Details> list = jdbcTemplate.query(command, new UserMapper());

		System.out.println("reading....");
		return list;

	}

	public boolean check(Details details) {

		String command = "SELECT * FROM list WHERE email=? AND password=?";

		try {
			Details record = jdbcTemplate.queryForObject(command, new UserMapper(), details.getMail(),
					details.getPassword());
			System.out.println("checking....");
			return record != null;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Details> search(Details details) {
		String command = "SELECT id, name, email, phone, password FROM list WHERE name=?";

		List<Details> records = jdbcTemplate.query(command, new UserMapper(), details.getName());

		System.out.println("searching....");

		return records;
	}

	public int update(Details details) {

		String command = "UPDATE list SET name=?,phone=?,password=? WHERE email=?";

		Object[] parameter = { details.getName(), details.getPhone(), details.getPassword(), details.getMail() };
		int rows = jdbcTemplate.update(command, parameter);

		System.out.println("upating....");
		return rows;

	}

	public int delete(Details details) {

		String command = "DELETE FROM list WHERE email=?";

		Object[] parameter = { details.getMail() };
		int rows = jdbcTemplate.update(command, parameter);

		System.out.println("deleted...");
		return rows;

	}
}
