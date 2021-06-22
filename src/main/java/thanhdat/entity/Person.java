package thanhdat.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	
	
	
	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}
	@OneToMany(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<CreditCard> creditCards;
	
	

	public Person(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.creditCards = new ArrayList<CreditCard>();
	}
	
	public void addCreditCard(CreditCard c) {
		creditCards.add(c);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
}
