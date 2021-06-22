package thanhdat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import thanhdat.entity.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer>{
	
	@Query(value = "select * from credit_card where person_id = :id", nativeQuery = true)
	public List<CreditCard> getCreditCardsByPersonId(int id);
}
