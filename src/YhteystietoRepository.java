package com.example.Osoitemuistio;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface YhteystietoRepository extends CrudRepository<Yhteystieto, Long> {

    List<Yhteystieto> findBySukunimi(String sukunimi);
   
	void deleteById(Long id);

}