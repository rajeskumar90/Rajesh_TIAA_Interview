package com.rajesh.springboot.controller;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rajesh.springboot.model.Card;
import com.rajesh.springboot.service.CardService;






@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
	@Autowired
	CardService cardService;
	// -------------------Retrieve All Users---------------------------------------------

	
/*	
	@RequestMapping(value = "/card/", method = RequestMethod.GET)
	public ResponseEntity<Card> listAllCard() {
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		Card card =new Card();
		//card.setCardNumber(123456L);
		return new ResponseEntity<Card>(card,HttpStatus.OK);
	}*/
	
	
	@RequestMapping(value = "/card/{cardType}", method = RequestMethod.GET)
	public ResponseEntity<Card> generateCard(@PathVariable("cardType") String cardType2) {
		
		Card card =new Card();
		card.setCardTpye(cardType2);
		int cardLength=getCardLength(card.getCardTpye());
		String cardStartNumber=getCardFirstDIgit(card.getCardTpye());
		card.setCardNumber(cardService.generate(cardStartNumber, cardLength));
		card.setExpiryDate(getTodaysDate());
		return new ResponseEntity<Card>(card,HttpStatus.OK);
	}
	
	private String getTodaysDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		   LocalDateTime now = LocalDateTime.now();
		   System.out.println(dtf.format(now));
		return dtf.format(now);
	}

	private String getCardFirstDIgit(String cardTpye) {

		if(cardTpye.equalsIgnoreCase("VISA"))
		   return "4";
		if(cardTpye.equalsIgnoreCase("MASTER"))
			return "5";
		if(cardTpye.equalsIgnoreCase("AMERICAN"))
			   return "37";
		if(cardTpye.equalsIgnoreCase("DISCOVER"))
				return "6";
		return null;
	}

	private int getCardLength(String cardTpye) {
		// TODO Auto-generated method stub
		
		
		if(cardTpye.equalsIgnoreCase("VISA"))
		   return 13;
		if(cardTpye.equalsIgnoreCase("MASTER"))
			return 16;
		if(cardTpye.equalsIgnoreCase("AMERICAN"))
			   return 15;
		if(cardTpye.equalsIgnoreCase("DISCOVER"))
				return 16;
		return 0;
	}

	


}