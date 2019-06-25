package com.ibm.bank.bank.business;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.bank.bank.entities.Client;
import com.ibm.bank.bank.repositories.ClientRepository;

@Component
public class ClientBusiness {
	
	@Autowired
	private ClientRepository repository;
	
	/**
	 * Método que retorna todos los clientes
	 * @return
	 */
	public List<Client> getAllClient() {
		return repository.findAll();
	}

	/**
	 * Trae el cliente por el Id
	 * @param id
	 * @return
	 */
	public Optional<Client> getClientById(Long id) {
		return repository.findById(id);
	}

	/**
	 * Add el cliente
	 * @param client
	 * @return
	 */
	public Client addClient(Client client) {
		return repository.save(client);
	}

	/**
	 * Borra el cliente por su Id
	 * @param id
	 * @return
	 */
	public boolean deleteClient(Long id) {
		boolean flag = false;
		Optional<Client> client = repository.findById(id);

		if(client.isPresent()) {
			repository.delete(client.get());
			flag = true;
		}
		return flag;
	}

	/**
	 * Edicion de Cliente
	 * @param cliente
	 * @return Boolean
	 */
	public boolean editClient(Client cliente) {
		boolean bandera = false;
		Objects.requireNonNull(cliente, "Mensaje incorrecto");
		Optional<Client> client = repository.findById(cliente.getClientId());
		
		if(client.isPresent()) {
			repository.save(cliente);
			bandera = true;
		}
		return bandera;
	}
}
