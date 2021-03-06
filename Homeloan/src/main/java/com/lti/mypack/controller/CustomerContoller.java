package com.lti.mypack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.mypack.model.Customer;
import com.lti.mypack.service.CustomerService;
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("homeloanrest/api")
public class CustomerContoller {
	@Autowired
	CustomerService cService;
	
	@GetMapping("/customer")
	public List<Customer> getAll()
	{
		return cService.getCustomer();
		
	}
	
	@PostMapping("/customer")
	public Customer addValue(@RequestBody Customer customer)
	{
		System.out.println(customer.getAddress());
		return cService.addValue(customer);
	}
	
	@PutMapping("/customer")
	public boolean updateCustomer(@RequestBody Customer customer) {
		return cService.updateCustomer(customer);
	}
	
	@DeleteMapping("/customer")
	public boolean deleteCustomer(@RequestBody Customer customer) {
		return cService.deleteCustomer(customer);
	}
	
	@GetMapping("login/{customerid}/{password}")
	public boolean  FindbyIdandPwd(@PathVariable(value="customerid")int customerid,@PathVariable(value="password")String password){
		return cService.FindbyIdandPwd(customerid, password);
	}
	
	@GetMapping("/customer/{customerid}")
	public Customer getCustomerdetailsById(@PathVariable(value="customerid") int customerid)
	{return cService.findCustomers(customerid);}
}
