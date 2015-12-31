package com.digitaslbi.helios.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import org.springframework.web.client.RestTemplate;

import com.digitaslbi.helios.dto.Customer;



@Named
@Path("/")
public class OrderRest {
	
	private long id = 1;
	@Inject
	private RestTemplate restTemplate;
	
	
	@GET
	@Path("order")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer submitOrder(@QueryParam("idCustomer") long idCustomer,
	@QueryParam("idProduct") long idProduct){
		System.out.println(idProduct);
		
	Customer customer = restTemplate. getForObject(
	"http://localhost:8080/customer?id={id}", Customer.class,
	idCustomer);

	return customer;
	}
}
