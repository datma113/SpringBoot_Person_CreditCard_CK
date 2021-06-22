package thanhdat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thanhdat.entity.CreditCard;
import thanhdat.entity.Person;
import thanhdat.repository.CreditCardRepository;
import thanhdat.repository.PersonRepository;

@RestController
@RequestMapping("/api")
public class CreditCardController {
	@Autowired
	private CreditCardRepository creditCardRepository;
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/credit-cards/{id}")
	public List<CreditCard> getCreditCardsByPersonId(@PathVariable("id")int id) {
		return creditCardRepository.getCreditCardsByPersonId(id);
	}
	
	@PostMapping("/credit-cards/{id}")
	public CreditCard saveCreditCard(@RequestBody CreditCard creditCard,@PathVariable("id")int id) {
		
		Person p = personRepository.getById(id);
		p.addCreditCard(creditCard);
		personRepository.save(p);
		
		creditCard.setId(0);
		creditCard.setPerson(p);
		creditCardRepository.save(creditCard);
		
		return creditCard;
	}
	
	@PutMapping("/credit-cards/{id}")
	public CreditCard updateCreditCard(@RequestBody CreditCard creditCard, @PathVariable("id")int id) {
		Person p = personRepository.getById(id);
		
		creditCard.setPerson(p);
		creditCardRepository.save(creditCard);
		return creditCard;
	}
	
	@DeleteMapping("/credit-cards/{id}")
	public String deleteCreditCard(@PathVariable("id")int id) {
		creditCardRepository.deleteById(id);
		return "delete:" +id;
	}
}
