package com.eazybutes.eazybytes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eazybutes.eazybytes.model.Card;
import com.eazybutes.eazybytes.repository.CardRepository;

@RestController
@RequestMapping("cards")
public class CardController {

	private CardRepository cardRepository;

	public CardController(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}
	
    @GetMapping("")
    public List<Card> getAccount(@RequestParam("id") Integer id) {
    	List<Card> cards =this.cardRepository.findByCustomerId(id);
    	
        return cards;
    }

}
