package com.gabryelapi.repository;

import com.gabryelapi.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
    List<Personagem> findByhouse(String id);

}