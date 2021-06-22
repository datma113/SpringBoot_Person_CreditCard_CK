package thanhdat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thanhdat.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

}
