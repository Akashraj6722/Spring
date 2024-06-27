package com.chainsys.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.spring.model.Details;
@Repository
public interface UserDAO {
	
	public void insert(Details details);
	
	public List<Details> read();
	
	public boolean check(Details details);
	
	public List<Details> search(Details details);
	
	public int update(Details details);
	
	public int delete(Details details);
}
