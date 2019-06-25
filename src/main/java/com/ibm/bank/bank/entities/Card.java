package com.ibm.bank.bank.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Card {
	
	@Id
	@GeneratedValue
	private Long cardId;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "client_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Client client;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "card")
	private Set<Product> products;

	private String numberCard;

	private String csv;
	
	private String cardType;

	public String getNumberCard() {
		return numberCard;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public void setNumberCard(String numberCard) {
		this.numberCard = numberCard;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getCsv() {
		return csv;
	}

	public void setCsv(String csv) {
		this.csv = csv;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	@Override
	public String toString() {
		return "Card{" +
				"cardId=" + cardId +
				", numberCard='" + numberCard + '\'' +
				", client=" + client +
				", products=" + products +
				", csv='" + csv + '\'' +
				", cardType='" + cardType + '\'' +
				'}';
	}
}
