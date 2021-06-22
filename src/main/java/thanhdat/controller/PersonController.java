package thanhdat.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thanhdat.entity.Person;
import thanhdat.repository.PersonRepository;

@RestController
@RequestMapping("/api")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/")
	public String home() {
		return "hello world";
	}
	
	@GetMapping("/persons")
	public List<Person> getPersons() {
		return personRepository.findAll();
	}
	
	@GetMapping("/persons/{id}")
	public Optional<Person> getPersonById(@PathVariable("id")int id) {	
		return personRepository.findById(id);
	}
	
	
	
	
	@PostMapping("/persons")
	public Person savePerson(@RequestBody Person p) {
		p.setId(0);
		personRepository.save(p);
		return p;
	}
	
	@PutMapping("/persons")
	public Person updatePerson(@RequestBody Person p) {
		personRepository.save(p);
		return p;
	}
	@DeleteMapping("/persons/{id}")
	public String deletePerson(@PathVariable("id") int id) {
		personRepository.deleteById(id);
		return "delete: "+id;
	}
}
