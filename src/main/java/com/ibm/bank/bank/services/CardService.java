package com.ibm.bank.bank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ibm.bank.bank.business.CardBusiness;
import com.ibm.bank.bank.business.ClientBusiness;
import com.ibm.bank.bank.entities.Card;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CardService {
	
	@Autowired
	private CardBusiness business;
	
	@Autowired
	private ClientBusiness clientBusiness;
	
	@RequestMapping(value = "/addCard/{clientId}", method = RequestMethod.POST)
	public Card addCard(@RequestBody Card card,  @PathVariable Long clientId) {
		return business.addCard(card, clientId);
	}
	
	@RequestMapping(value = "/deleteCard/{cardId}", method = RequestMethod.DELETE)
	public boolean deleteCard(@PathVariable Long cardId) {
		return business.deleteCard(cardId);
	}

	@RequestMapping(value = "/editCard", method = RequestMethod.PUT)
	public boolean editCard(@RequestBody Card card) {
		return business.editCard(card);
	}

}
