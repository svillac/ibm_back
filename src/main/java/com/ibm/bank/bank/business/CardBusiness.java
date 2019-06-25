package com.ibm.bank.bank.business;

import java.util.Objects;
import java.util.Optional;

import com.ibm.bank.bank.entities.Client;
import com.ibm.bank.bank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.bank.bank.entities.Card;
import com.ibm.bank.bank.repositories.CardRepository;

@Component
public class CardBusiness {

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private ClientRepository clientRepository;


	/**
	 * Add Cards
	 * @param card
	 * @return
	 */
	public Card addCard(Card card, Long clientId) {
		Objects.requireNonNull(card);
		Objects.requireNonNull(clientId);

		Client client = this.clientRepository.getOne(clientId);
		card.setClient(client);
		return cardRepository.save(card);
	}

	/**
	 * Delete Card
	 * @param cardId
	 * @return
	 */
	public boolean deleteCard(Long cardId) {
		Objects.requireNonNull(cardId);

		boolean flag = false;
		Optional<Card> card = cardRepository.findById(cardId);

		if(card.isPresent()) {
			cardRepository.delete(card.get());
			flag = true;
		}
		return flag;
	}

	/**
	 * UpdateCard
	 * @param
	 */
	public boolean editCard(Card cardUpdate) {
		Objects.requireNonNull(cardUpdate);
		boolean flag = false;
		Optional<Card> cardToUpdate = cardRepository.findById(cardUpdate.getCardId());
		cardToUpdate.ifPresent(extractCard -> {
			extractCard.setNumberCard(cardUpdate.getNumberCard());
			extractCard.setCsv(cardUpdate.getCsv());
			extractCard.setCardType(cardUpdate.getCardType());
			cardRepository.save(extractCard);
		});
		return flag;
	}

}

