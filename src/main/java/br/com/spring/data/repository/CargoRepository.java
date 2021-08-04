package br.com.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.data.model.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {

}
