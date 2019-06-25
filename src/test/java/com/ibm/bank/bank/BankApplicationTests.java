package com.ibm.bank.bank;

import com.ibm.bank.bank.business.CardBusiness;
import com.ibm.bank.bank.entities.Card;
import com.ibm.bank.bank.entities.Client;
import com.ibm.bank.bank.repositories.CardRepository;
import com.ibm.bank.bank.repositories.ClientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BankApplicationTests {

	@Mock
	public CardRepository cardRepository;

	@Mock
	public ClientRepository clientRepository;

	@InjectMocks
	public CardBusiness cardBusiness;

	@Test
	public void testAddCardWhenAllIsOk() {
		Mockito.doReturn(getClient()).when(clientRepository).getOne(Mockito.any());
		cardBusiness.addCard(getCard(), 1L);
		Mockito.verify(cardRepository).save(Mockito.any());
	}

	@Test
	public void testDeleteCardWhenAllIsOkAndReturnFalse(){
		java.util.Optional<Card> card = Optional.of(getCard());
		Mockito.doReturn(card).when(cardRepository).findById(1L);
		boolean flagResult = cardBusiness.deleteCard(1L);
		assertEquals(flagResult, true);
		Mockito.verify(cardRepository).delete(Mockito.any());
	}

	@Test
	public void testEditCardWhenAllIsOkAndReturnFalse(){
		java.util.Optional<Card> card = Optional.of(getCard());
		Mockito.doReturn(card).when(cardRepository).findById(Mockito.any());
		boolean flagResult = cardBusiness.editCard(getCard());
		assertEquals(flagResult, false);
		Mockito.verify(cardRepository).save(Mockito.any());
	}

	private Client getClient(){
		return new Client();
	}

	private Card getCard(){
		return new Card();
	}

}
