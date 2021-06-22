package thanhdat.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CreditCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String type;
	@ManyToOne
	@JoinColumn(name = "personId")
	private Person person;
	
	
	
	public CreditCard(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CreditCard() {
		super();
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", type=" + type + "]";
	}

}
