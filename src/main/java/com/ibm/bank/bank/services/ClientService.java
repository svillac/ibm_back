package com.ibm.bank.bank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bank.bank.business.ClientBusiness;
import com.ibm.bank.bank.entities.Client;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ClientService {
	
	@Autowired
	private ClientBusiness business;

	@RequestMapping(value = "/getAllClient", method = RequestMethod.GET)
	public List<Client> getAllClient() {
		return business.getAllClient();
	}
	
	@RequestMapping(value = "/getClient", method = RequestMethod.GET)
	public Optional<Client> getClient(@RequestParam Long id) {
		return business.getClientById(id);
	}
	
	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	public Client addClient(@RequestBody Client cliente ) {
		return business.addClient(cliente);
	}
	
	@RequestMapping(value = "/deleteClient", method = RequestMethod.GET)
	public boolean deleteClient(@RequestParam Long id) {
		return business.deleteClient(id);
	}

	@RequestMapping(value = "/editClient", method = RequestMethod.POST)
	public boolean editClient(@RequestBody Client cliente) {
		return business.editClient(cliente);
	}
}
