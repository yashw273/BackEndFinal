package com.lti.mypack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.mypack.model.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	/* public String addvalues(Personal personal); */

	
	@Query("from Customer c where c.customerid LIKE ?1 AND c.password LIKE ?2")
	public List<Customer> FindbyIdandPwd(int customerid, String password);
	
}