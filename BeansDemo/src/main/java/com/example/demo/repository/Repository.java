package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

public interface Repository <T,Id>{
	T SAVE(T t);
	Optional<T> findById(Id id);
	List<T> finaAll();
	boolean existsById(Id id);
	void deleteById(Id id);
	
	

}
