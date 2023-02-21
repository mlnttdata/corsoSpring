package com.example.esercitazione_21_02.Repository;

import com.example.esercitazione_21_02.Domain.Corso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorsoRepository extends JpaRepository<Corso, Long> {

}