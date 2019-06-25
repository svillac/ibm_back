package com.ibm.bank.bank.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Client {
	
	@Id
	@GeneratedValue
	private Long clientId;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="client")
	private Set<Card> cards;
	
	private String name;
	
	private String dir;
	
	private String tel;
	
	private String city;

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "Client{" +
				"clientId=" + clientId +
				", name='" + name + '\'' +
				", dir='" + dir + '\'' +
				", tel='" + tel + '\'' +
				", city='" + city + '\'' +
				", cards=" + cards +
				'}';
	}
}
